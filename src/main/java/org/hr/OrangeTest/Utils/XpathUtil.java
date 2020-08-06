package org.hr.OrangeTest.Utils;

public class XpathUtil {
	public static class LoginModule{
		public static final String user_name="//*[@id=\"txtUsername\"]";
		public static final String pass="//*[@id=\"txtPassword\"]";
		public static final String login_btn="//*[@id=\"btnLogin\"]";
	}
	
	public static class DashBoardModule{
		public static final String AssignLeave="//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[1]/div/a/span";
	}
	
	public static class AssignLeaveModule{
		public static final String EmployeeName="//*[@id=\"assignleave_txtEmployee_empName\"]";
		public static final String LeaveType="//*[@id=\"assignleave_txtLeaveType\"]";
		
		public static final String FromDate="//*[@id=\"assignleave_txtFromDate\"]";
		public static final String FromDateMonth="//*[@id=\"ui-datepicker-div\"]/div/div/select[1]";
		public static final String FromDateYear="//*[@id=\"ui-datepicker-div\"]/div/div/select[2]";
		public static final String FromDateDayClass="ui-datepicker-calendar";
		
		public static final String ToDate="//*[@id=\"assignleave_txtToDate\"]";
		public static final String ToDateMonth="//*[@id=\"ui-datepicker-div\"]/div/div/select[1]";
		public static final String ToDateYear="//*[@id=\"ui-datepicker-div\"]/div/div/select[2]";
		public static final String ToDateDayClass="ui-datepicker-calendar";
		
		public static final String Comment="//*[@id=\"assignleave_txtComment\"]";
		public static final String AssignButton="//*[@id=\"assignBtn\"]";
		
		public static final String ConfirmClick="//*[@id=\"confirmOkButton\"]";
		
		//public static final String WelcomeAdmin="//*[@id=\"welcome\"]";
		//public static final String Logout="//*[@id=\"welcome-menu\"]/ul/li[2]/a";
		
	}
}
