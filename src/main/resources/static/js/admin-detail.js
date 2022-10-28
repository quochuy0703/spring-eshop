const wrapper = document.getElementById("order-card-admin");
const descHighlightEl = document.getElementsByClassName("desc-highlight");
const titleHighlightEl = document.getElementsByClassName("title-highlight");
const buttonSaveEl = document.getElementsByClassName("button-save-highlight");
const buttonEditEl = document.getElementsByClassName("button-edit-highlight");
const buttonDeleteProducEl = document.getElementsByClassName(
  "button-delete-product"
);

wrapper.addEventListener("click", (e) => {
  if (e.target.classList.contains("button-process")) {
    const processButton = e.target;
    const orderId = processButton.dataset.order_id;
    console.log(orderId);
    const option = {
      method: "PUT",
    };
    fetch(server_name + "/admin/orders/prepare/" + orderId, option)
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

    for (let i = 0; i < fileUpload.length; i++) {
      if (fileUpload[i].dataset.product_id === productId) {
        fileUpload[i].disabled = false;
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

    for (let i = 0; i < fileUpload.length; i++) {
      if (fileUpload[i].dataset.product_id === productId) {
        fileUpload[i].disabled = true;
      }
    }

    let photo;
    for (let i = 0; i < fileUpload.length; i++) {
      if (fileUpload[i].dataset.product_id === productId) {
        photo = fileUpload[i].files[0];
      }
    }

    let formData = new FormData();

    formData.append("image", photo);
    formData.append("edit", true);
    formData.append("highlight", true);
    formData.append("highlightDesc", desc);
    formData.append("title", title);
    // formData.append(
    //   "data",
    //   JSON.stringify({
    //     edit: true,
    //     highlight: true,
    //     highlightDesc: desc,
    //     title: title,
    //   })
    // );

    //Do not set the Content-Type header for multi-part request with fetch(). The browser will automatically add the content type header, including the form boundary.
    const option = {
      method: "POST",
      credentials: "same-origin", // include, *same-origin, omit
      headers: {
        // "Content-Type": "application/json",
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      // body: JSON.stringify({
      //   edit: true,
      //   highlight: true,
      //   highlightDesc: desc,
      //   title: title,
      // }),
      body: formData,
    };
    fetch(server_name + "/admin/highlight/save/" + productId, option)
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
    fetch(server_name + "/admin/highlight/save/" + productId, option)
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
    fetch(server_name + "/admin/new-product/save/" + productId, option)
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
    fetch(server_name + "/admin/new-product/save/" + productId, option)
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
    fetch(server_name + "/admin/highlight/save/" + productId, option)
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
    fetch(server_name + "/admin/banner/save/" + productId, option)
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
    fetch(server_name + "/admin/banner/save/" + productId, option)
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => console.log(json))
      .catch((err) => console.log(err));
  } else if (e.target.classList.contains("button-delete-product")) {
    if (!confirm("Are you remove for this Product?")) return false;
    const removeButton = e.target;
    const productId = removeButton.dataset.product_id;
    const option = {
      method: "PUT",
      credentials: "same-origin", // include, *same-origin, omit
    };
    fetch(server_name + "/admin/product/delete/" + productId, option)
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

const fileReader = new FileReader();

const fileUpload = document.getElementsByClassName("fileUpload");
const imageHolderEl = document.getElementsByClassName("imageHolder");

let p = Promise.resolve();
wrapper.addEventListener("change", (e) => {
  if (e.target.classList.contains("fileUpload")) {
    const files = e.target.files;

    const productId = e.target.dataset.product_id;

    for (let i = 0; i < imageHolderEl.length; i++) {
      if (imageHolderEl[i].dataset.product_id === productId) {
        const imageHolder = imageHolderEl[i];

        for (let i = 0; i < files.length; i++) {
          p.then(() =>
            fileLoad(files[i]).then((url) => {
              const img = document.createElement("img");
              const divEl = document.createElement("div");
              img.classList.add("img-fluid");
              // divEl.classList.add("col-2");
              divEl.appendChild(img);
              imageHolder.appendChild(divEl);
              img.src = url;
              img.alt = files[i].name;
            })
          );
        }
      }
    }
  }
});

const fileLoad = (file) => {
  return new Promise((resolve, reject) => {
    let fr = new FileReader();
    fr.onload = () => resolve(fr.result);
    fr.onerrror = reject;
    fr.readAsDataURL(file); // or readAsText(file) to get raw content
  });
};

p.catch((error) => {
  console.log(err);
});
