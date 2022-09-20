// const tabPanelEl = document.getElementsByClassName("tab-panel");
// const sideMenuEl = document.getElementById("side-menu");
// const collapseEl = document.getElementsByClassName("collapse");

// sideMenuEl.addEventListener("click", (e) => {
//   const selEl = e.target;

//   for (let i = 0; i < tabPanelEl.length; i++) {
//     if (tabPanelEl[i].classList.contains("active")) {
//       tabPanelEl[i].classList.remove("active");
//     }
//   }

//   selEl.classList.add("active");

//   if (selEl.classList.contains("tab-panel-main")) {
//     for (let i = 0; i < collapseEl.length; i++) {
//       if (collapseEl[i].dataset.id !== e.target.dataset.id) {
//         collapseEl[i].classList.remove("show");
//       } else {
//         const tabPanelSubEl = collapseEl[i].querySelectorAll(".tab-panel-sub");
//         const tagActive = true;
//         // for (let j = 0; j < tabPanelSubEl.length; j++) {
//         //   if (tabPanelSubEl[j].classList.contains("active")) {
//         //     tagActive = false;
//         //   }
//         // }
//         // if (tagActive) {
//         //   window.location.href = tabPanelSubEl[0].href;
//         // }
//         tabPanelSubEl[0].classList.add("active");
//         selEl.classList.remove("active");
//       }
//     }
//   }
// });

const wrapper = document.getElementById("card-wrapper");

wrapper.addEventListener("click", (e) => {
  if (e.target.classList.contains("button-receive")) {
    const processButton = e.target;
    const orderId = processButton.dataset.order_id;
    console.log(orderId);
    const option = {
      method: "PUT",
    };
    fetch("http://localhost:8080/order/receive/" + orderId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log(err));
  } else if (e.target.classList.contains("button-cancel")) {
    const processButton = e.target;
    const orderId = processButton.dataset.order_id;
    console.log(orderId);
    const option = {
      method: "PUT",
    };
    fetch("http://localhost:8080/order/receive/" + orderId, option)
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
