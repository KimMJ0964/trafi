
let slides = document.querySelector('.slides');
let slideIndex = 0;

function nextSlide() {
  slideIndex++;
  if (slideIndex >= 100) {
    slideIndex = 0;
  }
  slides.style.transform = `translateX(-${slideIndex * 300}px)`;
}

setInterval(nextSlide, 1000);