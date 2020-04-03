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

public class restartgpsapp extends Activity implements B4AActivity{
	public static restartgpsapp mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.restartgpsapp");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (restartgpsapp).");
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
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.restartgpsapp");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.restartgpsapp", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (restartgpsapp) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (restartgpsapp) Resume **");
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
		return restartgpsapp.class;
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
        BA.LogInfo("** Activity (restartgpsapp) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            restartgpsapp mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (restartgpsapp) Resume **");
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
public static anywheresoftware.b4a.gps.GPS _gps1 = null;
public anywheresoftware.b4a.objects.collections.List _res = null;
public anywheresoftware.b4a.objects.LabelWrapper _mple = null;
public anywheresoftware.b4a.objects.LabelWrapper _simanseislabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _listabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _katigorlabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ousialabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ililabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _txt0 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelola = null;
public anywheresoftware.b4a.objects.PanelWrapper _moiresdek = null;
public anywheresoftware.b4a.objects.EditTextWrapper _lotl = null;
public anywheresoftware.b4a.objects.EditTextWrapper _lot = null;
public anywheresoftware.b4a.objects.EditTextWrapper _lotlepta = null;
public anywheresoftware.b4a.objects.EditTextWrapper _lotdeyt = null;
public anywheresoftware.b4a.objects.EditTextWrapper _lat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _latlepta = null;
public anywheresoftware.b4a.objects.EditTextWrapper _latdeyt = null;
public anywheresoftware.b4a.objects.EditTextWrapper _deklot = null;
public anywheresoftware.b4a.objects.EditTextWrapper _deklat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _egsalon = null;
public anywheresoftware.b4a.objects.EditTextWrapper _egsalat = null;
public anywheresoftware.b4a.objects.ButtonWrapper _okegsa = null;
public anywheresoftware.b4a.objects.ButtonWrapper _okdekadika = null;
public anywheresoftware.b4a.objects.ButtonWrapper _okmoires = null;
public anywheresoftware.b4a.objects.EditTextWrapper _lotmono = null;
public anywheresoftware.b4a.objects.EditTextWrapper _latmono = null;
public static boolean _egsalatb = false;
public static boolean _egsalonb = false;
public static boolean _deklotb = false;
public static boolean _deklatb = false;
public static boolean _latb = false;
public static boolean _lotb = false;
public static boolean _lotleptab = false;
public static boolean _latleptab = false;
public static boolean _latdeytb = false;
public static boolean _lotdeytb = false;
public anywheresoftware.b4a.objects.ButtonWrapper _okdel = null;
public com.gvoulg.egsa87.egsa87 _egsa87 = null;
public firefighter.companion.main _main = null;
public firefighter.companion.rss _rss = null;
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
public firefighter.companion.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _a_click() throws Exception{
 //BA.debugLineNum = 170;BA.debugLine="Sub a_click";
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 79;BA.debugLine="Activity.LoadLayout(\"gpssApp\")";
mostCurrent._activity.LoadLayout("gpssApp",mostCurrent.activityBA);
 //BA.debugLineNum = 82;BA.debugLine="MoiresDek.Visible = True";
mostCurrent._moiresdek.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 83;BA.debugLine="lat.Color = Colors.blue";
mostCurrent._lat.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 84;BA.debugLine="lot.Color = Colors.blue";
mostCurrent._lot.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 85;BA.debugLine="latMono.Color = Colors.blue";
mostCurrent._latmono.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 86;BA.debugLine="lotMono.Color = Colors.blue";
mostCurrent._lotmono.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 87;BA.debugLine="lotDEYT.Color = Colors.blue";
mostCurrent._lotdeyt.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 88;BA.debugLine="lotLEPTA.Color = Colors.blue";
mostCurrent._lotlepta.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 89;BA.debugLine="latDEYT.Color = Colors.blue";
mostCurrent._latdeyt.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 90;BA.debugLine="latLEPTA.Color = Colors.blue";
mostCurrent._latlepta.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 91;BA.debugLine="DekLot.Color = Colors.blue";
mostCurrent._deklot.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 92;BA.debugLine="DekLat.Color = Colors.blue";
mostCurrent._deklat.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 93;BA.debugLine="egsaLon.Color = Colors.blue";
mostCurrent._egsalon.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 94;BA.debugLine="egsaLAt.Color = Colors.blue";
mostCurrent._egsalat.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 96;BA.debugLine="GPS1.Initialize(\"GPS\")";
_gps1.Initialize("GPS");
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 590;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 591;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 593;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 595;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 107;BA.debugLine="MoiresDek.Visible = True";
mostCurrent._moiresdek.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 108;BA.debugLine="lat.Color = Colors.blue";
mostCurrent._lat.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 109;BA.debugLine="lot.Color = Colors.blue";
mostCurrent._lot.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 110;BA.debugLine="latMono.Color = Colors.blue";
mostCurrent._latmono.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 111;BA.debugLine="lotMono.Color = Colors.blue";
mostCurrent._lotmono.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 112;BA.debugLine="lotDEYT.Color = Colors.blue";
mostCurrent._lotdeyt.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 113;BA.debugLine="lotLEPTA.Color = Colors.blue";
mostCurrent._lotlepta.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 114;BA.debugLine="latDEYT.Color = Colors.blue";
mostCurrent._latdeyt.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 115;BA.debugLine="latLEPTA.Color = Colors.blue";
mostCurrent._latlepta.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 116;BA.debugLine="DekLot.Color = Colors.blue";
mostCurrent._deklot.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 117;BA.debugLine="DekLat.Color = Colors.blue";
mostCurrent._deklat.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 118;BA.debugLine="egsaLon.Color = Colors.blue";
mostCurrent._egsalon.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 119;BA.debugLine="egsaLAt.Color = Colors.blue";
mostCurrent._egsalat.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 121;BA.debugLine="StartActivity(gpsApp)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gpsapp.getObject()));
 //BA.debugLineNum = 122;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static String  _b_click() throws Exception{
 //BA.debugLineNum = 173;BA.debugLine="Sub b_click";
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public static String  _d_click() throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Sub d_click";
 //BA.debugLineNum = 181;BA.debugLine="End Sub";
return "";
}
public static String  _deklat_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 504;BA.debugLine="Sub DekLat_TextChanged (Old As String, New As Stri";
 //BA.debugLineNum = 505;BA.debugLine="If DekLat.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._deklat.getText()))>1) { 
 //BA.debugLineNum = 506;BA.debugLine="deklatB = True";
_deklatb = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 508;BA.debugLine="End Sub";
return "";
}
public static String  _deklot_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 510;BA.debugLine="Sub DekLot_TextChanged (Old As String, New As Stri";
 //BA.debugLineNum = 511;BA.debugLine="If DekLot.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._deklot.getText()))>1) { 
 //BA.debugLineNum = 512;BA.debugLine="deklotB = True";
_deklotb = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 514;BA.debugLine="End Sub";
return "";
}
public static String  _e_click() throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Sub e_click";
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public static String  _egsalat_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 517;BA.debugLine="Sub egsaLat_TextChanged (Old As String, New As Str";
 //BA.debugLineNum = 518;BA.debugLine="If egsaLAt.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._egsalat.getText()))>1) { 
 //BA.debugLineNum = 519;BA.debugLine="egsaLatB = True";
_egsalatb = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 521;BA.debugLine="End Sub";
return "";
}
public static String  _egsalon_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 523;BA.debugLine="Sub egsaLon_TextChanged (Old As String, New As Str";
 //BA.debugLineNum = 524;BA.debugLine="If egsaLon.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._egsalon.getText()))>1) { 
 //BA.debugLineNum = 525;BA.debugLine="egsaLonB = True";
_egsalonb = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 527;BA.debugLine="End Sub";
return "";
}
public static String  _g_click() throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Sub g_click";
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim res As List";
mostCurrent._res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 19;BA.debugLine="Private mple As Label";
mostCurrent._mple = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private simanseislabel As Label";
mostCurrent._simanseislabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private listabel As Label";
mostCurrent._listabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private katigorlabel As Label";
mostCurrent._katigorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private ousialabel As Label";
mostCurrent._ousialabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private ililabel As Label";
mostCurrent._ililabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim res As List";
mostCurrent._res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 33;BA.debugLine="Dim txt0 As Label";
mostCurrent._txt0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private panelola As Panel";
mostCurrent._panelola = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private MoiresDek As Panel    'ΜΟΙΡΕΣ ΣΕ ΔΕΚΑΔΙΚΑ";
mostCurrent._moiresdek = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private lotl As EditText";
mostCurrent._lotl = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private lot As EditText";
mostCurrent._lot = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private lotLEPTA As EditText";
mostCurrent._lotlepta = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private lotDEYT As EditText";
mostCurrent._lotdeyt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private lat As EditText";
mostCurrent._lat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private latLEPTA As EditText";
mostCurrent._latlepta = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private latDEYT As EditText";
mostCurrent._latdeyt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private DekLot As EditText";
mostCurrent._deklot = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private DekLat As EditText";
mostCurrent._deklat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private egsaLon As EditText";
mostCurrent._egsalon = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private egsaLAt As EditText";
mostCurrent._egsalat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private okEgsa As Button";
mostCurrent._okegsa = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private okDekadika As Button";
mostCurrent._okdekadika = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private okMoires As Button";
mostCurrent._okmoires = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private lotMono As EditText";
mostCurrent._lotmono = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private latMono As EditText";
mostCurrent._latmono = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Dim egsaLatB As Boolean";
_egsalatb = false;
 //BA.debugLineNum = 64;BA.debugLine="Dim egsaLonB As Boolean";
_egsalonb = false;
 //BA.debugLineNum = 65;BA.debugLine="Dim deklotB As Boolean";
_deklotb = false;
 //BA.debugLineNum = 66;BA.debugLine="Dim deklatB As Boolean";
_deklatb = false;
 //BA.debugLineNum = 68;BA.debugLine="Dim latB As Boolean";
_latb = false;
 //BA.debugLineNum = 69;BA.debugLine="Dim lotB As Boolean";
_lotb = false;
 //BA.debugLineNum = 70;BA.debugLine="Dim lotLEPTAB As Boolean";
_lotleptab = false;
 //BA.debugLineNum = 71;BA.debugLine="Dim latLEPTAB As Boolean";
_latleptab = false;
 //BA.debugLineNum = 72;BA.debugLine="Dim latDEYTB As Boolean";
_latdeytb = false;
 //BA.debugLineNum = 73;BA.debugLine="Dim lotDEYTB As Boolean";
_lotdeytb = false;
 //BA.debugLineNum = 74;BA.debugLine="Private okDel As Button";
mostCurrent._okdel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _gps_locationchanged(anywheresoftware.b4a.gps.LocationWrapper _location1) throws Exception{
anywheresoftware.b4a.gps.LocationWrapper _egsan = null;
anywheresoftware.b4a.gps.LocationWrapper _egsae = null;
anywheresoftware.b4a.gps.LocationWrapper _convertmoires = null;
 //BA.debugLineNum = 186;BA.debugLine="Sub GPS_LocationChanged (Location1 As Location)";
 //BA.debugLineNum = 191;BA.debugLine="Dim egsaN As Location";
_egsan = new anywheresoftware.b4a.gps.LocationWrapper();
 //BA.debugLineNum = 192;BA.debugLine="Dim egsaE As Location";
_egsae = new anywheresoftware.b4a.gps.LocationWrapper();
 //BA.debugLineNum = 193;BA.debugLine="egsaE.Initialize";
_egsae.Initialize();
 //BA.debugLineNum = 194;BA.debugLine="egsaN.Initialize";
_egsan.Initialize();
 //BA.debugLineNum = 196;BA.debugLine="Dim convertMOires As Location";
_convertmoires = new anywheresoftware.b4a.gps.LocationWrapper();
 //BA.debugLineNum = 201;BA.debugLine="Log(\"latitude\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546255","latitude",0);
 //BA.debugLineNum = 202;BA.debugLine="Log(Location1.Latitude) '41.13848163";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546256",BA.NumberToString(_location1.getLatitude()),0);
 //BA.debugLineNum = 203;BA.debugLine="Log(\"longitude\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546257","longitude",0);
 //BA.debugLineNum = 204;BA.debugLine="Log(Location1.Longitude) '24.89279149";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546258",BA.NumberToString(_location1.getLongitude()),0);
 //BA.debugLineNum = 209;BA.debugLine="Log(\"convert latitude to seconds\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546263","convert latitude to seconds",0);
 //BA.debugLineNum = 210;BA.debugLine="Log(Location1.ConvertToseconds(Location1.Latitude";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546264",_location1.ConvertToSeconds(_location1.getLatitude()),0);
 //BA.debugLineNum = 211;BA.debugLine="Log(\"convert longitude to seconds\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546265","convert longitude to seconds",0);
 //BA.debugLineNum = 212;BA.debugLine="Log(Location1.ConvertToseconds(Location1.Longitud";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546266",_location1.ConvertToSeconds(_location1.getLongitude()),0);
 //BA.debugLineNum = 213;BA.debugLine="Log(\"-------------------------------\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546267","-------------------------------",0);
 //BA.debugLineNum = 214;BA.debugLine="Log(\"convert latitude to minutes\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546268","convert latitude to minutes",0);
 //BA.debugLineNum = 215;BA.debugLine="Log(Location1.ConvertTominutes(Location1.Latitude";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546269",_location1.ConvertToMinutes(_location1.getLatitude()),0);
 //BA.debugLineNum = 216;BA.debugLine="Log(\"convert longitude to minutes\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546270","convert longitude to minutes",0);
 //BA.debugLineNum = 217;BA.debugLine="Log(Location1.ConvertTominutes(Location1.Longitud";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546271",_location1.ConvertToMinutes(_location1.getLongitude()),0);
 //BA.debugLineNum = 219;BA.debugLine="res = Egsa87.FLWGS84_TO_XYEGSA87(Location1.Latitu";
mostCurrent._res = mostCurrent._egsa87._flwgs84_to_xyegsa87(mostCurrent.activityBA,_location1.getLatitude(),_location1.getLongitude());
 //BA.debugLineNum = 221;BA.debugLine="egsaLon.text =\"X: \" & Round2(res.Get(0),3) 'X: 57";
mostCurrent._egsalon.setText(BA.ObjectToCharSequence("X: "+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (0)))),(int) (3)))));
 //BA.debugLineNum = 222;BA.debugLine="egsaLAt.text =\"Y: \" & Round2(res.Get(1),3) 'Y: 45";
mostCurrent._egsalat.setText(BA.ObjectToCharSequence("Y: "+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (1)))),(int) (3)))));
 //BA.debugLineNum = 225;BA.debugLine="Log(\"-------------------------------\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546279","-------------------------------",0);
 //BA.debugLineNum = 226;BA.debugLine="Log(\"res   και εγσα\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546280","res   και εγσα",0);
 //BA.debugLineNum = 227;BA.debugLine="Log(res)";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546281",BA.ObjectToString(mostCurrent._res),0);
 //BA.debugLineNum = 228;BA.debugLine="Log(egsaLon.text)";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546282",mostCurrent._egsalon.getText(),0);
 //BA.debugLineNum = 229;BA.debugLine="Log(egsaLAt.text)";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546283",mostCurrent._egsalat.getText(),0);
 //BA.debugLineNum = 230;BA.debugLine="Log(\"-------------------------------\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546284","-------------------------------",0);
 //BA.debugLineNum = 233;BA.debugLine="Log(\"Μετατροπη απο ΕΓΣΑ σε seconds\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546287","Μετατροπη απο ΕΓΣΑ σε seconds",0);
 //BA.debugLineNum = 234;BA.debugLine="Log(egsaN.ConvertToseconds(Location1.Latitude))";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546288",_egsan.ConvertToSeconds(_location1.getLatitude()),0);
 //BA.debugLineNum = 235;BA.debugLine="Log(egsaE.ConvertToseconds(Location1.Longitude))";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546289",_egsae.ConvertToSeconds(_location1.getLongitude()),0);
 //BA.debugLineNum = 236;BA.debugLine="Log(\"-------------------------------\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546290","-------------------------------",0);
 //BA.debugLineNum = 239;BA.debugLine="Log(\"Μετατροπη απο ΕΓΣΑ σε minutes\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546293","Μετατροπη απο ΕΓΣΑ σε minutes",0);
 //BA.debugLineNum = 240;BA.debugLine="Log(egsaN.ConvertTominutes(Location1.Latitude))";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546294",_egsan.ConvertToMinutes(_location1.getLatitude()),0);
 //BA.debugLineNum = 241;BA.debugLine="Log(egsaE.ConvertTominutes(Location1.Longitude))";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546295",_egsae.ConvertToMinutes(_location1.getLongitude()),0);
 //BA.debugLineNum = 242;BA.debugLine="Log(\"-------------------------------\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546296","-------------------------------",0);
 //BA.debugLineNum = 247;BA.debugLine="Log(\"-------------------------------\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546301","-------------------------------",0);
 //BA.debugLineNum = 248;BA.debugLine="Log(\"-------------------------------\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7161546302","-------------------------------",0);
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return "";
}
public static String  _gps1_gpsstatus(anywheresoftware.b4a.objects.collections.List _satellites) throws Exception{
int _i = 0;
String _txt1 = "";
String _txt2 = "";
String _txt3 = "";
String _txt4 = "";
String _txt5 = "";
anywheresoftware.b4a.gps.GpsSatelliteWrapper _gpssat = null;
 //BA.debugLineNum = 280;BA.debugLine="Sub GPS1_GpsStatus (Satellites As List)";
 //BA.debugLineNum = 281;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 283;BA.debugLine="Dim txt1, txt2, txt3, txt4, txt5 As String";
_txt1 = "";
_txt2 = "";
_txt3 = "";
_txt4 = "";
_txt5 = "";
 //BA.debugLineNum = 285;BA.debugLine="txt1 = \"Index\"";
_txt1 = "Index";
 //BA.debugLineNum = 286;BA.debugLine="txt2 = \"Azimuth\"";
_txt2 = "Azimuth";
 //BA.debugLineNum = 287;BA.debugLine="txt3 = \"Elevation\"";
_txt3 = "Elevation";
 //BA.debugLineNum = 288;BA.debugLine="txt4 = \"Used\"";
_txt4 = "Used";
 //BA.debugLineNum = 289;BA.debugLine="txt5 = \"S / N ratio\"";
_txt5 = "S / N ratio";
 //BA.debugLineNum = 291;BA.debugLine="Activity.Title = \"Sats \" & Satellites.Size";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Sats "+BA.NumberToString(_satellites.getSize())));
 //BA.debugLineNum = 292;BA.debugLine="For i = 0 To Satellites.Size -1";
{
final int step9 = 1;
final int limit9 = (int) (_satellites.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 293;BA.debugLine="Dim GPSSat As GPSSatellite";
_gpssat = new anywheresoftware.b4a.gps.GpsSatelliteWrapper();
 //BA.debugLineNum = 294;BA.debugLine="GPSSat = Satellites.Get(i)";
_gpssat.setObject((android.location.GpsSatellite)(_satellites.Get(_i)));
 //BA.debugLineNum = 295;BA.debugLine="txt1 = txt1 & CRLF & (i + 1)";
_txt1 = _txt1+anywheresoftware.b4a.keywords.Common.CRLF+BA.NumberToString((_i+1));
 //BA.debugLineNum = 296;BA.debugLine="txt2 = txt2 & CRLF & GPSSat.Azimuth";
_txt2 = _txt2+anywheresoftware.b4a.keywords.Common.CRLF+BA.NumberToString(_gpssat.getAzimuth());
 //BA.debugLineNum = 297;BA.debugLine="txt3 = txt3 & CRLF & GPSSat.Elevation";
_txt3 = _txt3+anywheresoftware.b4a.keywords.Common.CRLF+BA.NumberToString(_gpssat.getElevation());
 //BA.debugLineNum = 298;BA.debugLine="txt4 = txt4 & CRLF & GPSSat.UsedInFix";
_txt4 = _txt4+anywheresoftware.b4a.keywords.Common.CRLF+BA.ObjectToString(_gpssat.getUsedInFix());
 //BA.debugLineNum = 299;BA.debugLine="txt5 = txt5 & CRLF & Round2(GPSSat.Snr, 2)";
_txt5 = _txt5+anywheresoftware.b4a.keywords.Common.CRLF+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Round2(_gpssat.getSnr(),(int) (2)));
 //BA.debugLineNum = 300;BA.debugLine="Activity.Title = \"Set \" & i";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Set "+BA.NumberToString(_i)));
 }
};
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 144;BA.debugLine="StartActivity(\"firstaid\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("firstaid"));
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 138;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _lat_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 530;BA.debugLine="Sub lat_TextChanged (Old As String, New As String)";
 //BA.debugLineNum = 531;BA.debugLine="If lat.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._lat.getText()))>1) { 
 //BA.debugLineNum = 532;BA.debugLine="latB = True";
_latb = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 534;BA.debugLine="End Sub";
return "";
}
public static String  _latdeyt_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 550;BA.debugLine="Sub latDEYT_TextChanged (Old As String, New As Str";
 //BA.debugLineNum = 551;BA.debugLine="If latDEYT.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._latdeyt.getText()))>1) { 
 //BA.debugLineNum = 552;BA.debugLine="latDEYTB = True";
_latdeytb = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 554;BA.debugLine="End Sub";
return "";
}
public static String  _latlepta_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 545;BA.debugLine="Sub latLEPTA_TextChanged (Old As String, New As St";
 //BA.debugLineNum = 546;BA.debugLine="If latLEPTA.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._latlepta.getText()))>1) { 
 //BA.debugLineNum = 547;BA.debugLine="latLEPTAB = True";
_latleptab = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 549;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 135;BA.debugLine="StartActivity(\"thlefona\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("thlefona"));
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public static String  _lot_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 535;BA.debugLine="Sub lot_TextChanged (Old As String, New As String)";
 //BA.debugLineNum = 536;BA.debugLine="If lot.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._lot.getText()))>1) { 
 //BA.debugLineNum = 537;BA.debugLine="lotB = True";
_lotb = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 539;BA.debugLine="End Sub";
return "";
}
public static String  _lotdeyt_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 555;BA.debugLine="Sub lotDEYT_TextChanged (Old As String, New As Str";
 //BA.debugLineNum = 556;BA.debugLine="If lotDEYT.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._lotdeyt.getText()))>1) { 
 //BA.debugLineNum = 557;BA.debugLine="lotDEYTB = True";
_lotdeytb = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 559;BA.debugLine="End Sub";
return "";
}
public static String  _lotlepta_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 540;BA.debugLine="Sub lotLEPTA_TextChanged (Old As String, New As St";
 //BA.debugLineNum = 541;BA.debugLine="If lotLEPTA.Text >1 Then";
if ((double)(Double.parseDouble(mostCurrent._lotlepta.getText()))>1) { 
 //BA.debugLineNum = 542;BA.debugLine="lotLEPTAB = True";
_lotleptab = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 544;BA.debugLine="End Sub";
return "";
}
public static String  _mnagain_click() throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Sub mnagain_Click";
 //BA.debugLineNum = 150;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 151;BA.debugLine="StartActivity(Me)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,restartgpsapp.getObject());
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public static String  _mnasend_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _share = null;
 //BA.debugLineNum = 158;BA.debugLine="Sub mnasend_Click";
 //BA.debugLineNum = 160;BA.debugLine="Dim share As Intent";
_share = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 162;BA.debugLine="share.Initialize(share.ACTION_SEND,\"\")";
_share.Initialize(_share.ACTION_SEND,"");
 //BA.debugLineNum = 163;BA.debugLine="share.SetType(\"text/plain\")";
_share.SetType("text/plain");
 //BA.debugLineNum = 164;BA.debugLine="share.PutExtra(\"android.intent.extra.TEXT\", File.";
_share.PutExtra("android.intent.extra.TEXT",(Object)(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt")));
 //BA.debugLineNum = 165;BA.debugLine="share.WrapAsIntentChooser(\"Share text via\")";
_share.WrapAsIntentChooser("Share text via");
 //BA.debugLineNum = 166;BA.debugLine="StartActivity(share)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_share.getObject()));
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return "";
}
public static String  _okdekadika_click() throws Exception{
anywheresoftware.b4a.gps.LocationWrapper _location1 = null;
anywheresoftware.b4a.gps.LocationWrapper _location2 = null;
 //BA.debugLineNum = 440;BA.debugLine="Sub okDekadika_Click";
 //BA.debugLineNum = 441;BA.debugLine="Dim location1 As Location";
_location1 = new anywheresoftware.b4a.gps.LocationWrapper();
 //BA.debugLineNum = 442;BA.debugLine="Dim location2 As Location";
_location2 = new anywheresoftware.b4a.gps.LocationWrapper();
 //BA.debugLineNum = 443;BA.debugLine="Dim deklotB As Boolean";
_deklotb = false;
 //BA.debugLineNum = 444;BA.debugLine="Dim deklatB As Boolean";
_deklatb = false;
 //BA.debugLineNum = 445;BA.debugLine="If deklotB = True Then";
if (_deklotb==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 446;BA.debugLine="If deklatB = True Then";
if (_deklatb==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 447;BA.debugLine="lat.Text = location1.ConvertToseconds(DekLat.te";
mostCurrent._lat.setText(BA.ObjectToCharSequence(_location1.ConvertToSeconds((double)(Double.parseDouble(mostCurrent._deklat.getText())))));
 //BA.debugLineNum = 448;BA.debugLine="lot.Text = location2.ConvertToseconds(DekLot.te";
mostCurrent._lot.setText(BA.ObjectToCharSequence(_location2.ConvertToSeconds((double)(Double.parseDouble(mostCurrent._deklot.getText())))));
 //BA.debugLineNum = 449;BA.debugLine="res = Egsa87.FLWGS84_TO_XYEGSA87(DekLot.text,De";
mostCurrent._res = mostCurrent._egsa87._flwgs84_to_xyegsa87(mostCurrent.activityBA,(double)(Double.parseDouble(mostCurrent._deklot.getText())),(double)(Double.parseDouble(mostCurrent._deklat.getText())));
 //BA.debugLineNum = 451;BA.debugLine="egsaLon.text =Round2(res.Get(0),3)";
mostCurrent._egsalon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (0)))),(int) (3))));
 //BA.debugLineNum = 452;BA.debugLine="egsaLAt.text =Round2(res.Get(1),3)";
mostCurrent._egsalat.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (1)))),(int) (3))));
 //BA.debugLineNum = 453;BA.debugLine="okEgsa.Visible = False";
mostCurrent._okegsa.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 454;BA.debugLine="okMoires.Visible = False";
mostCurrent._okmoires.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 455;BA.debugLine="lat.Visible = False";
mostCurrent._lat.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 456;BA.debugLine="latLEPTA.Visible = False";
mostCurrent._latlepta.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 457;BA.debugLine="latDEYT.Visible = False";
mostCurrent._latdeyt.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 458;BA.debugLine="lot.Visible = False";
mostCurrent._lot.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 459;BA.debugLine="lotLEPTA.Visible = False";
mostCurrent._lotlepta.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 460;BA.debugLine="lotDEYT.Visible = False";
mostCurrent._lotdeyt.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else {
 //BA.debugLineNum = 463;BA.debugLine="ToastMessageShow(\"Συμπληρώστε ολα τα πεδία\", Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Συμπληρώστε ολα τα πεδία"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return "";
}
public static String  _okdel_click() throws Exception{
 //BA.debugLineNum = 561;BA.debugLine="Sub okDel_Click";
 //BA.debugLineNum = 587;BA.debugLine="StartActivity(gpsApp)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gpsapp.getObject()));
 //BA.debugLineNum = 588;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 589;BA.debugLine="End Sub";
return "";
}
public static String  _okegsa_click() throws Exception{
anywheresoftware.b4a.gps.LocationWrapper _location1 = null;
anywheresoftware.b4a.gps.LocationWrapper _location2 = null;
 //BA.debugLineNum = 467;BA.debugLine="Sub okEgsa_Click";
 //BA.debugLineNum = 468;BA.debugLine="Dim location1 As Location";
_location1 = new anywheresoftware.b4a.gps.LocationWrapper();
 //BA.debugLineNum = 469;BA.debugLine="Dim location2 As Location";
_location2 = new anywheresoftware.b4a.gps.LocationWrapper();
 //BA.debugLineNum = 474;BA.debugLine="If egsaLatB = True Then";
if (_egsalatb==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 475;BA.debugLine="If egsaLonB = True Then";
if (_egsalonb==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 476;BA.debugLine="res = Egsa87.XYEGSA_TO_FLWGS84(egsaLon.text,egs";
mostCurrent._res = mostCurrent._egsa87._xyegsa_to_flwgs84(mostCurrent.activityBA,(double)(Double.parseDouble(mostCurrent._egsalon.getText())),(double)(Double.parseDouble(mostCurrent._egsalat.getText())));
 //BA.debugLineNum = 477;BA.debugLine="DekLot.text =Round2(res.Get(0),5)";
mostCurrent._deklot.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (0)))),(int) (5))));
 //BA.debugLineNum = 478;BA.debugLine="DekLat.text =Round2(res.Get(1),5)";
mostCurrent._deklat.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (1)))),(int) (5))));
 //BA.debugLineNum = 480;BA.debugLine="okMoires.Visible = False";
mostCurrent._okmoires.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 481;BA.debugLine="okDekadika.Visible = False";
mostCurrent._okdekadika.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 482;BA.debugLine="lat.Visible = False";
mostCurrent._lat.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 483;BA.debugLine="latLEPTA.Visible = False";
mostCurrent._latlepta.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 484;BA.debugLine="latDEYT.Visible = False";
mostCurrent._latdeyt.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 485;BA.debugLine="lot.Visible = False";
mostCurrent._lot.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 486;BA.debugLine="lotLEPTA.Visible = False";
mostCurrent._lotlepta.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 487;BA.debugLine="lotDEYT.Visible = False";
mostCurrent._lotdeyt.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 488;BA.debugLine="latMono.Visible = True";
mostCurrent._latmono.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 489;BA.debugLine="lotMono.Visible = True";
mostCurrent._lotmono.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 490;BA.debugLine="lotMono.BringToFront";
mostCurrent._lotmono.BringToFront();
 //BA.debugLineNum = 491;BA.debugLine="lotMono.BringToFront";
mostCurrent._lotmono.BringToFront();
 //BA.debugLineNum = 492;BA.debugLine="latMono.Text = location1.ConvertToseconds(DekLa";
mostCurrent._latmono.setText(BA.ObjectToCharSequence(_location1.ConvertToSeconds((double)(Double.parseDouble(mostCurrent._deklat.getText())))));
 //BA.debugLineNum = 493;BA.debugLine="lotMono.Text = location2.ConvertToseconds(DekLo";
mostCurrent._lotmono.setText(BA.ObjectToCharSequence(_location2.ConvertToSeconds((double)(Double.parseDouble(mostCurrent._deklot.getText())))));
 };
 }else {
 //BA.debugLineNum = 497;BA.debugLine="ToastMessageShow(\"Συμπληρώστε ολα τα πεδία\", Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Συμπληρώστε ολα τα πεδία"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 500;BA.debugLine="End Sub";
return "";
}
public static String  _okmoires_click() throws Exception{
double _dklatmin = 0;
double _dklotmin = 0;
double _dklatsec = 0;
double _dklotsec = 0;
 //BA.debugLineNum = 386;BA.debugLine="Sub okMoires_Click";
 //BA.debugLineNum = 396;BA.debugLine="Dim dklatMin As Double";
_dklatmin = 0;
 //BA.debugLineNum = 397;BA.debugLine="Dim dklotMin As Double";
_dklotmin = 0;
 //BA.debugLineNum = 398;BA.debugLine="Dim dklatSec As Double";
_dklatsec = 0;
 //BA.debugLineNum = 399;BA.debugLine="Dim dklotSec As Double";
_dklotsec = 0;
 //BA.debugLineNum = 400;BA.debugLine="If latB = True Then";
if (_latb==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 401;BA.debugLine="If lotB = True Then";
if (_lotb==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 402;BA.debugLine="If lotLEPTAB = True Then";
if (_lotleptab==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 403;BA.debugLine="If latLEPTAB = True Then";
if (_latleptab==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 404;BA.debugLine="If lotDEYTB = True Then";
if (_lotdeytb==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 405;BA.debugLine="If lotDEYTB = True Then";
if (_lotdeytb==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 410;BA.debugLine="dklatMin = latLEPTA.text/ \"60\"";
_dklatmin = (double)(Double.parseDouble(mostCurrent._latlepta.getText()))/(double)(double)(Double.parseDouble("60"));
 //BA.debugLineNum = 411;BA.debugLine="dklotMin = lotLEPTA.text/ \"60\"";
_dklotmin = (double)(Double.parseDouble(mostCurrent._lotlepta.getText()))/(double)(double)(Double.parseDouble("60"));
 //BA.debugLineNum = 412;BA.debugLine="dklatSec = (latDEYT.text / \"60\") * (\"1\" /\"6";
_dklatsec = ((double)(Double.parseDouble(mostCurrent._latdeyt.getText()))/(double)(double)(Double.parseDouble("60")))*((double)(Double.parseDouble("1"))/(double)(double)(Double.parseDouble("60")));
 //BA.debugLineNum = 413;BA.debugLine="dklotSec = (lotDEYT.text / \"60\") * (\"1\" /\"6";
_dklotsec = ((double)(Double.parseDouble(mostCurrent._lotdeyt.getText()))/(double)(double)(Double.parseDouble("60")))*((double)(Double.parseDouble("1"))/(double)(double)(Double.parseDouble("60")));
 //BA.debugLineNum = 414;BA.debugLine="DekLat.text = Round2(lat.text + dklatMin +";
mostCurrent._deklat.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Round2((double)(Double.parseDouble(mostCurrent._lat.getText()))+_dklatmin+_dklatsec,(int) (5))));
 //BA.debugLineNum = 415;BA.debugLine="DekLot.text = Round2(lot.text + dklotMin  +";
mostCurrent._deklot.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Round2((double)(Double.parseDouble(mostCurrent._lot.getText()))+_dklotmin+_dklotsec,(int) (5))));
 //BA.debugLineNum = 420;BA.debugLine="res = Egsa87.FLWGS84_TO_XYEGSA87(DekLot.tex";
mostCurrent._res = mostCurrent._egsa87._flwgs84_to_xyegsa87(mostCurrent.activityBA,(double)(Double.parseDouble(mostCurrent._deklot.getText())),(double)(Double.parseDouble(mostCurrent._deklat.getText())));
 //BA.debugLineNum = 422;BA.debugLine="egsaLon.text =Round2(res.Get(0),3)";
mostCurrent._egsalon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (0)))),(int) (3))));
 //BA.debugLineNum = 423;BA.debugLine="egsaLAt.text =Round2(res.Get(1),3)";
mostCurrent._egsalat.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (1)))),(int) (3))));
 //BA.debugLineNum = 427;BA.debugLine="okDekadika.Visible = False";
mostCurrent._okdekadika.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 428;BA.debugLine="okEgsa.Visible = False";
mostCurrent._okegsa.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
 };
 };
 }else {
 };
 //BA.debugLineNum = 438;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 141;BA.debugLine="StartActivity(\"gpssignal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssignal"));
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim GPS1 As GPS";
_gps1 = new anywheresoftware.b4a.gps.GPS();
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
}
