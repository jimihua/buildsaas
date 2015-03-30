var onlyUser = "onlyUser";
$(document).ready(function() {
	/**
	 * 登陆
	 * */
	jQuery("#btn_login").click(function() {
		
		if (!verify.verifyMobile(jQuery("#login_username"))) {
			return;
		}
		
		if (!verify.PasswordLenght(jQuery("#login_password"))) {
			return;
		}
		if (verify.PasswordLenght(jQuery("#login_password"))&&verify.verifyMobile(jQuery("#login_username"))) {
		
			jQuery.post("./tenant_login.action",{
				"username":jQuery("#login_username").val(),
				"password":jQuery("#login_password").val()
			},function(result){
				if (result!=null) {
					var login_result=result.login;
					if (login_result=="success") {
						console.log(123);
					}
					if (login_result=="password is wrong") {
						showNotic(jQuery("#login_password"));
					}
				}
				
			});
		}
		});
		/**
		 * 判断账号是否被注册
		 * */
		jQuery("#reg_username").blur(function(){
			
			if (verify.verifyMobile(jQuery(this))) {
				jQuery.get("./tenant_isReged.action",{
					"username":jQuery(this).val(),
				},function(result){
					console.log(result);
					var isReged=result.isReged;
					if (isReged=="error") {
						
						showNotic(jQuery("#reg_username"),"该手机号码已被注册");
					}
					else if(isReged=="success")
					{	
						hideNotic(jQuery("#reg_username"));
					}
				});
			}
		});
		
		jQuery("#btn_reg").click(function(){
			if (verify.verifyMobile(jQuery("#reg_username"))&&verify.PasswordLenght(jQuery("#reg_password"))) {
				var formgroup=jQuery(".signup-email form-group");
				
				jQuery.post("./tenant_register.action",{
					"tenant.tenantUsername":jQuery("#reg_username").val(),
					"tenant.tenantPassword":jQuery("#reg_password").val(),
					"tenant.tenantMobile":jQuery("#reg_username").val(),
					"tenant.tenantCompany":formgroup.eq(0).find("input").val(),
					"tenant.tenantRealname":formgroup.eq(1).find("input").val(),
				},function(result){
					var regResult=result.register;
					if (regResult=="success") {
						console.log("success");
					}
				});
			}
			
			
		});

});
