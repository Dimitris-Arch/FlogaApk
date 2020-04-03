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

public class gpssignal extends Activity implements B4AActivity{
	public static gpssignal mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.gpssignal");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (gpssignal).");
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
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.gpssignal");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.gpssignal", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (gpssignal) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (gpssignal) Resume **");
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
		return gpssignal.class;
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
        BA.LogInfo("** Activity (gpssignal) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            gpssignal mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (gpssignal) Resume **");
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
public static anywheresoftware.b4a.gps.GPS _gps1 = null;
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _mple = null;
public anywheresoftware.b4a.objects.LabelWrapper _simanseislabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _simanseislabel2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _listabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _katigorlabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ousialabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ililabel = null;
public flm.b4a.scrollview2d.ScrollView2DWrapper _sv2d = null;
public anywheresoftware.b4a.agraham.dialogs.InputDialog _id = null;
public static int _k = 0;
public anywheresoftware.b4a.objects.collections.List _res = null;
public anywheresoftware.b4a.objects.LabelWrapper _egsalat = null;
public anywheresoftware.b4a.objects.LabelWrapper _egsalon = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
public anywheresoftware.b4a.phone.Phone.PhoneWakeState _pw = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllon1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllat1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblsatellites = null;
public anywheresoftware.b4a.objects.LabelWrapper _txt = null;
public anywheresoftware.b4a.objects.LabelWrapper _txtall = null;
public static long _now = 0L;
public static String _t = "";
public static String _s = "";
public anywheresoftware.b4a.objects.LabelWrapper _txtgooglon = null;
public anywheresoftware.b4a.objects.LabelWrapper _txtgooglan = null;
public anywheresoftware.b4a.objects.LabelWrapper _googlan = null;
public anywheresoftware.b4a.objects.LabelWrapper _googlon = null;
public anywheresoftware.b4a.phone.Phone.PhoneSensors _ps = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sc = null;
public anywheresoftware.b4a.objects.LabelWrapper _lat = null;
public anywheresoftware.b4a.objects.LabelWrapper _lot = null;
public anywheresoftware.b4a.objects.LabelWrapper _lotl = null;
public anywheresoftware.b4a.objects.LabelWrapper _latl = null;
public anywheresoftware.b4a.objects.LabelWrapper _ipsos = null;
public anywheresoftware.b4a.objects.LabelWrapper _txt0 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sima1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _sima2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _simaok = null;
public anywheresoftware.b4a.objects.LabelWrapper _sima = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelola = null;
public anywheresoftware.b4a.objects.LabelWrapper _ipsosl = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelab = null;
public anywheresoftware.b4a.objects.ButtonWrapper _a = null;
public anywheresoftware.b4a.objects.ButtonWrapper _a1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _b = null;
public anywheresoftware.b4a.objects.ButtonWrapper _g = null;
public anywheresoftware.b4a.objects.ButtonWrapper _d = null;
public anywheresoftware.b4a.objects.ButtonWrapper _e = null;
public anywheresoftware.b4a.objects.ButtonWrapper _z = null;
public anywheresoftware.b4a.objects.ButtonWrapper _h = null;
public com.gvoulg.egsa87.egsa87 _egsa87 = null;
public firefighter.companion.main _main = null;
public firefighter.companion.rss _rss = null;
public firefighter.companion.rssdyo _rssdyo = null;
public firefighter.companion.deiktes _deiktes = null;
public firefighter.companion.avrio _avrio = null;
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
public static String  _a_click() throws Exception{
 //BA.debugLineNum = 611;BA.debugLine="Sub a_click";
 //BA.debugLineNum = 612;BA.debugLine="save_click";
_save_click();
 //BA.debugLineNum = 613;BA.debugLine="End Sub";
return "";
}
public static String  _a1_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _r = null;
com.maximus.id.id _x = null;
String _m = "";
 //BA.debugLineNum = 632;BA.debugLine="Sub a1_click";
 //BA.debugLineNum = 635;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 636;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 637;BA.debugLine="r.AddAll(Array As String(\"Αποθηκεύση στην επιλε";
_r.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Αποθηκεύση στην επιλεγμένη μορφή","Αποθηκεύση σε ΕΓΣΑ87 και WGS84"}));
 //BA.debugLineNum = 640;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
 //BA.debugLineNum = 641;BA.debugLine="m = x.InputList1(r,\"Επιλογή μορφής για αποθηκεύ";
_m = BA.NumberToString(_x.InputList1(_r,"Επιλογή μορφής για αποθηκεύση",mostCurrent.activityBA));
 //BA.debugLineNum = 643;BA.debugLine="If m = 0 Then";
if ((_m).equals(BA.NumberToString(0))) { 
 //BA.debugLineNum = 644;BA.debugLine="monoegsa";
_monoegsa();
 };
 //BA.debugLineNum = 646;BA.debugLine="If m = 1 Then";
if ((_m).equals(BA.NumberToString(1))) { 
 //BA.debugLineNum = 647;BA.debugLine="mazi";
_mazi();
 };
 //BA.debugLineNum = 649;BA.debugLine="End Sub";
return "";
}
public static void  _activity_create(boolean _firsttime) throws Exception{
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(firefighter.companion.gpssignal parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
firefighter.companion.gpssignal parent;
boolean _firsttime;
String _permission = "";
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 113;BA.debugLine="Activity.LoadLayout(\"gpss\")";
parent.mostCurrent._activity.LoadLayout("gpss",mostCurrent.activityBA);
 //BA.debugLineNum = 114;BA.debugLine="pw.KeepAlive(True)";
parent.mostCurrent._pw.KeepAlive(processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 115;BA.debugLine="k = 0";
parent._k = (int) (0);
 //BA.debugLineNum = 116;BA.debugLine="timer1.Initialize(\"timer1\",500)";
parent._timer1.Initialize(processBA,"timer1",(long) (500));
 //BA.debugLineNum = 117;BA.debugLine="timer1.Enabled = True";
parent._timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 118;BA.debugLine="bmp.InitializeSample(File.DirAssets, \"titlos.png\"";
parent.mostCurrent._bmp.InitializeSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"titlos.png",(int) (48),(int) (48));
 //BA.debugLineNum = 120;BA.debugLine="GPS1.Initialize(\"GPS\")";
parent._gps1.Initialize("GPS");
 //BA.debugLineNum = 130;BA.debugLine="If GPS1.GPSEnabled = False Then";
if (true) break;

case 1:
//if
this.state = 16;
if (parent._gps1.getGPSEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 16;
 //BA.debugLineNum = 131;BA.debugLine="ToastMessageShow(\"Παρακαλω ενεργοποιήστε το GPS\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Παρακαλω ενεργοποιήστε το GPS"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 132;BA.debugLine="StartActivity(GPS1.LocationSettingsIntent) 'Will";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(parent._gps1.getLocationSettingsIntent()));
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 134;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_ACCESS_FINE_LOC";
parent._rp.CheckAndRequest(processBA,parent._rp.PERMISSION_ACCESS_FINE_LOCATION);
 //BA.debugLineNum = 135;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 29;
return;
case 29:
//C
this.state = 6;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 136;BA.debugLine="If Result Then GPS1.Start(0, 0)";
if (true) break;

case 6:
//if
this.state = 11;
if (_result) { 
this.state = 8;
;}if (true) break;

case 8:
//C
this.state = 11;
parent._gps1.Start(processBA,(long) (0),(float) (0));
if (true) break;

case 11:
//C
this.state = 12;
;
 //BA.debugLineNum = 137;BA.debugLine="If Result = False Then";
if (true) break;

case 12:
//if
this.state = 15;
if (_result==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 138;BA.debugLine="ToastMessageShow(\"Η εφαρμογή χρειάζεται δικαιωμ";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Η εφαρμογή χρειάζεται δικαιωματα στο gps της συσκευης"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;
;
 //BA.debugLineNum = 142;BA.debugLine="If File.Exists(File.DirInternal, \"gpsfire.txt\") =";

case 16:
//if
this.state = 19;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt")==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 18;
}if (true) break;

case 18:
//C
this.state = 19;
 //BA.debugLineNum = 143;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfire.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt",parent.mostCurrent._txtall.getText());
 if (true) break;
;
 //BA.debugLineNum = 145;BA.debugLine="If File.Exists(File.DirInternal, \"gpsfireall.txt\"";

case 19:
//if
this.state = 22;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfireall.txt")==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
 //BA.debugLineNum = 146;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfireall.t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfireall.txt",parent.mostCurrent._txtall.getText());
 if (true) break;
;
 //BA.debugLineNum = 148;BA.debugLine="If File.Exists(File.DirInternal, \"txtgooglon.txt\"";

case 22:
//if
this.state = 25;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglon.txt")==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 24;
}if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 149;BA.debugLine="File.WriteString(File.DirInternal, \"txtgooglon.t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglon.txt",parent.mostCurrent._txtall.getText());
 if (true) break;
;
 //BA.debugLineNum = 151;BA.debugLine="If File.Exists(File.DirInternal, \"txtgooglan.txt\"";

case 25:
//if
this.state = 28;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglan.txt")==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 27;
}if (true) break;

case 27:
//C
this.state = 28;
 //BA.debugLineNum = 152;BA.debugLine="File.WriteString(File.DirInternal, \"txtgooglan.t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglan.txt",parent.mostCurrent._txtall.getText());
 if (true) break;

case 28:
//C
this.state = -1;
;
 //BA.debugLineNum = 154;BA.debugLine="txtall.Text = File.ReadString(File.DirInternal, \"";
parent.mostCurrent._txtall.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfireall.txt")));
 //BA.debugLineNum = 155;BA.debugLine="googlon.text = File.ReadString(File.DirInternal,";
parent.mostCurrent._googlon.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglon.txt")));
 //BA.debugLineNum = 156;BA.debugLine="googlan.text = File.ReadString(File.DirInternal,";
parent.mostCurrent._googlan.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglan.txt")));
 //BA.debugLineNum = 158;BA.debugLine="googlon.text = googlon.text.Replace (\":\",\" \")";
parent.mostCurrent._googlon.setText(BA.ObjectToCharSequence(parent.mostCurrent._googlon.getText().replace(":"," ")));
 //BA.debugLineNum = 159;BA.debugLine="googlon.text = googlon.text.Replace (\",\",\".\")";
parent.mostCurrent._googlon.setText(BA.ObjectToCharSequence(parent.mostCurrent._googlon.getText().replace(",",".")));
 //BA.debugLineNum = 161;BA.debugLine="googlan.text = googlan.text.Replace (\":\",\" \")";
parent.mostCurrent._googlan.setText(BA.ObjectToCharSequence(parent.mostCurrent._googlan.getText().replace(":"," ")));
 //BA.debugLineNum = 162;BA.debugLine="googlan.text = googlan.text.Replace (\",\",\".\")";
parent.mostCurrent._googlan.setText(BA.ObjectToCharSequence(parent.mostCurrent._googlan.getText().replace(",",".")));
 //BA.debugLineNum = 166;BA.debugLine="sv2d.Initialize(240%x, 10%y, \"sv2d\")";
parent.mostCurrent._sv2d.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (240),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),"sv2d");
 //BA.debugLineNum = 167;BA.debugLine="Panelab.AddView(sv2d, 0%x, 0%y, 100%x, 10%y)";
parent.mostCurrent._panelab.AddView((android.view.View)(parent.mostCurrent._sv2d.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 170;BA.debugLine="a.Initialize(\"a\")";
parent.mostCurrent._a.Initialize(mostCurrent.activityBA,"a");
 //BA.debugLineNum = 171;BA.debugLine="a1.Initialize(\"a1\")";
parent.mostCurrent._a1.Initialize(mostCurrent.activityBA,"a1");
 //BA.debugLineNum = 172;BA.debugLine="b.Initialize(\"b\")";
parent.mostCurrent._b.Initialize(mostCurrent.activityBA,"b");
 //BA.debugLineNum = 173;BA.debugLine="g.Initialize(\"g\")";
parent.mostCurrent._g.Initialize(mostCurrent.activityBA,"g");
 //BA.debugLineNum = 174;BA.debugLine="d.Initialize(\"d\")";
parent.mostCurrent._d.Initialize(mostCurrent.activityBA,"d");
 //BA.debugLineNum = 175;BA.debugLine="e.Initialize(\"e\")";
parent.mostCurrent._e.Initialize(mostCurrent.activityBA,"e");
 //BA.debugLineNum = 176;BA.debugLine="z.Initialize(\"z\")";
parent.mostCurrent._z.Initialize(mostCurrent.activityBA,"z");
 //BA.debugLineNum = 177;BA.debugLine="h.Initialize(\"h\")";
parent.mostCurrent._h.Initialize(mostCurrent.activityBA,"h");
 //BA.debugLineNum = 178;BA.debugLine="a.Text = \"Αποθήκευση Συντεταγμένων\"";
parent.mostCurrent._a.setText(BA.ObjectToCharSequence("Αποθήκευση Συντεταγμένων"));
 //BA.debugLineNum = 179;BA.debugLine="a.TextSize = 14";
parent.mostCurrent._a.setTextSize((float) (14));
 //BA.debugLineNum = 180;BA.debugLine="sv2d.Panel.AddView(a, 0%x, 0%y, 40%x, 10%y)";
parent.mostCurrent._sv2d.getPanel().AddView((android.view.View)(parent.mostCurrent._a.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 181;BA.debugLine="a.SetBackgroundImage(LoadBitmap(File.DirAssets, \"";
parent.mostCurrent._a.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alla.png").getObject()));
 //BA.debugLineNum = 182;BA.debugLine="a.TextColor = Colors.White";
parent.mostCurrent._a.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 183;BA.debugLine="a.Gravity = Gravity.CENTER_VERTICAL";
parent.mostCurrent._a.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 184;BA.debugLine="a.Gravity = Gravity.CENTER_HORIZONTAL";
parent.mostCurrent._a.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 186;BA.debugLine="a1.Text = \"Αποθήκευση Συντεταγμένων\"";
parent.mostCurrent._a1.setText(BA.ObjectToCharSequence("Αποθήκευση Συντεταγμένων"));
 //BA.debugLineNum = 187;BA.debugLine="a1.TextSize = 14";
parent.mostCurrent._a1.setTextSize((float) (14));
 //BA.debugLineNum = 188;BA.debugLine="sv2d.Panel.AddView(a1, 0%x, 0%y, 40%x, 10%y)";
parent.mostCurrent._sv2d.getPanel().AddView((android.view.View)(parent.mostCurrent._a1.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 189;BA.debugLine="a1.SetBackgroundImage(LoadBitmap(File.DirAssets,";
parent.mostCurrent._a1.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alla.png").getObject()));
 //BA.debugLineNum = 190;BA.debugLine="a1.TextColor = Colors.White";
parent.mostCurrent._a1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 191;BA.debugLine="a1.Gravity = Gravity.CENTER_VERTICAL";
parent.mostCurrent._a1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 192;BA.debugLine="a1.Gravity = Gravity.CENTER_HORIZONTAL";
parent.mostCurrent._a1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 193;BA.debugLine="a1.Visible = False";
parent.mostCurrent._a1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 196;BA.debugLine="b.Text = \"Αποστολή συντεταγμένων\"";
parent.mostCurrent._b.setText(BA.ObjectToCharSequence("Αποστολή συντεταγμένων"));
 //BA.debugLineNum = 197;BA.debugLine="b.TextSize = 14";
parent.mostCurrent._b.setTextSize((float) (14));
 //BA.debugLineNum = 198;BA.debugLine="sv2d.Panel.AddView(b, 40%x, 0%y, 40%x, 10%y)";
parent.mostCurrent._sv2d.getPanel().AddView((android.view.View)(parent.mostCurrent._b.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 199;BA.debugLine="b.SetBackgroundImage(LoadBitmap(File.DirAssets, \"";
parent.mostCurrent._b.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alla.png").getObject()));
 //BA.debugLineNum = 200;BA.debugLine="b.TextColor = Colors.White";
parent.mostCurrent._b.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 201;BA.debugLine="b.Gravity = Gravity.CENTER_VERTICAL";
parent.mostCurrent._b.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 202;BA.debugLine="b.Gravity = Gravity.CENTER_HORIZONTAL";
parent.mostCurrent._b.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 205;BA.debugLine="g.Text = \"Τελευταία τοποθεσία\"";
parent.mostCurrent._g.setText(BA.ObjectToCharSequence("Τελευταία τοποθεσία"));
 //BA.debugLineNum = 206;BA.debugLine="g.TextSize = 14";
parent.mostCurrent._g.setTextSize((float) (14));
 //BA.debugLineNum = 207;BA.debugLine="sv2d.Panel.AddView(g, 80%x, 0%y, 40%x, 10%y)";
parent.mostCurrent._sv2d.getPanel().AddView((android.view.View)(parent.mostCurrent._g.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 208;BA.debugLine="g.SetBackgroundImage(LoadBitmap(File.DirAssets, \"";
parent.mostCurrent._g.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alla.png").getObject()));
 //BA.debugLineNum = 209;BA.debugLine="g.TextColor = Colors.White";
parent.mostCurrent._g.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 210;BA.debugLine="g.Gravity = Gravity.CENTER_VERTICAL";
parent.mostCurrent._g.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 211;BA.debugLine="g.Gravity = Gravity.CENTER_HORIZONTAL";
parent.mostCurrent._g.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 214;BA.debugLine="d.Text = \"Ιστορικό\"";
parent.mostCurrent._d.setText(BA.ObjectToCharSequence("Ιστορικό"));
 //BA.debugLineNum = 215;BA.debugLine="d.TextSize = 14";
parent.mostCurrent._d.setTextSize((float) (14));
 //BA.debugLineNum = 216;BA.debugLine="sv2d.Panel.AddView(d, 120%x, 0%y, 40%x, 10%y)";
parent.mostCurrent._sv2d.getPanel().AddView((android.view.View)(parent.mostCurrent._d.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (120),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 217;BA.debugLine="d.SetBackgroundImage(LoadBitmap(File.DirAssets, \"";
parent.mostCurrent._d.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alla.png").getObject()));
 //BA.debugLineNum = 218;BA.debugLine="d.TextColor = Colors.White";
parent.mostCurrent._d.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 219;BA.debugLine="d.Gravity = Gravity.CENTER_VERTICAL";
parent.mostCurrent._d.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 220;BA.debugLine="d.Gravity = Gravity.CENTER_HORIZONTAL";
parent.mostCurrent._d.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 223;BA.debugLine="e.Text = \"Διαγραφή ιστορικού\"";
parent.mostCurrent._e.setText(BA.ObjectToCharSequence("Διαγραφή ιστορικού"));
 //BA.debugLineNum = 224;BA.debugLine="e.TextSize = 14";
parent.mostCurrent._e.setTextSize((float) (14));
 //BA.debugLineNum = 225;BA.debugLine="sv2d.Panel.AddView(e, 160%x, 0%y, 40%x, 10%y)";
parent.mostCurrent._sv2d.getPanel().AddView((android.view.View)(parent.mostCurrent._e.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (160),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 226;BA.debugLine="e.SetBackgroundImage(LoadBitmap(File.DirAssets, \"";
parent.mostCurrent._e.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alla.png").getObject()));
 //BA.debugLineNum = 227;BA.debugLine="e.TextColor = Colors.White";
parent.mostCurrent._e.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 228;BA.debugLine="e.Gravity = Gravity.CENTER_VERTICAL";
parent.mostCurrent._e.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 229;BA.debugLine="e.Gravity = Gravity.CENTER_HORIZONTAL";
parent.mostCurrent._e.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 232;BA.debugLine="z.Text = \"Προβολή στον χάρτη\"";
parent.mostCurrent._z.setText(BA.ObjectToCharSequence("Προβολή στον χάρτη"));
 //BA.debugLineNum = 233;BA.debugLine="z.TextSize = 14";
parent.mostCurrent._z.setTextSize((float) (14));
 //BA.debugLineNum = 234;BA.debugLine="sv2d.Panel.AddView(z, 200%x, 0%y, 40%x, 10%y)";
parent.mostCurrent._sv2d.getPanel().AddView((android.view.View)(parent.mostCurrent._z.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (200),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 235;BA.debugLine="z.SetBackgroundImage(LoadBitmap(File.DirAssets, \"";
parent.mostCurrent._z.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alla.png").getObject()));
 //BA.debugLineNum = 236;BA.debugLine="z.TextColor = Colors.White";
parent.mostCurrent._z.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 237;BA.debugLine="z.Gravity = Gravity.CENTER_VERTICAL";
parent.mostCurrent._z.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 238;BA.debugLine="z.Gravity = Gravity.CENTER_HORIZONTAL";
parent.mostCurrent._z.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 241;BA.debugLine="h.Text = \"Οδηγίες\"";
parent.mostCurrent._h.setText(BA.ObjectToCharSequence("Οδηγίες"));
 //BA.debugLineNum = 242;BA.debugLine="h.TextSize = 14";
parent.mostCurrent._h.setTextSize((float) (14));
 //BA.debugLineNum = 243;BA.debugLine="sv2d.Panel.AddView(h, 240%x, 0%y, 40%x, 10%y)";
parent.mostCurrent._sv2d.getPanel().AddView((android.view.View)(parent.mostCurrent._h.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (240),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 244;BA.debugLine="h.SetBackgroundImage(LoadBitmap(File.DirAssets, \"";
parent.mostCurrent._h.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alla.png").getObject()));
 //BA.debugLineNum = 245;BA.debugLine="h.TextColor = Colors.White";
parent.mostCurrent._h.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 246;BA.debugLine="h.Gravity = Gravity.CENTER_VERTICAL";
parent.mostCurrent._h.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 247;BA.debugLine="h.Gravity = Gravity.CENTER_HORIZONTAL";
parent.mostCurrent._h.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 248;BA.debugLine="a.Enabled = False";
parent.mostCurrent._a.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 249;BA.debugLine="b.Enabled = False";
parent.mostCurrent._b.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 250;BA.debugLine="z.Enabled = False";
parent.mostCurrent._z.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 251;BA.debugLine="egsaLon.Visible = False";
parent.mostCurrent._egsalon.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 252;BA.debugLine="egsaLat.Visible = False";
parent.mostCurrent._egsalat.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 253;BA.debugLine="ipsosl.Visible = False";
parent.mostCurrent._ipsosl.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 254;BA.debugLine="ipsos.Visible = False";
parent.mostCurrent._ipsos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 255;BA.debugLine="lat.Visible = False";
parent.mostCurrent._lat.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 256;BA.debugLine="lot.Visible = False";
parent.mostCurrent._lot.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 257;BA.debugLine="lotl.Visible = False";
parent.mostCurrent._lotl.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 258;BA.debugLine="latl.Visible = False";
parent.mostCurrent._latl.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 259;BA.debugLine="simaok.Visible = False";
parent.mostCurrent._simaok.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _activity_permissionresult(String _permission,boolean _result) throws Exception{
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 658;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 659;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 661;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 663;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 267;BA.debugLine="GPS1.Stop";
_gps1.Stop();
 //BA.debugLineNum = 268;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return "";
}
public static String  _b_click() throws Exception{
 //BA.debugLineNum = 614;BA.debugLine="Sub b_click";
 //BA.debugLineNum = 615;BA.debugLine="mnasend_Click";
_mnasend_click();
 //BA.debugLineNum = 616;BA.debugLine="End Sub";
return "";
}
public static String  _d_click() throws Exception{
 //BA.debugLineNum = 620;BA.debugLine="Sub d_click";
 //BA.debugLineNum = 621;BA.debugLine="mnhistory_Click";
_mnhistory_click();
 //BA.debugLineNum = 622;BA.debugLine="End Sub";
return "";
}
public static String  _e_click() throws Exception{
 //BA.debugLineNum = 623;BA.debugLine="Sub e_click";
 //BA.debugLineNum = 624;BA.debugLine="mndel_Click";
_mndel_click();
 //BA.debugLineNum = 625;BA.debugLine="End Sub";
return "";
}
public static String  _g_click() throws Exception{
 //BA.debugLineNum = 617;BA.debugLine="Sub g_click";
 //BA.debugLineNum = 618;BA.debugLine="mnlast_Click";
_mnlast_click();
 //BA.debugLineNum = 619;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private mple As Label";
mostCurrent._mple = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private simanseislabel As Label";
mostCurrent._simanseislabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private simanseislabel2 As Label";
mostCurrent._simanseislabel2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private listabel As Label";
mostCurrent._listabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private katigorlabel As Label";
mostCurrent._katigorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private ousialabel As Label";
mostCurrent._ousialabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private ililabel As Label";
mostCurrent._ililabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim sv2d As ScrollView2D";
mostCurrent._sv2d = new flm.b4a.scrollview2d.ScrollView2DWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim Id As InputDialog";
mostCurrent._id = new anywheresoftware.b4a.agraham.dialogs.InputDialog();
 //BA.debugLineNum = 31;BA.debugLine="Dim k As Int";
_k = 0;
 //BA.debugLineNum = 33;BA.debugLine="Dim res As List";
mostCurrent._res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 34;BA.debugLine="Dim egsaLat As Label";
mostCurrent._egsalat = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Dim egsaLon As Label";
mostCurrent._egsalon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Dim bmp As Bitmap";
mostCurrent._bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Dim pw As PhoneWakeState";
mostCurrent._pw = new anywheresoftware.b4a.phone.Phone.PhoneWakeState();
 //BA.debugLineNum = 40;BA.debugLine="Dim lblLon1 As Label";
mostCurrent._lbllon1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Dim lblLat1 As Label";
mostCurrent._lbllat1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Dim lblSatellites As Label";
mostCurrent._lblsatellites = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Dim txt As Label";
mostCurrent._txt = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim txtall As Label";
mostCurrent._txtall = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Dim now As Long";
_now = 0L;
 //BA.debugLineNum = 48;BA.debugLine="Dim t As String";
mostCurrent._t = "";
 //BA.debugLineNum = 49;BA.debugLine="Dim s As String";
mostCurrent._s = "";
 //BA.debugLineNum = 51;BA.debugLine="Dim txtgooglon As Label";
mostCurrent._txtgooglon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Dim txtgooglan As Label";
mostCurrent._txtgooglan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Dim googlan As Label";
mostCurrent._googlan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Dim googlon As Label";
mostCurrent._googlon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Dim ps As PhoneSensors";
mostCurrent._ps = new anywheresoftware.b4a.phone.Phone.PhoneSensors();
 //BA.debugLineNum = 69;BA.debugLine="Dim panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Dim sc As ScrollView";
mostCurrent._sc = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private lat As Label";
mostCurrent._lat = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private lot As Label";
mostCurrent._lot = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private lotl As Label";
mostCurrent._lotl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private latl As Label";
mostCurrent._latl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 81;BA.debugLine="Private ipsos As Label";
mostCurrent._ipsos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Dim txt0 As Label";
mostCurrent._txt0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 89;BA.debugLine="Private sima1 As Label";
mostCurrent._sima1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 90;BA.debugLine="Private sima2 As Label";
mostCurrent._sima2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 91;BA.debugLine="Private simaok As Label";
mostCurrent._simaok = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 92;BA.debugLine="Private sima As Label";
mostCurrent._sima = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 94;BA.debugLine="Private panelola As Panel";
mostCurrent._panelola = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 96;BA.debugLine="Private ipsosl As Label";
mostCurrent._ipsosl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 97;BA.debugLine="Private Panelab As Panel";
mostCurrent._panelab = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 101;BA.debugLine="Dim a As Button";
mostCurrent._a = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 102;BA.debugLine="Dim a1 As Button";
mostCurrent._a1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 103;BA.debugLine="Dim b As Button";
mostCurrent._b = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 104;BA.debugLine="Dim g As Button";
mostCurrent._g = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 105;BA.debugLine="Dim d As Button";
mostCurrent._d = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 106;BA.debugLine="Dim e As Button";
mostCurrent._e = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 107;BA.debugLine="Dim z As Button";
mostCurrent._z = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 108;BA.debugLine="Dim h As Button";
mostCurrent._h = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public static String  _gps_locationchanged(anywheresoftware.b4a.gps.LocationWrapper _location1) throws Exception{
 //BA.debugLineNum = 270;BA.debugLine="Sub GPS_LocationChanged (Location1 As Location)";
 //BA.debugLineNum = 273;BA.debugLine="If simanseislabel.Visible = True Then";
if (mostCurrent._simanseislabel.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 274;BA.debugLine="ipsosl.Visible = True";
mostCurrent._ipsosl.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 275;BA.debugLine="ipsos.Visible = True";
mostCurrent._ipsos.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 276;BA.debugLine="lat.Visible = True";
mostCurrent._lat.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 277;BA.debugLine="lot.Visible = True";
mostCurrent._lot.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 278;BA.debugLine="lotl.Visible = True";
mostCurrent._lotl.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 279;BA.debugLine="latl.Visible = True";
mostCurrent._latl.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 280;BA.debugLine="simaok.Visible = True";
mostCurrent._simaok.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 283;BA.debugLine="If simanseislabel.Visible = False Then";
if (mostCurrent._simanseislabel.getVisible()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 284;BA.debugLine="ipsosl.Visible = True";
mostCurrent._ipsosl.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 285;BA.debugLine="ipsos.Visible = True";
mostCurrent._ipsos.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 286;BA.debugLine="lat.Visible = True";
mostCurrent._lat.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 287;BA.debugLine="lot.Visible = True";
mostCurrent._lot.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 288;BA.debugLine="egsaLat.Visible = True";
mostCurrent._egsalat.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 289;BA.debugLine="egsaLon.Visible = True";
mostCurrent._egsalon.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 290;BA.debugLine="simaok.Visible = True";
mostCurrent._simaok.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 294;BA.debugLine="DateTime.DateFormat = \"dd/MM/yy HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yy HH:mm");
 //BA.debugLineNum = 295;BA.debugLine="now = DateTime.now";
_now = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 296;BA.debugLine="t = DateTime.Time(now)";
mostCurrent._t = anywheresoftware.b4a.keywords.Common.DateTime.Time(_now);
 //BA.debugLineNum = 297;BA.debugLine="s = DateTime.Date(now)";
mostCurrent._s = anywheresoftware.b4a.keywords.Common.DateTime.Date(_now);
 //BA.debugLineNum = 298;BA.debugLine="lotl.Text =  Location1.ConvertToSeconds(Locati";
mostCurrent._lotl.setText(BA.ObjectToCharSequence(_location1.ConvertToSeconds(_location1.getLatitude())+"N"));
 //BA.debugLineNum = 299;BA.debugLine="latl.Text = Location1.ConvertToSeconds(Locatio";
mostCurrent._latl.setText(BA.ObjectToCharSequence(_location1.ConvertToSeconds(_location1.getLongitude())+"E"));
 //BA.debugLineNum = 300;BA.debugLine="ipsosl.Text = Location1.Altitude";
mostCurrent._ipsosl.setText(BA.ObjectToCharSequence(_location1.getAltitude()));
 //BA.debugLineNum = 302;BA.debugLine="lblLat1.Text = Location1.ConvertToseconds(Locatio";
mostCurrent._lbllat1.setText(BA.ObjectToCharSequence(_location1.ConvertToSeconds(_location1.getLatitude())));
 //BA.debugLineNum = 303;BA.debugLine="lblLon1.Text = Location1.ConvertToseconds(Loca";
mostCurrent._lbllon1.setText(BA.ObjectToCharSequence(_location1.ConvertToSeconds(_location1.getLongitude())));
 //BA.debugLineNum = 305;BA.debugLine="googlan.Text = Location1.ConvertToseconds(Locatio";
mostCurrent._googlan.setText(BA.ObjectToCharSequence(_location1.ConvertToSeconds(_location1.getLatitude())));
 //BA.debugLineNum = 306;BA.debugLine="googlon.Text = Location1.ConvertToseconds(Loca";
mostCurrent._googlon.setText(BA.ObjectToCharSequence(_location1.ConvertToSeconds(_location1.getLongitude())));
 //BA.debugLineNum = 307;BA.debugLine="File.WriteString(File.DirInternal, \"txtgooglon.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglon.txt",mostCurrent._googlon.getText());
 //BA.debugLineNum = 308;BA.debugLine="File.WriteString(File.DirInternal, \"txtgooglan.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglan.txt",mostCurrent._googlan.getText());
 //BA.debugLineNum = 309;BA.debugLine="Log(Location1)";
anywheresoftware.b4a.keywords.Common.LogImpl("77274535",BA.ObjectToString(_location1),0);
 //BA.debugLineNum = 318;BA.debugLine="txt.text = Id.Input  & CRLF & latl.Text & CRLF &";
mostCurrent._txt.setText(BA.ObjectToCharSequence(mostCurrent._id.getInput()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._latl.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._lotl.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._s+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 319;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfire.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt",mostCurrent._txt.getText());
 //BA.debugLineNum = 322;BA.debugLine="res = Egsa87.FLWGS84_TO_XYEGSA87(Location1.Latitud";
mostCurrent._res = mostCurrent._egsa87._flwgs84_to_xyegsa87(mostCurrent.activityBA,_location1.getLatitude(),_location1.getLongitude());
 //BA.debugLineNum = 324;BA.debugLine="egsaLon.text =\"X: \" & Round2(res.Get(0),3)";
mostCurrent._egsalon.setText(BA.ObjectToCharSequence("X: "+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (0)))),(int) (3)))));
 //BA.debugLineNum = 325;BA.debugLine="egsaLat.text =\"Y: \" & Round2(res.Get(1),3)";
mostCurrent._egsalat.setText(BA.ObjectToCharSequence("Y: "+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Round2((double)(BA.ObjectToNumber(mostCurrent._res.Get((int) (1)))),(int) (3)))));
 //BA.debugLineNum = 327;BA.debugLine="Log(Location1)";
anywheresoftware.b4a.keywords.Common.LogImpl("77274553",BA.ObjectToString(_location1),0);
 //BA.debugLineNum = 328;BA.debugLine="Log(Location1.Latitude)";
anywheresoftware.b4a.keywords.Common.LogImpl("77274554",BA.NumberToString(_location1.getLatitude()),0);
 //BA.debugLineNum = 329;BA.debugLine="Log(Location1.Longitude)";
anywheresoftware.b4a.keywords.Common.LogImpl("77274555",BA.NumberToString(_location1.getLongitude()),0);
 //BA.debugLineNum = 334;BA.debugLine="timer1.Enabled = False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 335;BA.debugLine="simaok.visible = True";
mostCurrent._simaok.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 337;BA.debugLine="sima.Visible = False";
mostCurrent._sima.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 338;BA.debugLine="sima1.Visible = False";
mostCurrent._sima1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 339;BA.debugLine="sima2.Visible = False";
mostCurrent._sima2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 340;BA.debugLine="a.Enabled = True";
mostCurrent._a.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 341;BA.debugLine="b.Enabled = True";
mostCurrent._b.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 342;BA.debugLine="z.Enabled = True";
mostCurrent._z.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 343;BA.debugLine="End Sub";
return "";
}
public static String  _gps_userenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 345;BA.debugLine="Sub GPS_UserEnabled (Enabled As Boolean)";
 //BA.debugLineNum = 347;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 349;BA.debugLine="Sub GPS1_GpsStatus (Satellites As List)";
 //BA.debugLineNum = 350;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 352;BA.debugLine="Dim txt1, txt2, txt3, txt4, txt5 As String";
_txt1 = "";
_txt2 = "";
_txt3 = "";
_txt4 = "";
_txt5 = "";
 //BA.debugLineNum = 354;BA.debugLine="txt1 = \"Index\"";
_txt1 = "Index";
 //BA.debugLineNum = 355;BA.debugLine="txt2 = \"Azimuth\"";
_txt2 = "Azimuth";
 //BA.debugLineNum = 356;BA.debugLine="txt3 = \"Elevation\"";
_txt3 = "Elevation";
 //BA.debugLineNum = 357;BA.debugLine="txt4 = \"Used\"";
_txt4 = "Used";
 //BA.debugLineNum = 358;BA.debugLine="txt5 = \"S / N ratio\"";
_txt5 = "S / N ratio";
 //BA.debugLineNum = 360;BA.debugLine="Activity.Title = \"Sats \" & Satellites.Size";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Sats "+BA.NumberToString(_satellites.getSize())));
 //BA.debugLineNum = 361;BA.debugLine="For i = 0 To Satellites.Size -1";
{
final int step9 = 1;
final int limit9 = (int) (_satellites.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 362;BA.debugLine="Dim GPSSat As GPSSatellite";
_gpssat = new anywheresoftware.b4a.gps.GpsSatelliteWrapper();
 //BA.debugLineNum = 363;BA.debugLine="GPSSat = Satellites.Get(i)";
_gpssat.setObject((android.location.GpsSatellite)(_satellites.Get(_i)));
 //BA.debugLineNum = 364;BA.debugLine="txt1 = txt1 & CRLF & (i + 1)";
_txt1 = _txt1+anywheresoftware.b4a.keywords.Common.CRLF+BA.NumberToString((_i+1));
 //BA.debugLineNum = 365;BA.debugLine="txt2 = txt2 & CRLF & GPSSat.Azimuth";
_txt2 = _txt2+anywheresoftware.b4a.keywords.Common.CRLF+BA.NumberToString(_gpssat.getAzimuth());
 //BA.debugLineNum = 366;BA.debugLine="txt3 = txt3 & CRLF & GPSSat.Elevation";
_txt3 = _txt3+anywheresoftware.b4a.keywords.Common.CRLF+BA.NumberToString(_gpssat.getElevation());
 //BA.debugLineNum = 367;BA.debugLine="txt4 = txt4 & CRLF & GPSSat.UsedInFix";
_txt4 = _txt4+anywheresoftware.b4a.keywords.Common.CRLF+BA.ObjectToString(_gpssat.getUsedInFix());
 //BA.debugLineNum = 368;BA.debugLine="txt5 = txt5 & CRLF & Round2(GPSSat.Snr, 2)";
_txt5 = _txt5+anywheresoftware.b4a.keywords.Common.CRLF+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Round2(_gpssat.getSnr(),(int) (2)));
 //BA.debugLineNum = 369;BA.debugLine="Activity.Title = \"Set \" & i";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Set "+BA.NumberToString(_i)));
 }
};
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return "";
}
public static String  _h_click() throws Exception{
 //BA.debugLineNum = 629;BA.debugLine="Sub h_click";
 //BA.debugLineNum = 630;BA.debugLine="mninfo_Click";
_mninfo_click();
 //BA.debugLineNum = 631;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
 //BA.debugLineNum = 412;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 413;BA.debugLine="StartActivity(\"firstaid\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("firstaid"));
 //BA.debugLineNum = 414;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 406;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 407;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 408;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 403;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 404;BA.debugLine="StartActivity(\"thlefona\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("thlefona"));
 //BA.debugLineNum = 405;BA.debugLine="End Sub";
return "";
}
public static String  _mazi() throws Exception{
String _ret = "";
 //BA.debugLineNum = 461;BA.debugLine="Sub mazi";
 //BA.debugLineNum = 462;BA.debugLine="Id.InputType = Id.INPUT_TYPE_TEXT";
mostCurrent._id.setInputType(mostCurrent._id.INPUT_TYPE_TEXT);
 //BA.debugLineNum = 463;BA.debugLine="Id.Input = \"\"";
mostCurrent._id.setInput("");
 //BA.debugLineNum = 464;BA.debugLine="Id.Hint = \"Πληκτρολογίστε εδώ τίτλο\"";
mostCurrent._id.setHint("Πληκτρολογίστε εδώ τίτλο");
 //BA.debugLineNum = 465;BA.debugLine="Id.HintColor = Colors.ARGB(196, 255, 140, 0)";
mostCurrent._id.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (196),(int) (255),(int) (140),(int) (0)));
 //BA.debugLineNum = 466;BA.debugLine="ret = DialogResponse.CANCEL";
_ret = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DialogResponse.CANCEL);
 //BA.debugLineNum = 467;BA.debugLine="ret = Id.Show(\"\", \"\", \"OK\", \"\", \"\", bmp)";
_ret = BA.NumberToString(mostCurrent._id.Show("","","OK","","",mostCurrent.activityBA,(android.graphics.Bitmap)(mostCurrent._bmp.getObject())));
 //BA.debugLineNum = 468;BA.debugLine="Msgbox(Id.Input,\"\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(mostCurrent._id.getInput()),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 469;BA.debugLine="mazimeta";
_mazimeta();
 //BA.debugLineNum = 471;BA.debugLine="End Sub";
return "";
}
public static String  _mazimeta() throws Exception{
 //BA.debugLineNum = 473;BA.debugLine="Sub mazimeta";
 //BA.debugLineNum = 475;BA.debugLine="txt.text = Id.Input & CRLF & \"WGS84\"  & CRLF & la";
mostCurrent._txt.setText(BA.ObjectToCharSequence(mostCurrent._id.getInput()+anywheresoftware.b4a.keywords.Common.CRLF+"WGS84"+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._latl.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._lotl.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._s+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"ΕΓΣΑ87"+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._egsalon.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._egsalat.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._s));
 //BA.debugLineNum = 476;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfire.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt",mostCurrent._txt.getText());
 //BA.debugLineNum = 477;BA.debugLine="txtall.text = txtall.Text & CRLF & txt.text & CR";
mostCurrent._txtall.setText(BA.ObjectToCharSequence(mostCurrent._txtall.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._txt.getText()+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 478;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfireall.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfireall.txt",mostCurrent._txtall.getText());
 //BA.debugLineNum = 479;BA.debugLine="File.WriteString(File.DirInternal, \"txtgooglon.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglon.txt",mostCurrent._googlon.getText());
 //BA.debugLineNum = 480;BA.debugLine="File.WriteString(File.DirInternal, \"txtgooglan.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglan.txt",mostCurrent._googlan.getText());
 //BA.debugLineNum = 481;BA.debugLine="GPS1.Stop";
_gps1.Stop();
 //BA.debugLineNum = 482;BA.debugLine="Msgbox(\"Η τοποθεσία αποθηκεύτηκε\",\"\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Η τοποθεσία αποθηκεύτηκε"),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 484;BA.debugLine="End Sub";
return "";
}
public static String  _meny_click() throws Exception{
 //BA.debugLineNum = 505;BA.debugLine="Sub meny_Click";
 //BA.debugLineNum = 506;BA.debugLine="Activity.OpenMenu";
mostCurrent._activity.OpenMenu();
 //BA.debugLineNum = 507;BA.debugLine="End Sub";
return "";
}
public static String  _meta() throws Exception{
 //BA.debugLineNum = 485;BA.debugLine="Sub meta";
 //BA.debugLineNum = 486;BA.debugLine="txt.text = Id.Input  & CRLF & latl.Text & CRLF &";
mostCurrent._txt.setText(BA.ObjectToCharSequence(mostCurrent._id.getInput()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._latl.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._lotl.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._s+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 487;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfire.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt",mostCurrent._txt.getText());
 //BA.debugLineNum = 488;BA.debugLine="txtall.text = txtall.Text & CRLF & txt.text & CR";
mostCurrent._txtall.setText(BA.ObjectToCharSequence(mostCurrent._txtall.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._txt.getText()+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 489;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfireall.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfireall.txt",mostCurrent._txtall.getText());
 //BA.debugLineNum = 490;BA.debugLine="File.WriteString(File.DirInternal, \"txtgooglon.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglon.txt",mostCurrent._googlon.getText());
 //BA.debugLineNum = 491;BA.debugLine="File.WriteString(File.DirInternal, \"txtgooglan.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"txtgooglan.txt",mostCurrent._googlan.getText());
 //BA.debugLineNum = 492;BA.debugLine="GPS1.Stop";
_gps1.Stop();
 //BA.debugLineNum = 493;BA.debugLine="Msgbox(\"Η τοποθεσία αποθηκεύτηκε\",\"\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Η τοποθεσία αποθηκεύτηκε"),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 494;BA.debugLine="End Sub";
return "";
}
public static String  _metaegsa() throws Exception{
 //BA.debugLineNum = 496;BA.debugLine="Sub metaegsa";
 //BA.debugLineNum = 497;BA.debugLine="txt.text = Id.Input  & CRLF  & egsaLon.text & CRL";
mostCurrent._txt.setText(BA.ObjectToCharSequence(mostCurrent._id.getInput()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._egsalon.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._egsalat.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._s+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 498;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfire.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt",mostCurrent._txt.getText());
 //BA.debugLineNum = 500;BA.debugLine="txtall.text = txtall.Text & CRLF & txt.text & CR";
mostCurrent._txtall.setText(BA.ObjectToCharSequence(mostCurrent._txtall.getText()+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._txt.getText()+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 501;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfireall.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfireall.txt",mostCurrent._txtall.getText());
 //BA.debugLineNum = 502;BA.debugLine="GPS1.Stop";
_gps1.Stop();
 //BA.debugLineNum = 503;BA.debugLine="Msgbox(\"Η τοποθεσία αποθηκεύτηκε\",\"\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Η τοποθεσία αποθηκεύτηκε"),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 504;BA.debugLine="End Sub";
return "";
}
public static String  _mnagain_click() throws Exception{
 //BA.debugLineNum = 509;BA.debugLine="Sub mnagain_Click";
 //BA.debugLineNum = 511;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 512;BA.debugLine="StartActivity(Me)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,gpssignal.getObject());
 //BA.debugLineNum = 514;BA.debugLine="End Sub";
return "";
}
public static String  _mnasend_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _share = null;
 //BA.debugLineNum = 571;BA.debugLine="Sub mnasend_Click";
 //BA.debugLineNum = 573;BA.debugLine="Dim share As Intent";
_share = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 575;BA.debugLine="share.Initialize(share.ACTION_SEND,\"\")";
_share.Initialize(_share.ACTION_SEND,"");
 //BA.debugLineNum = 576;BA.debugLine="share.SetType(\"text/plain\")";
_share.SetType("text/plain");
 //BA.debugLineNum = 577;BA.debugLine="share.PutExtra(\"android.intent.extra.TEXT\", File.";
_share.PutExtra("android.intent.extra.TEXT",(Object)(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt")));
 //BA.debugLineNum = 578;BA.debugLine="share.WrapAsIntentChooser(\"Share text via\")";
_share.WrapAsIntentChooser("Share text via");
 //BA.debugLineNum = 579;BA.debugLine="StartActivity(share)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_share.getObject()));
 //BA.debugLineNum = 581;BA.debugLine="End Sub";
return "";
}
public static String  _mndel_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 543;BA.debugLine="Sub mndel_Click";
 //BA.debugLineNum = 544;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 545;BA.debugLine="result = Msgbox2(\"Διαγραφή ιστορικού\", \"\", \"Ναί\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Διαγραφή ιστορικού"),BA.ObjectToCharSequence(""),"Ναί"," ","Όχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Delete.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 546;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 547;BA.debugLine="Msgbox(\"Ιστορικο διαγράφηκε\",\"\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Ιστορικο διαγράφηκε"),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 548;BA.debugLine="txt0.Text = txt.Text";
mostCurrent._txt0.setText(BA.ObjectToCharSequence(mostCurrent._txt.getText()));
 //BA.debugLineNum = 549;BA.debugLine="File.WriteString(File.DirInternal, \"gpsfireall.t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfireall.txt",mostCurrent._txt0.getText());
 };
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
public static String  _mnhistory_click() throws Exception{
 //BA.debugLineNum = 530;BA.debugLine="Sub mnhistory_Click";
 //BA.debugLineNum = 532;BA.debugLine="Msgbox(File.ReadString(File.DirInternal, \"gpsfire";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfireall.txt")),BA.ObjectToCharSequence(" "),mostCurrent.activityBA);
 //BA.debugLineNum = 534;BA.debugLine="End Sub";
return "";
}
public static String  _mninfo_click() throws Exception{
 //BA.debugLineNum = 535;BA.debugLine="Sub mninfo_Click";
 //BA.debugLineNum = 536;BA.debugLine="Msgbox(\"Η εφαρμογή αποθηκεύει την τελευταία τοποθε";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Η εφαρμογή αποθηκεύει την τελευταία τοποθεσία gps και δημιουργεί ιστορικό"),BA.ObjectToCharSequence("Συντεταγμένες DMS"),mostCurrent.activityBA);
 //BA.debugLineNum = 537;BA.debugLine="Msgbox(\"Την πρώτη φορά ενδέχεται να καθυστερήσει η";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Την πρώτη φορά ενδέχεται να καθυστερήσει η εύρεση δορυφόρων ανάλογα με τον δέκτη κάθε κινητού τηλεφώνου.Βεβαιωθείτε οτι έχετε ενεργοποιημένες στις ρυθμίσεις των δορυφόρων gps "),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 538;BA.debugLine="Msgbox(\"Ο αριθμός που εμφανίζεται είναι κατα σειρά";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Ο αριθμός που εμφανίζεται είναι κατα σειρά Μοίρες(Degrees):Λεπτά(Minutes):Δευτερόλεπτα(Seconds) (xx:xx:xx.xxx)"),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 539;BA.debugLine="Msgbox(\"Στην ιστοσελίδα google maps και στην αναζή";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Στην ιστοσελίδα google maps και στην αναζήτηση τοποθεσίας,αντικαθιστούμε την άνω κάτω τελεία(:) σε κενό και το κόμμα σε τελεία.Bάζουμε πρώτα το γεωγραφικό πλάτος,έπειτα με κενό βάζουμε το γεωγραφικό μήκος και πατάμε αναζήτηση"),BA.ObjectToCharSequence("Μεταφορά στο Google maps"),mostCurrent.activityBA);
 //BA.debugLineNum = 540;BA.debugLine="Msgbox(\"πχ 41:08:29,0N και 24:53:19,5E  αλλαγή σε";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("πχ 41:08:29,0N και 24:53:19,5E  αλλαγή σε 41 08 29.0N 24 53 19.5E "),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 541;BA.debugLine="End Sub";
return "";
}
public static String  _mnlast_click() throws Exception{
int _result = 0;
anywheresoftware.b4a.objects.IntentWrapper _share = null;
 //BA.debugLineNum = 516;BA.debugLine="Sub mnlast_Click";
 //BA.debugLineNum = 517;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 518;BA.debugLine="result = Msgbox2(\"Ιστορικό\", \"\", \"Αποστολή\", \" \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Ιστορικό"),BA.ObjectToCharSequence(""),"Αποστολή"," ","Προβολή",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Delete.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 519;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 520;BA.debugLine="Dim share As Intent";
_share = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 521;BA.debugLine="share.Initialize(share.ACTION_SEND,\"\")";
_share.Initialize(_share.ACTION_SEND,"");
 //BA.debugLineNum = 522;BA.debugLine="share.SetType(\"text/plain\")";
_share.SetType("text/plain");
 //BA.debugLineNum = 523;BA.debugLine="share.PutExtra(\"android.intent.extra.TEXT\", File";
_share.PutExtra("android.intent.extra.TEXT",(Object)(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt")));
 //BA.debugLineNum = 524;BA.debugLine="share.WrapAsIntentChooser(\"Share text via\")";
_share.WrapAsIntentChooser("Share text via");
 //BA.debugLineNum = 525;BA.debugLine="StartActivity(share)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_share.getObject()));
 }else {
 //BA.debugLineNum = 527;BA.debugLine="Msgbox(File.ReadString(File.DirInternal, \"gpsfir";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"gpsfire.txt")),BA.ObjectToCharSequence(" "),mostCurrent.activityBA);
 };
 //BA.debugLineNum = 529;BA.debugLine="End Sub";
return "";
}
public static String  _mnmap_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _intent1 = null;
String _uri = "";
 //BA.debugLineNum = 553;BA.debugLine="Sub mnmap_Click";
 //BA.debugLineNum = 554;BA.debugLine="lblLat1.text = lblLat1.text.Replace (\":\",\" \")";
mostCurrent._lbllat1.setText(BA.ObjectToCharSequence(mostCurrent._lbllat1.getText().replace(":"," ")));
 //BA.debugLineNum = 555;BA.debugLine="lblLat1.text = lblLat1.text.Replace (\",\",\".\")";
mostCurrent._lbllat1.setText(BA.ObjectToCharSequence(mostCurrent._lbllat1.getText().replace(",",".")));
 //BA.debugLineNum = 557;BA.debugLine="lblLon1.text = lblLon1.text.Replace (\":\",\" \")";
mostCurrent._lbllon1.setText(BA.ObjectToCharSequence(mostCurrent._lbllon1.getText().replace(":"," ")));
 //BA.debugLineNum = 558;BA.debugLine="lblLon1.text = lblLon1.text.Replace (\",\",\".\")";
mostCurrent._lbllon1.setText(BA.ObjectToCharSequence(mostCurrent._lbllon1.getText().replace(",",".")));
 //BA.debugLineNum = 560;BA.debugLine="Dim intent1 As Intent";
_intent1 = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 561;BA.debugLine="URI = \"geo:\" & lblLat1.Text & \",\" & lblLon1.text";
_uri = "geo:"+mostCurrent._lbllat1.getText()+","+mostCurrent._lbllon1.getText()+"?q="+mostCurrent._lbllat1.getText()+","+mostCurrent._lbllon1.getText();
 //BA.debugLineNum = 562;BA.debugLine="intent1.Initialize(intent1.ACTION_VIEW, URI)";
_intent1.Initialize(_intent1.ACTION_VIEW,_uri);
 //BA.debugLineNum = 563;BA.debugLine="intent1.SetComponent(\"googlemaps\")";
_intent1.SetComponent("googlemaps");
 //BA.debugLineNum = 564;BA.debugLine="StartActivity(intent1)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_intent1.getObject()));
 //BA.debugLineNum = 568;BA.debugLine="End Sub";
return "";
}
public static String  _mono() throws Exception{
String _ret = "";
 //BA.debugLineNum = 434;BA.debugLine="Sub mono";
 //BA.debugLineNum = 437;BA.debugLine="Id.InputType = Id.INPUT_TYPE_TEXT";
mostCurrent._id.setInputType(mostCurrent._id.INPUT_TYPE_TEXT);
 //BA.debugLineNum = 438;BA.debugLine="Id.Input = \"\"";
mostCurrent._id.setInput("");
 //BA.debugLineNum = 439;BA.debugLine="Id.Hint = \"Πληκτρολογίστε εδώ τίτλο\"";
mostCurrent._id.setHint("Πληκτρολογίστε εδώ τίτλο");
 //BA.debugLineNum = 440;BA.debugLine="Id.HintColor = Colors.ARGB(196, 255, 140, 0)";
mostCurrent._id.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (196),(int) (255),(int) (140),(int) (0)));
 //BA.debugLineNum = 441;BA.debugLine="ret = DialogResponse.CANCEL";
_ret = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DialogResponse.CANCEL);
 //BA.debugLineNum = 442;BA.debugLine="ret = Id.Show(\"\", \"\", \"OK\", \"\", \"\", bmp)";
_ret = BA.NumberToString(mostCurrent._id.Show("","","OK","","",mostCurrent.activityBA,(android.graphics.Bitmap)(mostCurrent._bmp.getObject())));
 //BA.debugLineNum = 443;BA.debugLine="Msgbox(Id.Input,\"\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(mostCurrent._id.getInput()),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 444;BA.debugLine="meta";
_meta();
 //BA.debugLineNum = 446;BA.debugLine="End Sub";
return "";
}
public static String  _monoegsa() throws Exception{
String _ret = "";
 //BA.debugLineNum = 447;BA.debugLine="Sub monoegsa";
 //BA.debugLineNum = 450;BA.debugLine="Id.InputType = Id.INPUT_TYPE_TEXT";
mostCurrent._id.setInputType(mostCurrent._id.INPUT_TYPE_TEXT);
 //BA.debugLineNum = 451;BA.debugLine="Id.Input = \"\"";
mostCurrent._id.setInput("");
 //BA.debugLineNum = 452;BA.debugLine="Id.Hint = \"Πληκτρολογίστε εδώ τίτλο\"";
mostCurrent._id.setHint("Πληκτρολογίστε εδώ τίτλο");
 //BA.debugLineNum = 453;BA.debugLine="Id.HintColor = Colors.ARGB(196, 255, 140, 0)";
mostCurrent._id.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (196),(int) (255),(int) (140),(int) (0)));
 //BA.debugLineNum = 454;BA.debugLine="ret = DialogResponse.CANCEL";
_ret = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DialogResponse.CANCEL);
 //BA.debugLineNum = 455;BA.debugLine="ret = Id.Show(\"\", \"\", \"OK\", \"\", \"\", bmp)";
_ret = BA.NumberToString(mostCurrent._id.Show("","","OK","","",mostCurrent.activityBA,(android.graphics.Bitmap)(mostCurrent._bmp.getObject())));
 //BA.debugLineNum = 456;BA.debugLine="Msgbox(Id.Input,\"\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(mostCurrent._id.getInput()),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 457;BA.debugLine="metaegsa";
_metaegsa();
 //BA.debugLineNum = 459;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 409;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 410;BA.debugLine="StartActivity(\"gpssignal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssignal"));
 //BA.debugLineNum = 411;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Public rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 9;BA.debugLine="Dim GPS1 As GPS";
_gps1 = new anywheresoftware.b4a.gps.GPS();
 //BA.debugLineNum = 10;BA.debugLine="Dim timer1 As Timer";
_timer1 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _save_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _r = null;
com.maximus.id.id _x = null;
String _m = "";
 //BA.debugLineNum = 415;BA.debugLine="Sub save_click";
 //BA.debugLineNum = 417;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 418;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 419;BA.debugLine="r.AddAll(Array As String(\"Αποθηκεύση στην επιλε";
_r.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Αποθηκεύση στην επιλεγμένη μορφή","Αποθηκεύση σε ΕΓΣΑ87 και WGS84"}));
 //BA.debugLineNum = 422;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
 //BA.debugLineNum = 423;BA.debugLine="m = x.InputList1(r,\"Επιλογή μορφής για αποθηκεύ";
_m = BA.NumberToString(_x.InputList1(_r,"Επιλογή μορφής για αποθηκεύση",mostCurrent.activityBA));
 //BA.debugLineNum = 425;BA.debugLine="If m = 0 Then";
if ((_m).equals(BA.NumberToString(0))) { 
 //BA.debugLineNum = 426;BA.debugLine="mono";
_mono();
 };
 //BA.debugLineNum = 428;BA.debugLine="If m = 1 Then";
if ((_m).equals(BA.NumberToString(1))) { 
 //BA.debugLineNum = 429;BA.debugLine="mazi";
_mazi();
 };
 //BA.debugLineNum = 431;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 379;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 380;BA.debugLine="latl.Visible = False";
mostCurrent._latl.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 381;BA.debugLine="lotl.Visible = False";
mostCurrent._lotl.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 383;BA.debugLine="egsaLon.Visible = True";
mostCurrent._egsalon.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 384;BA.debugLine="egsaLat.Visible = True";
mostCurrent._egsalat.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 385;BA.debugLine="a.Visible = False";
mostCurrent._a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 386;BA.debugLine="a1.Visible = True";
mostCurrent._a1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 389;BA.debugLine="simanseislabel.Visible = False";
mostCurrent._simanseislabel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 390;BA.debugLine="simanseislabel2.Visible = True";
mostCurrent._simanseislabel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 391;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel2_click() throws Exception{
 //BA.debugLineNum = 392;BA.debugLine="Sub simanseislabel2_Click";
 //BA.debugLineNum = 393;BA.debugLine="latl.Visible = True";
mostCurrent._latl.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 394;BA.debugLine="lotl.Visible = True";
mostCurrent._lotl.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 395;BA.debugLine="egsaLon.Visible = False";
mostCurrent._egsalon.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 396;BA.debugLine="egsaLat.Visible = False";
mostCurrent._egsalat.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 397;BA.debugLine="a.Visible = True";
mostCurrent._a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 398;BA.debugLine="a1.Visible = False";
mostCurrent._a1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 400;BA.debugLine="simanseislabel2.Visible = False";
mostCurrent._simanseislabel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 401;BA.debugLine="simanseislabel.Visible = True";
mostCurrent._simanseislabel.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 402;BA.debugLine="End Sub";
return "";
}
public static String  _simaok_click() throws Exception{
 //BA.debugLineNum = 653;BA.debugLine="Sub simaok_Click";
 //BA.debugLineNum = 654;BA.debugLine="mnagain_Click";
_mnagain_click();
 //BA.debugLineNum = 655;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
 //BA.debugLineNum = 582;BA.debugLine="Sub timer1_Tick";
 //BA.debugLineNum = 584;BA.debugLine="k = k + 1";
_k = (int) (_k+1);
 //BA.debugLineNum = 586;BA.debugLine="If k = 1.0 Then";
if (_k==1.0) { 
 //BA.debugLineNum = 587;BA.debugLine="sima.Visible = True";
mostCurrent._sima.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 588;BA.debugLine="sima1.Visible = False";
mostCurrent._sima1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 589;BA.debugLine="sima2.Visible = False";
mostCurrent._sima2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 592;BA.debugLine="If k = 2.0 Then";
if (_k==2.0) { 
 //BA.debugLineNum = 593;BA.debugLine="sima.Visible = False";
mostCurrent._sima.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 594;BA.debugLine="sima1.Visible = True";
mostCurrent._sima1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 595;BA.debugLine="sima2.Visible = False";
mostCurrent._sima2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 598;BA.debugLine="If k > 2.0 Then";
if (_k>2.0) { 
 //BA.debugLineNum = 599;BA.debugLine="sima.Visible = False";
mostCurrent._sima.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 600;BA.debugLine="sima1.Visible = False";
mostCurrent._sima1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 601;BA.debugLine="sima2.Visible = True";
mostCurrent._sima2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 605;BA.debugLine="If k = 3.0 Then";
if (_k==3.0) { 
 //BA.debugLineNum = 606;BA.debugLine="k = 0";
_k = (int) (0);
 };
 //BA.debugLineNum = 610;BA.debugLine="End Sub";
return "";
}
public static String  _z_click() throws Exception{
 //BA.debugLineNum = 626;BA.debugLine="Sub z_click";
 //BA.debugLineNum = 627;BA.debugLine="mnmap_Click";
_mnmap_click();
 //BA.debugLineNum = 628;BA.debugLine="End Sub";
return "";
}
}
