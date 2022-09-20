console.log("hello");

const fileReader = new FileReader();

const fileUpload = document.getElementById("fileUpload");
const imageHolder = document.getElementById("imageHolder");

const imageIsUploaded = document.getElementById("imageIsUploaded");
let p = Promise.resolve();
fileUpload.addEventListener("change", (e) => {
  const files = e.target.files;
  console.log(files);

  for (let i = 0; i < files.length; i++) {
    // fileReader.readAsDataURL(files[i]);
    // fileReader.addEventListener("load", (e) => {
    //   const img = document.createElement("img");
    //   const divEl = document.createElement("div");
    //   img.style.width = "100%";
    //   img.style.minHeight = "100%";
    //   divEl.classList.add("col-2");
    //   divEl.appendChild(img);
    //   imageHolder.appendChild(divEl);
    //   img.src = e.target.result;
    //   img.alt = files[i].name;
    // });
    p.then(() =>
      fileLoad(files[i]).then((url) => {
        const img = document.createElement("img");
        const divEl = document.createElement("div");
        img.style.width = "100%";
        img.style.minHeight = "100%";
        divEl.classList.add("col-2");
        divEl.appendChild(img);
        imageHolder.appendChild(divEl);
        img.src = url;
        img.alt = files[i].name;
      })
    );
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

fileUpload.addEventListener("change", (e) => {
  imageHolder.innerHTML = "";
});

imageHolder.addEventListener("click", (e) => {
  const closeEl = e.target;

  if (closeEl.classList.contains("close-tool")) {
    console.log("click", closeEl.parentElement);

    const parentEL = closeEl.parentElement;
    parentEL.remove();
  }
});

imageIsUploaded.addEventListener("click", (e) => {
  const closeEl = e.target;

  if (closeEl.classList.contains("close-tool")) {
    console.log("click", closeEl.parentElement);

    const parentEL = closeEl.parentElement;
    parentEL.remove();
  }
});
