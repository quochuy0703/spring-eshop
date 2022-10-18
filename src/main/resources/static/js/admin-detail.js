const wrapper = document.getElementById("order-card-admin");
const descHighlightEl = document.getElementsByClassName("desc-highlight");
const titleHighlightEl = document.getElementsByClassName("title-highlight");
const buttonSaveEl = document.getElementsByClassName("button-save-highlight");
const buttonEditEl = document.getElementsByClassName("button-edit-highlight");

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
  } else if (e.target.classList.contains("button-edit-highlight")) {
    const editButton = e.target;
    const productId = editButton.dataset.product_id;

    for (let i = 0; i < descHighlightEl.length; i++) {
      if (descHighlightEl[i].dataset.product_id === productId) {
        descHighlightEl[i].contentEditable = true;
        descHighlightEl[i].style.backgroundColor = "#dddbdb";
      } else {
        descHighlightEl[i].contentEditable = false;
        descHighlightEl[i].style.backgroundColor = "inherit";
      }
    }
    for (let i = 0; i < titleHighlightEl.length; i++) {
      if (titleHighlightEl[i].dataset.product_id === productId) {
        titleHighlightEl[i].contentEditable = true;
        titleHighlightEl[i].style.backgroundColor = "#dddbdb";
      } else {
        titleHighlightEl[i].contentEditable = false;
        titleHighlightEl[i].style.backgroundColor = "inherit";
      }
    }
    for (let i = 0; i < buttonSaveEl.length; i++) {
      if (buttonSaveEl[i].dataset.product_id === productId) {
        buttonSaveEl[i].classList.remove("disabled");
        editButton.classList.add("disabled");
      }
    }
  } else if (e.target.classList.contains("button-save-highlight")) {
    const saveButton = e.target;
    const productId = saveButton.dataset.product_id;
    let desc = null;
    let title = null;

    for (let i = 0; i < buttonEditEl.length; i++) {
      if (buttonEditEl[i].dataset.product_id === productId) {
        buttonEditEl[i].classList.remove("disabled");
        saveButton.classList.add("disabled");
      }
    }

    for (let i = 0; i < descHighlightEl.length; i++) {
      if (descHighlightEl[i].dataset.product_id === productId) {
        desc = descHighlightEl[i].innerHTML;
      }
    }

    for (let i = 0; i < titleHighlightEl.length; i++) {
      if (titleHighlightEl[i].dataset.product_id === productId) {
        title = titleHighlightEl[i].innerHTML;
      }
    }

    const option = {
      method: "PUT",
      credentials: "same-origin", // include, *same-origin, omit
      headers: {
        "Content-Type": "application/json",
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: JSON.stringify({
        edit: true,
        highlight: true,
        highlightDesc: desc,
        title: title,
      }),
    };
    fetch("http://localhost:8080/admin/highlight/save/" + productId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log(err));
  } else if (e.target.classList.contains("button-remove-highlight")) {
    if (!confirm("Are you remove highlight for this Product?")) return false;
    const removeButton = e.target;
    const productId = removeButton.dataset.product_id;
    const option = {
      method: "PUT",
      credentials: "same-origin", // include, *same-origin, omit
      headers: {
        "Content-Type": "application/json",
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: JSON.stringify({ highlight: false }),
    };
    fetch("http://localhost:8080/admin/highlight/save/" + productId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log(err));
  } else if (e.target.classList.contains("button-remove-new")) {
    if (!confirm("Are you remove new for this Product?")) return false;
    const removeButton = e.target;
    const productId = removeButton.dataset.product_id;
    const option = {
      method: "PUT",
      credentials: "same-origin", // include, *same-origin, omit
    };
    fetch("http://localhost:8080/admin/new-product/save/" + productId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log(err));
  } else if (e.target.classList.contains("button-set-new")) {
    if (!confirm("Are you set new for this Product?")) return false;
    const removeButton = e.target;
    const productId = removeButton.dataset.product_id;
    const option = {
      method: "PUT",
      credentials: "same-origin", // include, *same-origin, omit
    };
    fetch("http://localhost:8080/admin/new-product/save/" + productId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log(err));
  } else if (e.target.classList.contains("button-set-highlight")) {
    if (!confirm("Are you set highlight for this Product?")) return false;
    const removeButton = e.target;
    const productId = removeButton.dataset.product_id;
    const option = {
      method: "PUT",
      credentials: "same-origin", // include, *same-origin, omit
      headers: {
        "Content-Type": "application/json",
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: JSON.stringify({ highlight: true, edit: false }),
    };
    fetch("http://localhost:8080/admin/highlight/save/" + productId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log(err));
  } else if (e.target.classList.contains("button-remove-banner")) {
    if (!confirm("Are you remove banner for this Product?")) return false;
    const removeButton = e.target;
    const productId = removeButton.dataset.product_id;
    const option = {
      method: "PUT",
      credentials: "same-origin", // include, *same-origin, omit
    };
    fetch("http://localhost:8080/admin/banner/save/" + productId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log(err));
  } else if (e.target.classList.contains("button-set-banner")) {
    if (!confirm("Are you set banner for this Product?")) return false;
    const bannerButton = e.target;
    const productId = bannerButton.dataset.product_id;
    const option = {
      method: "PUT",
      credentials: "same-origin", // include, *same-origin, omit
    };
    fetch("http://localhost:8080/admin/banner/save/" + productId, option)
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
