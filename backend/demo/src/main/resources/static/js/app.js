const topcap = document.querySelectorAll(".carousel-caption");
const bottomcap = document.querySelectorAll(".caption-bottom");
const slideclass = ("slide");

var TACarousel = document.querySelector("#CarouselTextAnim");

TACarousel.addEventListener("slide.bs.carousel", function() {
    topcap.forEach(cap => cap.classList.add(slideclass));
    bottomcap.forEach(cap => cap.classList.add(slideclass));
});

TACarousel.addEventListener("slid.bs.carousel", function() {
    topcap.forEach(cap => cap.classList.remove(slideclass));
    bottomcap.forEach(cap => cap.classList.remove(slideclass));
});