const list = document.querySelector('.group'); // 부모 요소

const expand = (item, i) => {
	const items = document.querySelectorAll('.item');
	items.forEach((it, ind) => {
		if (i === ind) return;
		it.clicked = false;
	});
	gsap.to(items, {
		width: item.clicked ? '15vw' : '5vw',
		duration: 1
	});

	item.clicked = !item.clicked;
	gsap.to(item, {
		width: item.clicked ? '30vw' : '10vw',
		duration: 1
	});
};

// 부모 요소에 이벤트 리스너를 추가하여 동적으로 추가된 .item 요소에 대해 이벤트 위임
list.addEventListener('click', (event) => {
	const item = event.target.closest('.item');
	if (item) {  // 클릭된 요소가 .item일 경우만
		console.log('Item clicked:', item);
		const items = document.querySelectorAll('.item');
		const index = Array.from(items).indexOf(item);
		expand(item, index);
	}
});

