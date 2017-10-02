<footer>2014 © cesarlab.com | Social - Premium Responsive Admin Template</footer>
<script type="text/javascript">
//<![CDATA[
try{if (!window.CloudFlare) {var CloudFlare=[{verbose:0,p:1399081244,byc:0,owlid:"cf",bag2:1,mirage2:0,oracle:0,paths:{cloudflare:"/cdn-cgi/nexp/dok9v=02fcfa4f56/"},atok:"6e53263ddcc8d6d536f3017ec1a1e825",petok:"ab428f1d21e9734969ac8a31c11ac43cbce70b5b-1399531573-1800",zone:"cesarlab.com",rocket:"0",apps:{"ga_key":{"ua":"UA-49490137-1","ga_bs":"2"}}}];!function(a,b){a=document.createElement("script"),b=document.getElementsByTagName("script")[0],a.async=!0,a.src="../../../../../ajax.cloudflare.com/cdn-cgi/nexp/dok9v%3d97fb4d042e/cloudflare.min.js",b.parentNode.insertBefore(a,b)}()}}catch(e){};
//]]>
</script>
<script type="text/javascript">
/* <![CDATA[ */
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-49490137-1']);
_gaq.push(['_trackPageview']);

(function() {
var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();

(function(b){(function(a){"__CF"in b&&"DJS"in b.__CF?b.__CF.DJS.push(a):"addEventListener"in b?b.addEventListener("load",a,!1):b.attachEvent("onload",a)})(function(){"FB"in b&&"Event"in FB&&"subscribe"in FB.Event&&(FB.Event.subscribe("edge.create",function(a){_gaq.push(["_trackSocial","facebook","like",a])}),FB.Event.subscribe("edge.remove",function(a){_gaq.push(["_trackSocial","facebook","unlike",a])}),FB.Event.subscribe("message.send",function(a){_gaq.push(["_trackSocial","facebook","send",a])}));"twttr"in b&&"events"in twttr&&"bind"in twttr.events&&twttr.events.bind("tweet",function(a){if(a){var b;if(a.target&&a.target.nodeName=="IFRAME")a:{if(a=a.target.src){a=a.split("#")[0].match(/[^?=&]+=([^&]*)?/g);b=0;for(var c;c=a[b];++b)if(c.indexOf("url")===0){b=unescape(c.split("=")[1]);break a}}b=void 0}_gaq.push(["_trackSocial","twitter","tweet",b])}})})})(window);
/* ]]> */
</script>
	<div class="theme-switcher">
			<a href="#"><i class="fa fa-cogs"></i> </a>
			<div class="content">
				<strong>Color Style</strong> <select name="colorpicker"
					class="styles">
					<option value="#fff" data-theme="css/themes/admin/default.html">Default</option>
					<option value="#647AAB" data-theme="css/themes/admin/facebook.css">Facebook</option>
					<option value="#242424" data-theme="css/themes/admin/inverse.css">Inverse</option>
					<option value="#62c462" data-theme="css/themes/admin/green.css">Green</option>
					<option value="#394263"
						data-theme="css/themes/admin/blue-sidebar.css">Blue
						Sidebar</option>
				</select>
				<hr>
				<a
					href="http://www.cesarlab.com/templates/social/demo/admin-rtl/index.html"><strong>RTL
						Version</strong> </a>
			</div>
		</div>


		<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
		<script>
      window.jQuery || document.write('<script src="js/jquery/jquery.min.js"><\/script>')
    </script>

		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script>
      $.fn.modal || document.write('<script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap/bootstrap.min.js"><\/script>')
       // Prevent jQueryUI Conflicts
       var bootstrapTooltip = $.fn.tooltip.noConflict()
       $.fn.bootstrapTooltip = bootstrapTooltip
    </script>

		<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
		<script>
      window.jQuery.ui || document.write('<script src="${pageContext.request.contextPath}/resources/js/jquery-ui/jquery-ui.min.js"><\/script>')
    </script>

		<script
			src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"></script>

		<script src="${pageContext.request.contextPath}/resources/js/jquery.slimscroll.min.js"></script>
		<script>
      window.jQuery.ui || document.write('<script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.slimscroll/jquery.slimscroll.min.js"><\/script>')
    </script>

		<script>
      var assets_dir = 'http://www.cesarlab.com/templates/social/assets/'
    </script>
		<script
			src="${pageContext.request.contextPath}/resources/js/plugins/jquery-simplecolorpicker/jquery.simplecolorpicker.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/demo/theme-switcher-admin.js"></script>

		<script src="${pageContext.request.contextPath}/resources/js/sidebar.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/panels.js"></script>

		<script>
      /*<![CDATA[*/
      $(function() {
        $(".social-sidebar").socialSidebar();
        $('.main').panels();
        $(".main a[href='#ignore']").click(function(e) {
          e.stopPropagation()
        });
      });
      $(document).on('click', '.navbar-super .navbar-super-fw', function(e) {
        e.stopPropagation()
      });
      /*]]>*/
    </script>


		<script src="${pageContext.request.contextPath}/resources/js/plugins/flot/jquery.flot.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/flot/jquery.flot.selection.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/jqvmap/jquery.vmap.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/jqvmap/maps/jquery.vmap.world.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/jqvmap/data/jquery.vmap.sampledata.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/easy-pie-chart/jquery.easypiechart.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/jquery.sparkline/jquery.sparkline.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/fullcalendar/fullcalendar.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/justgage/lib/raphael.2.1.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/justgage/justgage.js"></script>
		<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/gmaps/gmaps.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/plugins/pnotify/pnotify.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/demo/dashboard.js"></script>