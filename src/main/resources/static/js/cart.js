// const deleteButton = document.getElementById("deleteButton");

// deleteButton.addEventListener("click", (e) => {
//   const productId = e.currentTarget.dataset.productId;
//   console.log(productId);
// });
const tbody = document.getElementById("tbody");
const quantityCartText = document.getElementsByClassName("quantity-cart");
const totalCartItemTexts = document.getElementsByClassName("total-cart-item");
const priceCartTexts = document.getElementsByClassName("price-cart");
const totalCartEl = document.getElementById("total-cart");
tbody.addEventListener("click", (e) => {
  console.log("event tbody");
  let price;
  let totalCartItem;
  let quantity;
  let totalCart = 0;

  for (let i = 0; i < priceCartTexts.length; i++) {
    if (priceCartTexts[i].dataset.cartid === e.target.dataset.cartid) {
      price = parseFloat(priceCartTexts[i].innerHTML.slice(1));
      break;
    }
  }

  if (e.target.classList.contains("delete-button")) {
    const deleteButton = e.target;
    const cartId = deleteButton.dataset.cartid;
    console.log(cartId);
    const option = {
      method: "PUT",
    };
    fetch("http://localhost:8080/cart/delete/" + cartId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log);
  } else if (e.target.classList.contains("plus-button")) {
    for (let i = 0; i < quantityCartText.length; i++) {
      if (quantityCartText[i].dataset.cartid === e.target.dataset.cartid) {
        quantity = parseInt(quantityCartText[i].value) + 1;
        quantityCartText[i].value = parseInt(quantityCartText[i].value) + 1;
        quantityCartText[i].dispatchEvent(
          new Event("change", { bubbles: true })
        );
        break;
      }
    }
  } else if (e.target.classList.contains("minus-button")) {
    for (let i = 0; i < quantityCartText.length; i++) {
      if (quantityCartText[i].dataset.cartid === e.target.dataset.cartid) {
        quantity = parseInt(quantityCartText[i].value) - 1;
        quantityCartText[i].value = parseInt(quantityCartText[i].value) - 1;
        quantityCartText[i].dispatchEvent(
          new Event("change", { bubbles: true })
        );
        break;
      }
    }
  }

  for (let i = 0; i < totalCartItemTexts.length; i++) {
    if (totalCartItemTexts[i].dataset.cartid === e.target.dataset.cartid) {
      totalCartItemTexts[i].innerHTML = "$" + price * quantity;
      console.log(totalCartItemTexts[i].innerHTML);
    }
    totalCart =
      parseFloat(totalCartItemTexts[i].innerHTML.slice(1)) + totalCart;
  }

  totalCartEl.innerHTML = totalCart;
});

tbody.addEventListener("change", (e) => {
  console.log("event change tbody");

  if (e.target.classList.contains("quantity-cart")) {
    const textNumber = e.target;
    const cartId = textNumber.dataset.cartid;
    console.log(cartId, textNumber.value);
    const option = {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ quantity: textNumber.value, id: cartId }),
    };
    fetch("http://localhost:8080/cart/add", option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log);
  }
});
