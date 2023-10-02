package com.helper;

import org.openqa.selenium.WebDriver;

import com.pom.AppFeedbackList;
import com.pom.CommonObjectRepo;
import com.pom.Dashboard;
import com.pom.Login;
import com.pom.Logout;
import com.pom.Reports_GstReport;
import com.pom.Reports_SalesReport;
import com.pom.Reports_StockReport;
import com.pom.Sales_OrderList;
import com.pom.Sales_OrderReceiptList;
import com.pom.Sales_OrderRefundList;
import com.pom.Settings_CanteenList;
import com.pom.Settings_DishesList;
import com.pom.Settings_GstList;
import com.pom.Settings_HolidaysList;
import com.pom.Settings_SchedulePlanner;
import com.pom.Settings_TimeframesList;
import com.pom.Users_CanteenStaffList;
import com.pom.Users_GuestList;
import com.pom.Users_StaffsList;
import com.pom.Users_StudentsList;

public class PageObjectManager {

	public WebDriver driver;

	public PageObjectManager(WebDriver driver2) {
		this.driver = driver2;
	}

	private Login li;

	public Login getInstanceli() {
		if (li == null) {
			li = new Login(driver);
		}
		return li;
	}

	private Dashboard db;

	public Dashboard getInstancedb() {
		if (db == null) {
			db = new Dashboard(driver);
		}
		return db;
	}

	private Sales_OrderReceiptList rl;

	public Sales_OrderReceiptList getInstancerl() {
		if (rl == null) {
			rl = new Sales_OrderReceiptList(driver);
		}
		return rl;
	}

	private Sales_OrderList ol;

	public Sales_OrderList getInstanceol() {
		if (ol == null) {
			ol = new Sales_OrderList(driver);
		}
		return ol;
	}

	private Sales_OrderRefundList orl;

	public Sales_OrderRefundList getInstanceorl() {
		if (orl == null) {
			orl = new Sales_OrderRefundList(driver);
		}
		return orl;
	}

	private Users_StudentsList stl;

	public Users_StudentsList getInstancestl() {
		if (stl == null) {
			stl = new Users_StudentsList(driver);
		}
		return stl;
	}

	private Users_StaffsList sl;

	public Users_StaffsList getInstancesl() {
		if (sl == null) {
			sl = new Users_StaffsList(driver);
		}
		return sl;
	}

	private Users_CanteenStaffList csl;

	public Users_CanteenStaffList getInstancecsl() {
		if (csl == null) {
			csl = new Users_CanteenStaffList(driver);
		}
		return csl;
	}

	private Users_GuestList ugl;

	public Users_GuestList getInstanceugl() {
		if (ugl == null) {
			ugl = new Users_GuestList(driver);
		}
		return ugl;
	}

	private Settings_CanteenList cl;

	public Settings_CanteenList getInstancecl() {
		if (cl == null) {
			cl = new Settings_CanteenList(driver);
		}
		return cl;
	}

	private Settings_DishesList dl;

	public Settings_DishesList getInstancedl() {
		if (dl == null) {
			dl = new Settings_DishesList(driver);
		}
		return dl;
	}

	private Settings_TimeframesList tfl;

	public Settings_TimeframesList getInstancetfl() {
		if (tfl == null) {
			tfl = new Settings_TimeframesList(driver);
		}
		return tfl;
	}

	private Settings_SchedulePlanner sp;

	public Settings_SchedulePlanner getInstancesp() {
		if (sp == null) {
			sp = new Settings_SchedulePlanner(driver);
		}
		return sp;
	}

	private Settings_GstList gl;

	public Settings_GstList getInstancegl() {
		if (gl == null) {
			gl = new Settings_GstList(driver);
		}
		return gl;
	}

	private Settings_HolidaysList hl;

	public Settings_HolidaysList getInstancehl() {
		if (hl == null) {
			hl = new Settings_HolidaysList(driver);
		}
		return hl;
	}

	private Reports_GstReport gr;

	public Reports_GstReport getInstancegr() {
		if (gr == null) {
			gr = new Reports_GstReport(driver);
		}
		return gr;
	}

	private Reports_StockReport sr;

	public Reports_StockReport getInstancesr() {
		if (sr == null) {
			sr = new Reports_StockReport(driver);
		}
		return sr;
	}

	private Reports_SalesReport rsr;

	public Reports_SalesReport getInstancersr() {
		if (rsr == null) {
			rsr = new Reports_SalesReport(driver);
		}
		return rsr;
	}

	private AppFeedbackList fb;

	public AppFeedbackList getInstancefb() {
		if (fb == null) {
			fb = new AppFeedbackList(driver);
		}
		return fb;
	}

	private CommonObjectRepo co;

	public CommonObjectRepo getInstanceco() {
		if (co == null) {
			co = new CommonObjectRepo(driver);
		}
		return co;
	}

	private Logout lo;

	public Logout getInstancelo() {
		if (lo == null) {
			lo = new Logout(driver);
		}
		return lo;
	}

}
