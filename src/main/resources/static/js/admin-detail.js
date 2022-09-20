const wrapper = document.getElementById("order-card-admin");

wrapper.addEventListener("click", (e) => {
  if (e.target.classList.contains("button-process")) {
    const processButton = e.target;
    const orderId = processButton.dataset.order_id;
    console.log(orderId);
    const option = {
      method: "PUT",
    };
    fetch("http://localhost:8080/admin/orders/prepare/" + orderId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log(err));
  }
});
