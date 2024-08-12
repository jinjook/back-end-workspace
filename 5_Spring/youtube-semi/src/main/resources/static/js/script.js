const videoCard = document.querySelectorAll('.video-card');

videoCard.forEach(card => {
	card.addEventListener('click', () => {
		window.location.href="/watch?v=vcode";
	})
});