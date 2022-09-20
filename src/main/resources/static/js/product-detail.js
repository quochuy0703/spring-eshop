const starEl = document.getElementsByClassName("star-modal");
const starModal = document.getElementById("startModal");
const starInput = document.getElementById("star");

starModal.addEventListener("click", (e) => {
  const star = e.target;
  const index = parseInt(star.dataset.star);
  if (e.target.classList.contains("star-modal")) {
    for (let i = 0; i < starEl.length; i++) {
      if (i < index) {
        starEl[i].classList.add("fa-solid");
        starEl[i].classList.remove("fa-regular");
      } else {
        starEl[i].classList.add("fa-regular");
        starEl[i].classList.remove("fa-solid");
      }
    }
    starInput.value = index;
  }
});
