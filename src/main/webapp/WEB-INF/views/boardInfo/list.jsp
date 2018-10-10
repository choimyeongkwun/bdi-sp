<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>안sud</title>
</head>
<script>
	window.addEventListener('load',function(){
		var xhr = new XMLHttpRequest();
		xhr.open('GET','/boardInfo');
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					var res =JSON.parse(xhr.responseText)
					console.log(res);
					var html='';
					for(var b of res){
						 html +='<tr>'
							html += '<td>'+b.binum+'</td>';
							html += '<td><input type="text" name="bititle'+b.binum+'"value="'+b.bititle+'"></td>';
							html += '<td><input type="text" name="bitext'+b.binum+'"value="'+b.bitext+'"></td>';
							html += '<td>'+b.bicredate+'</td>';
							html += '<td>'+b.bimoddat+'</td>';
							html += '<td>'+b.bicnt+'</td>';
							html += '<td>'+b.biactive+'</td>';
							html += '<td><button onclick="boardUpdate('+b.binum+')">수정</button><button onclick="boardDelete('+b.binum+')">삭제</button></td>';
							html += '<tr>';
					}
					document.querySelector("#biBody").insertAdjacentHTML('beforeend',html);
					}else{
						
					}
				
			}
		}
		xhr.send();
});
</script>
<body>
<table border="1">
	<thead>
		<tr>
			<th>num</th>
			<th>title</th>
			<th>text</th>
			<th>credate</th>
			<th>moddat</th>
			<th>cnt</th>
			<th>active</th>
			<th>update/delete</th>
		</tr>
	</thead>
	<tbody id ="biBody">
	</tbody>
</table>
<button onclick="boardAdd()">추가</button>
<script>
	function boardUpdate(binum){
		var bititle = document.querySelector('input[name=bititle'+binum+']').value;
		var bitext = document.querySelector('input[name=bitext'+binum+']').value;
		var param ={binum:binum,bititle:bititle,bitext:bitext};
		var xhr = new XMLHttpRequest();
		var url = "/boardInfo";
		xhr.open('PUT',url);
		xhr.setRequestHeader('Content-type','application/json');
		xhr.onredatstatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					if(xhr.responseText=='1'){
						
						alert('수정성공!')
						location.href='/uri/boardInfo/list';
					}
				}else{
					alert('수정실패');
				}
			}
		}
		alert(JSON.stringify(param));
		xhr.send(JSON.stringify(param));
	}
	
	function boardDelete(binum){
		var xhr = new XMLHttpRequest();
		var url = "/boardInfo/" + binum;
		xhr.open('DELETE',url);
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					if(xhr.responseText=='1'){
						alert('삭제성공!')
						location.href='/boardInfo';

					}
				}else{
					alert('삭제실패');
				}
			}
		}
		xhr.send();
	}
	function boardAdd(){
		var html ='<tr>'
		html += '<td>%nbsp;</td>';
		html += '<td><input type="text" name="bititle"></td>';
		html += '<td><input type="text" name="bitext"></td>';
		html += '<td><button onclick="boardInsert()">저장</button></td>';
		html += '<tr>';
		document.querySelector("tbody").insertAdjacentHTML('beforeend',html);
	}
	function boardInsert(binum){
		var bititle = document.querySelector('input[name=bititle]').value;
		var bitext = document.querySelector('input[name=bitext]').value;
		var param ={binum:binum,bititle:bititle,bitext:bitext};
		var xhr = new XMLHttpRequest();
		var url = "/boardInfo";
		xhr.open('POST',url);
		xhr.setRequestHeader('Content-type','application/json');
		xhr.onredatstatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					if(xhr.responseText=='1'){
						alert('수정성공!')
						location.href='/uri/boardInfo/list';
					}
				}else{
					alert('수정실패');
				}
			}
		}
		
		xhr.send(JSON.stringify(param));
	}
	
</script>
</body>
</html>
