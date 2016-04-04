<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<title>图片旋转效果</title> 
<meta http-equiv="content-type" content="text/html;charset=gb2312"> 
<!--把下面代码加到<head>与</head>之间--> 
<style type="text/css"> 
ul{padding:0 15px;} 
ul li{padding-bottom:15px;border-bottom:1px dashed #EEE;} 
.caption{padding:15px 0 5px;} 
.caption input{margin-right:10px;padding:0 10px;} 
</style> 
<script type="text/javascript"> 
/* 
* www.byzuo.com 
* ok!: MSIE 6, 7, 8, Firefox 3.6, chrome 4, Safari 4, Opera 10 
* o 旋转图片ID; 
* p 选择旋转方向，固定值为'left'或'right'; 
*/ 
function rotate(o,p){ 
    var img = document.getElementById(o); 
    if(!img || !p) return false; 
    var n = img.getAttribute('step'); 
    if(n== null) n=0; 
    if(p=='right'){ 
        (n==3)? n=0:n++; 
    }else if(p=='left'){ 
        (n==0)? n=3:n--; 
    } 
    img.setAttribute('step',n); 
    //MSIE 
    if(document.all) { 
        img.style.filter = 'progid:DXImageTransform.Microsoft.BasicImage(rotation='+ n +')'; 
        //HACK FOR MSIE 8 
        switch(n){ 
            case 0: 
                imgimg.parentNode.style.height = img.height; 
                break; 
            case 1: 
                imgimg.parentNode.style.height = img.width; 
                break; 
            case 2: 
                imgimg.parentNode.style.height = img.height; 
                break; 
            case 3: 
                imgimg.parentNode.style.height = img.width; 
                break; 
        } 
    //DOM 
    }else{ 
        var c = document.getElementById('canvas_'+o); 
        if(c== null){ 
            img.style.visibility = 'hidden'; 
            img.style.position = 'absolute'; 
            c = document.createElement('canvas'); 
            c.setAttribute("id",'canvas_'+o); 
            img.parentNode.appendChild(c); 
        } 
        var ccanvasContext = c.getContext('2d'); 
        switch(n) { 
            default : 
            case 0 : 
                c.setAttribute('width', img.width); 
                c.setAttribute('height', img.height); 
                canvasContext.rotate(0 * Math.PI / 180); 
                canvasContext.drawImage(img, 0, 0); 
                break; 
            case 1 : 
                c.setAttribute('width', img.height); 
                c.setAttribute('height', img.width); 
                canvasContext.rotate(90 * Math.PI / 180); 
                canvasContext.drawImage(img, 0, -img.height); 
                break; 
            case 2 : 
                c.setAttribute('width', img.width); 
                c.setAttribute('height', img.height); 
                canvasContext.rotate(180 * Math.PI / 180); 
                canvasContext.drawImage(img, -img.width, -img.height); 
                break; 
            case 3 : 
                c.setAttribute('width', img.height); 
                c.setAttribute('height', img.width); 
                canvasContext.rotate(270 * Math.PI / 180); 
                canvasContext.drawImage(img, -img.width, 0); 
                break; 
        } 
    } 
} 
</script> 
</head> 
<body> 
<!--把下面代码加到<body>与</body>之间--> 
<ul class="clearfix"> 
    <li> 
        <div class="caption"> 
            <input type="button" value="turn left" onclick="rotate('pic_1','left')"> 
            <input type="button" value="turn right" onclick="rotate('pic_1','right')"> 
        </div> 
        <div class="cont"> 
            <img  alt="javascript 图片旋转效果"  id="pic_1" src="1.gif" alt=""> 
        </div> 
    </li> 
</ul> 
</body> 
</html> 