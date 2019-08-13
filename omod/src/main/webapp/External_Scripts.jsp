<openmrs:htmlInclude file="/moduleResources/facelist/js/jquery.js" />

<openmrs:htmlInclude file="/moduleResources/facelist/js/bootstrap.js" />

<openmrs:htmlInclude file="/moduleResources/facelist/js/jquery.validate.js" />

<openmrs:htmlInclude file="/moduleResources/facelist/js/jquery.dataTables.js" />

<openmrs:htmlInclude file="/moduleResources/facelist/js/dataTables.bootstrap.js" />

<openmrs:htmlInclude file="/moduleResources/facelist/js/bootbox.min.js" />

<openmrs:htmlInclude file="/moduleResources/facelist/css/bootstrap.min.css" />

<openmrs:htmlInclude file="/moduleResources/facelist/csss/dataTables.bootstrap.csss" />


<script type="text/javascript">
	jQuery(window).load(function () {
		jQuery(".load").fadeOut(500);


		function errorPlacement(error, element) {
			// Add the 'help-block' class to the error element
			error.addClass("help-block");

			// add the error label after the input element
			error.insertAfter(element);
		}

		// fetch the form element
		$categoryForm = $('#upload');

		if ($categoryForm.length) {

			$categoryForm.validate({
				rules: {
					Patient_ID: {
						required: true,

					},
					file: {
						required: true,

					}
				},
				messages: {
					Patient_ID: {
						required: 'Please select name!',
					},
					file: {
						required: 'Please choose image file to upload!',
					}
				},
				errorElement: "em",
				errorPlacement: function (error, element) {
					errorPlacement(error, element);
				}
			}
			);
		}
	});

</script>

<style type="text/css">
	.load {
		width: 100%;
		height: 100%;
		background: url("${pageContext.request.contextPath}/moduleResources/facelist/faces/pre-loader.gif") center no-repeat #FFF;
		z-index: 99999;
		position: fixed;

	}

	.help-block {
		color: #ff0000;
	}
</style>