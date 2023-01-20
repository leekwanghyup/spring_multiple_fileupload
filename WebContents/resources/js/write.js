console.log('write.js');

$(function(){
	let formCount = 1;
	$('.fileForm .add').click(function(){
		if(formCount>=5) {
			alert('5개까지만 추가할 수 있음'); 
			return;
		} 
		let fileFormTag = $('.fileForm .attachFile').eq(0).clone();
		fileFormTag.val('');
		$('.fileForm').append(fileFormTag);
		formCount++;
	});
	
	$('.fileForm .del').click(function(){
		if(formCount <= 1){
			alert('마지막폼은 살제할 수 있음');
			return;
		}
		$('.fileForm .attachFile').eq(formCount-1).remove();	
		formCount--;
	})
	
})