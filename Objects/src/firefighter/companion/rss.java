package firefighter.companion;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class rss extends Activity implements B4AActivity{
	public static rss mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.rss");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (rss).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.rss");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.rss", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (rss) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (rss) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return rss.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (rss) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            rss mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (rss) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public anywheresoftware.b4a.objects.LabelWrapper _mple = null;
public anywheresoftware.b4a.objects.LabelWrapper _simanseislabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _listabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _katigorlabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ousialabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ililabel = null;
public anywheresoftware.b4a.objects.WebViewWrapper _webview1 = null;
public thalmy.webviewxtended.xtender _wvxtender = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblprogress = null;
public static String _html = "";
public anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
public static String _webviewtext = "";
public com.gvoulg.egsa87.egsa87 _egsa87 = null;
public firefighter.companion.main _main = null;
public firefighter.companion.rssdyo _rssdyo = null;
public firefighter.companion.deiktes _deiktes = null;
public firefighter.companion.avrio _avrio = null;
public firefighter.companion.gpssignal _gpssignal = null;
public firefighter.companion.gpsapp _gpsapp = null;
public firefighter.companion.searchun _searchun = null;
public firefighter.companion.searchundell _searchundell = null;
public firefighter.companion.firstaid _firstaid = null;
public firefighter.companion.ilika _ilika = null;
public firefighter.companion.epta _epta = null;
public firefighter.companion.epta2 _epta2 = null;
public firefighter.companion.epta3 _epta3 = null;
public firefighter.companion.kriti _kriti = null;
public firefighter.companion.attiki _attiki = null;
public firefighter.companion.pelloponiso _pelloponiso = null;
public firefighter.companion.thessalia _thessalia = null;
public firefighter.companion.sterea _sterea = null;
public firefighter.companion.anthraki _anthraki = null;
public firefighter.companion.ena _ena = null;
public firefighter.companion.dyo _dyo = null;
public firefighter.companion.tesera _tesera = null;
public firefighter.companion.pente _pente = null;
public firefighter.companion.exi _exi = null;
public firefighter.companion.okto _okto = null;
public firefighter.companion.ennia _ennia = null;
public firefighter.companion.camera _camera = null;
public firefighter.companion.pixida _pixida = null;
public firefighter.companion.miden100 _miden100 = null;
public firefighter.companion.dyoxil400 _dyoxil400 = null;
public firefighter.companion.thlefona _thlefona = null;
public firefighter.companion.dytellada _dytellada = null;
public firefighter.companion.hpeiros _hpeiros = null;
public firefighter.companion.adr _adr = null;
public firefighter.companion.katigoriess _katigoriess = null;
public firefighter.companion.dyoxil200 _dyoxil200 = null;
public firefighter.companion.dyoxil300 _dyoxil300 = null;
public firefighter.companion.egkefaliko _egkefaliko = null;
public firefighter.companion.venzini _venzini = null;
public firefighter.companion.ydroxidio _ydroxidio = null;
public firefighter.companion.ydroxlorio _ydroxlorio = null;
public firefighter.companion.xilia500 _xilia500 = null;
public firefighter.companion.xilia1000 _xilia1000 = null;
public firefighter.companion.xilia100 _xilia100 = null;
public firefighter.companion.xilia200 _xilia200 = null;
public firefighter.companion.xilia300 _xilia300 = null;
public firefighter.companion.xilia400 _xilia400 = null;
public firefighter.companion.xilia600 _xilia600 = null;
public firefighter.companion.xilia700 _xilia700 = null;
public firefighter.companion.ydroxidiodialima _ydroxidiodialima = null;
public firefighter.companion.ydroxlorikooxi _ydroxlorikooxi = null;
public firefighter.companion.ygraerio _ygraerio = null;
public firefighter.companion.voreioaig _voreioaig = null;
public firefighter.companion.aeriapetrelaiou _aeriapetrelaiou = null;
public firefighter.companion.aimoragia _aimoragia = null;
public firefighter.companion.amonia _amonia = null;
public firefighter.companion.asetilini _asetilini = null;
public firefighter.companion.dyo2 _dyo2 = null;
public firefighter.companion.dyo3 _dyo3 = null;
public firefighter.companion.dyoxil100 _dyoxil100 = null;
public firefighter.companion.dyoxil1000 _dyoxil1000 = null;
public firefighter.companion.dyoxil500 _dyoxil500 = null;
public firefighter.companion.dyoxil600 _dyoxil600 = null;
public firefighter.companion.dyoxil700 _dyoxil700 = null;
public firefighter.companion.dyoxil800 _dyoxil800 = null;
public firefighter.companion.dyoxil900 _dyoxil900 = null;
public firefighter.companion.dytmak _dytmak = null;
public firefighter.companion.efragma _efragma = null;
public firefighter.companion.egavma _egavma = null;
public firefighter.companion.ena6 _ena6 = null;
public firefighter.companion.enapente _enapente = null;
public firefighter.companion.enatessera _enatessera = null;
public firefighter.companion.epta4 _epta4 = null;
public firefighter.companion.exi2 _exi2 = null;
public firefighter.companion.fisiko _fisiko = null;
public firefighter.companion.ioniopel _ioniopel = null;
public firefighter.companion.karpa _karpa = null;
public firefighter.companion.katagma _katagma = null;
public firefighter.companion.kentrikimak _kentrikimak = null;
public firefighter.companion.listaousies _listaousies = null;
public firefighter.companion.lypothimia _lypothimia = null;
public firefighter.companion.meigmaaeriwn _meigmaaeriwn = null;
public firefighter.companion.methanio _methanio = null;
public firefighter.companion.miden200 _miden200 = null;
public firefighter.companion.miden300 _miden300 = null;
public firefighter.companion.miden400 _miden400 = null;
public firefighter.companion.miden500 _miden500 = null;
public firefighter.companion.miden600 _miden600 = null;
public firefighter.companion.notioaig _notioaig = null;
public firefighter.companion.ousies _ousies = null;
public firefighter.companion.oxigonopiesi _oxigonopiesi = null;
public firefighter.companion.oxygono _oxygono = null;
public firefighter.companion.pente2 _pente2 = null;
public firefighter.companion.petrelaio _petrelaio = null;
public firefighter.companion.pnigmos _pnigmos = null;
public firefighter.companion.propanio _propanio = null;
public firefighter.companion.simanseis _simanseis = null;
public firefighter.companion.tessera2 _tessera2 = null;
public firefighter.companion.tessera3 _tessera3 = null;
public firefighter.companion.thermoplixia _thermoplixia = null;
public firefighter.companion.thiiko _thiiko = null;
public firefighter.companion.thiikoatmizon _thiikoatmizon = null;
public firefighter.companion.tria _tria = null;
public firefighter.companion.triaxil100 _triaxil100 = null;
public firefighter.companion.triaxil200 _triaxil200 = null;
public firefighter.companion.triaxil300 _triaxil300 = null;
public firefighter.companion.triaxil400 _triaxil400 = null;
public firefighter.companion.triaxil500 _triaxil500 = null;
public firefighter.companion.triaxil600 _triaxil600 = null;
public firefighter.companion.xilia800 _xilia800 = null;
public firefighter.companion.xilia900 _xilia900 = null;
public firefighter.companion.xlorio _xlorio = null;
public firefighter.companion.ydrogono _ydrogono = null;
public firefighter.companion.ygrooxygono _ygrooxygono = null;
public firefighter.companion.ygropimeno _ygropimeno = null;
public firefighter.companion.ypothermia _ypothermia = null;
public firefighter.companion.restartgpsapp _restartgpsapp = null;
public firefighter.companion.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
firefighter.companion.httpjob _job1 = null;
uk.co.martinpearman.b4a.webviewextras.WebViewExtras _webviewextras1 = null;
 //BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"rss\")";
mostCurrent._activity.LoadLayout("rss",mostCurrent.activityBA);
 //BA.debugLineNum = 41;BA.debugLine="simanseislabel.Top = 3%y";
mostCurrent._simanseislabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 42;BA.debugLine="simanseislabel.left = 3.5%x";
mostCurrent._simanseislabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3.5),mostCurrent.activityBA));
 //BA.debugLineNum = 43;BA.debugLine="simanseislabel.height = 28%y";
mostCurrent._simanseislabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (28),mostCurrent.activityBA));
 //BA.debugLineNum = 44;BA.debugLine="simanseislabel.Width  = 45%x";
mostCurrent._simanseislabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 46;BA.debugLine="listabel.Top = 3%y";
mostCurrent._listabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 47;BA.debugLine="listabel.left = 51.75%x";
mostCurrent._listabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 48;BA.debugLine="listabel.height = 13%y";
mostCurrent._listabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 49;BA.debugLine="listabel.Width  = 21.25%x";
mostCurrent._listabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 55;BA.debugLine="katigorlabel.Top = 18%y";
mostCurrent._katigorlabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 56;BA.debugLine="katigorlabel.left = 51.75%x";
mostCurrent._katigorlabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 57;BA.debugLine="katigorlabel.height = 13%y";
mostCurrent._katigorlabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 58;BA.debugLine="katigorlabel.Width  = 21.25%x";
mostCurrent._katigorlabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 60;BA.debugLine="ousialabel.Top = 3%y";
mostCurrent._ousialabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 61;BA.debugLine="ousialabel.left = 76%x";
mostCurrent._ousialabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 62;BA.debugLine="ousialabel.height = 13%y";
mostCurrent._ousialabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 63;BA.debugLine="ousialabel.Width  = 21.25%x";
mostCurrent._ousialabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 66;BA.debugLine="ililabel.Top = 18%y";
mostCurrent._ililabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 67;BA.debugLine="ililabel.left = 76%x";
mostCurrent._ililabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 68;BA.debugLine="ililabel.height = 13%y";
mostCurrent._ililabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 69;BA.debugLine="ililabel.Width  = 21.25%x";
mostCurrent._ililabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 72;BA.debugLine="mple.top = 93%y";
mostCurrent._mple.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (93),mostCurrent.activityBA));
 //BA.debugLineNum = 73;BA.debugLine="mple.left = 3%x";
mostCurrent._mple.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 74;BA.debugLine="mple.width = 94%x";
mostCurrent._mple.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 75;BA.debugLine="mple.height = 7%y";
mostCurrent._mple.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (7),mostCurrent.activityBA));
 //BA.debugLineNum = 77;BA.debugLine="Dim job1 As HttpJob";
_job1 = new firefighter.companion.httpjob();
 //BA.debugLineNum = 78;BA.debugLine="job1.Initialize(\"Job1\", Me)";
_job1._initialize /*String*/ (processBA,"Job1",rss.getObject());
 //BA.debugLineNum = 79;BA.debugLine="job1.Download(\"http://www.google.com\")";
_job1._download /*String*/ ("http://www.google.com");
 //BA.debugLineNum = 81;BA.debugLine="HTML = File.GetText(File.DirAssets, \"rss.html\")";
mostCurrent._html = anywheresoftware.b4a.keywords.Common.File.GetText(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"rss.html");
 //BA.debugLineNum = 82;BA.debugLine="Dim WebViewExtras1 As WebViewExtras";
_webviewextras1 = new uk.co.martinpearman.b4a.webviewextras.WebViewExtras();
 //BA.debugLineNum = 83;BA.debugLine="WebViewExtras1.addWebChromeClient(WebView1, \"WebV";
_webviewextras1.addWebChromeClient(mostCurrent.activityBA,(android.webkit.WebView)(mostCurrent._webview1.getObject()),"WebViewExtras1");
 //BA.debugLineNum = 86;BA.debugLine="wvXtender.setAcceptCookie(WebView1,True)";
mostCurrent._wvxtender.setAcceptCookie((android.webkit.WebView)(mostCurrent._webview1.getObject()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 88;BA.debugLine="wvXtender.setJavaScriptEnabled(WebView1,True)";
mostCurrent._wvxtender.setJavaScriptEnabled((android.webkit.WebView)(mostCurrent._webview1.getObject()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 90;BA.debugLine="wvXtender.setLoadsImagesAutomatically(WebView1,Tr";
mostCurrent._wvxtender.setLoadsImagesAutomatically((android.webkit.WebView)(mostCurrent._webview1.getObject()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 92;BA.debugLine="wvXtender.setPluginState(WebView1,\"OFF\")";
mostCurrent._wvxtender.setPluginState((android.webkit.WebView)(mostCurrent._webview1.getObject()),"OFF");
 //BA.debugLineNum = 99;BA.debugLine="WebView1.Top = 33%y";
mostCurrent._webview1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA));
 //BA.debugLineNum = 100;BA.debugLine="WebView1.Left = 3%x";
mostCurrent._webview1.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 101;BA.debugLine="WebView1.height = 57.5%y";
mostCurrent._webview1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 102;BA.debugLine="WebView1.Width = 94%x";
mostCurrent._webview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 103;BA.debugLine="WebView1.LoadHtml(HTML)";
mostCurrent._webview1.LoadHtml(mostCurrent._html);
 //BA.debugLineNum = 104;BA.debugLine="webviewText = WebView1.Url";
mostCurrent._webviewtext = mostCurrent._webview1.getUrl();
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 192;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 195;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 166;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public static String  _btnscroll_click() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _send = null;
String _strwich = "";
boolean _bolz = false;
 //BA.debugLineNum = 123;BA.debugLine="Sub btnScroll_Click";
 //BA.debugLineNum = 124;BA.debugLine="Dim Send As Button";
_send = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 125;BA.debugLine="Dim strWich As String";
_strwich = "";
 //BA.debugLineNum = 126;BA.debugLine="Dim bolZ As Boolean";
_bolz = false;
 //BA.debugLineNum = 128;BA.debugLine="Send = Sender";
_send.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 129;BA.debugLine="strWich = Send.Tag";
_strwich = BA.ObjectToString(_send.getTag());
 //BA.debugLineNum = 131;BA.debugLine="Select strWich";
switch (BA.switchObjectToInt(_strwich,"DownH","DownF","UpH","UpF","In","Out")) {
case 0: {
 //BA.debugLineNum = 134;BA.debugLine="wvXtender.pageDown(WebView1,False)";
mostCurrent._wvxtender.pageDown((android.webkit.WebView)(mostCurrent._webview1.getObject()),anywheresoftware.b4a.keywords.Common.False);
 break; }
case 1: {
 //BA.debugLineNum = 136;BA.debugLine="wvXtender.pageDown(WebView1,True)";
mostCurrent._wvxtender.pageDown((android.webkit.WebView)(mostCurrent._webview1.getObject()),anywheresoftware.b4a.keywords.Common.True);
 break; }
case 2: {
 //BA.debugLineNum = 138;BA.debugLine="wvXtender.pageUp(WebView1,False)";
mostCurrent._wvxtender.pageUp((android.webkit.WebView)(mostCurrent._webview1.getObject()),anywheresoftware.b4a.keywords.Common.False);
 break; }
case 3: {
 //BA.debugLineNum = 140;BA.debugLine="wvXtender.pageUp(WebView1,True)";
mostCurrent._wvxtender.pageUp((android.webkit.WebView)(mostCurrent._webview1.getObject()),anywheresoftware.b4a.keywords.Common.True);
 break; }
case 4: {
 //BA.debugLineNum = 142;BA.debugLine="bolZ = wvXtender.zoomIn(WebView1)";
_bolz = mostCurrent._wvxtender.zoomIn((android.webkit.WebView)(mostCurrent._webview1.getObject()));
 break; }
case 5: {
 //BA.debugLineNum = 144;BA.debugLine="bolZ = wvXtender.zoomOut(WebView1)";
_bolz = mostCurrent._wvxtender.zoomOut((android.webkit.WebView)(mostCurrent._webview1.getObject()));
 break; }
}
;
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private mple As Label";
mostCurrent._mple = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private simanseislabel As Label";
mostCurrent._simanseislabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private listabel As Label";
mostCurrent._listabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private katigorlabel As Label";
mostCurrent._katigorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private ousialabel As Label";
mostCurrent._ousialabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private ililabel As Label";
mostCurrent._ililabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Dim WebView1 As WebView";
mostCurrent._webview1 = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim wvXtender As WebViewXtender";
mostCurrent._wvxtender = new thalmy.webviewxtended.xtender();
 //BA.debugLineNum = 28;BA.debugLine="Dim lblProgress As Label";
mostCurrent._lblprogress = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim HTML As String";
mostCurrent._html = "";
 //BA.debugLineNum = 30;BA.debugLine="Dim p As PhoneIntents";
mostCurrent._p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 31;BA.debugLine="Dim webviewText As String";
mostCurrent._webviewtext = "";
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 189;BA.debugLine="StartActivity(p.OpenBrowser(\"https://www.facebook";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._p.OpenBrowser("https://www.facebook.com/groups/256720274824210/")));
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(firefighter.companion.httpjob _job) throws Exception{
 //BA.debugLineNum = 147;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 148;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("72359297","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
 //BA.debugLineNum = 149;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 152;BA.debugLine="Log(Job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("72359301",_job._getstring /*String*/ (),0);
 }else {
 //BA.debugLineNum = 156;BA.debugLine="ToastMessageShow(\"Χωρις σύνδεση στο διαδίκτυο\",T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Χωρις σύνδεση στο διαδίκτυο"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 157;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 159;BA.debugLine="Job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 182;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 178;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 179;BA.debugLine="StartActivity(\"firstaid\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("firstaid"));
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 184;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 185;BA.debugLine="StartActivity(\"gpssignal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssignal"));
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _showstates() throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Sub ShowStates";
 //BA.debugLineNum = 111;BA.debugLine="Msgbox(\"Are cookies enabled? \" & wvXtender.getAcc";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Are cookies enabled? "+BA.ObjectToString(mostCurrent._wvxtender.getAcceptCookie((android.webkit.WebView)(mostCurrent._webview1.getObject())))),BA.ObjectToCharSequence("Cookie State"),mostCurrent.activityBA);
 //BA.debugLineNum = 112;BA.debugLine="Msgbox(\"Is JavaScript enabled? \" & wvXtender.getJ";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Is JavaScript enabled? "+BA.ObjectToString(mostCurrent._wvxtender.getJavaScriptEnabled((android.webkit.WebView)(mostCurrent._webview1.getObject())))),BA.ObjectToCharSequence("JavaScript State"),mostCurrent.activityBA);
 //BA.debugLineNum = 113;BA.debugLine="Msgbox(\"Is Image Loading enabled? \" & wvXtender.g";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Is Image Loading enabled? "+BA.ObjectToString(mostCurrent._wvxtender.getLoadsImagesAutomatically((android.webkit.WebView)(mostCurrent._webview1.getObject())))),BA.ObjectToCharSequence("Image Loading State"),mostCurrent.activityBA);
 //BA.debugLineNum = 114;BA.debugLine="Msgbox(\"ArePlugIns enabled? \" & wvXtender.getPlug";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("ArePlugIns enabled? "+mostCurrent._wvxtender.getPluginState((android.webkit.WebView)(mostCurrent._webview1.getObject()))),BA.ObjectToCharSequence("PlugIns State"),mostCurrent.activityBA);
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 176;BA.debugLine="StartActivity(\"rssDyo\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("rssDyo"));
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public static String  _webview1_pagefinished(String _url) throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Sub webView1_PageFinished (Url As String)";
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public static String  _webviewextras1_progresschanged(int _newprogress) throws Exception{
 //BA.debugLineNum = 198;BA.debugLine="Sub WebViewExtras1_ProgressChanged(NewProgress As";
 //BA.debugLineNum = 204;BA.debugLine="If Not(WebView1.Url = webviewText) Then";
if (anywheresoftware.b4a.keywords.Common.Not((mostCurrent._webview1.getUrl()).equals(mostCurrent._webviewtext))) { 
 //BA.debugLineNum = 205;BA.debugLine="If WebView1.Url = \"about:blank\" Then";
if ((mostCurrent._webview1.getUrl()).equals("about:blank")) { 
 }else {
 //BA.debugLineNum = 208;BA.debugLine="StartActivity(p.OpenBrowser(WebView1.Url))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._p.OpenBrowser(mostCurrent._webview1.getUrl())));
 //BA.debugLineNum = 209;BA.debugLine="WebView1.LoadHtml(HTML)";
mostCurrent._webview1.LoadHtml(mostCurrent._html);
 };
 };
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
}
