<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<script src="js/md5.js"></script>
<script src="js/sha1.js"></script>

<script type="text/javascript">
	var hash = hex_md5("123456");
	alert("md5加密（123456）：" + hash);
	
	var sha = hex_sha1('123456')
	alert("sha加密（123456）：" + sha);
</script>
</head>
<body>
</body>