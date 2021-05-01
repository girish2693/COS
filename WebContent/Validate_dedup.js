function p_d_equal() {
	var cb = document.getElementsByName("cb");
	var c = 0;
	for (var i = 0; i < cb.length; i++) {
		if (cb[i].checked) {
			c++;
		}

	}
	if (c > 1) {
		return true;
	} else {
		alert("Select Atleast 1 record!!");
		return false;
	}
}
