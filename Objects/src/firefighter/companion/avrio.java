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

public class avrio extends Activity implements B4AActivity{
	public static avrio mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.avrio");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (avrio).");
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
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.avrio");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.avrio", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (avrio) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (avrio) Resume **");
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
		return avrio.class;
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
        BA.LogInfo("** Activity (avrio) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            avrio mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (avrio) Resume **");
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
public anywheresoftware.b4a.objects.ImageViewWrapper _deiktess = null;
public anywheresoftware.b4a.objects.LabelWrapper _label11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label22 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label33 = null;
public static String _getimg = "";
public firefighter.companion.httpjob _job3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _mple = null;
public anywheresoftware.b4a.objects.LabelWrapper _simanseislabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _listabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _katigorlabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ousialabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ililabel = null;
public com.gvoulg.egsa87.egsa87 _egsa87 = null;
public firefighter.companion.main _main = null;
public firefighter.companion.rss _rss = null;
public firefighter.companion.rssdyo _rssdyo = null;
public firefighter.companion.deiktes _deiktes = null;
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
anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper _server = null;
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"avrio\")";
mostCurrent._activity.LoadLayout("avrio",mostCurrent.activityBA);
 //BA.debugLineNum = 52;BA.debugLine="simanseislabel.Top = 3%y";
mostCurrent._simanseislabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 53;BA.debugLine="simanseislabel.left = 3.5%x";
mostCurrent._simanseislabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3.5),mostCurrent.activityBA));
 //BA.debugLineNum = 54;BA.debugLine="simanseislabel.height = 28%y";
mostCurrent._simanseislabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (28),mostCurrent.activityBA));
 //BA.debugLineNum = 55;BA.debugLine="simanseislabel.Width  = 45%x";
mostCurrent._simanseislabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 62;BA.debugLine="listabel.Top = 3%y";
mostCurrent._listabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 63;BA.debugLine="listabel.left = 51.75%x";
mostCurrent._listabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 64;BA.debugLine="listabel.height = 13%y";
mostCurrent._listabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 65;BA.debugLine="listabel.Width  = 21.25%x";
mostCurrent._listabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 67;BA.debugLine="katigorlabel.Top = 18%y";
mostCurrent._katigorlabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 68;BA.debugLine="katigorlabel.left = 51.75%x";
mostCurrent._katigorlabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 69;BA.debugLine="katigorlabel.height = 13%y";
mostCurrent._katigorlabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 70;BA.debugLine="katigorlabel.Width  = 21.25%x";
mostCurrent._katigorlabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 73;BA.debugLine="ousialabel.Top = 3%y";
mostCurrent._ousialabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 74;BA.debugLine="ousialabel.left = 76%x";
mostCurrent._ousialabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 75;BA.debugLine="ousialabel.height = 13%y";
mostCurrent._ousialabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 76;BA.debugLine="ousialabel.Width  = 21.25%x";
mostCurrent._ousialabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 79;BA.debugLine="ililabel.Top = 18%y";
mostCurrent._ililabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 80;BA.debugLine="ililabel.left = 76%x";
mostCurrent._ililabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 81;BA.debugLine="ililabel.height = 13%y";
mostCurrent._ililabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 82;BA.debugLine="ililabel.Width  = 21.25%x";
mostCurrent._ililabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 85;BA.debugLine="mple.top = 93%y";
mostCurrent._mple.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (93),mostCurrent.activityBA));
 //BA.debugLineNum = 86;BA.debugLine="mple.left = 3%x";
mostCurrent._mple.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 87;BA.debugLine="mple.width = 94%x";
mostCurrent._mple.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 88;BA.debugLine="mple.height = 7%y";
mostCurrent._mple.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (7),mostCurrent.activityBA));
 //BA.debugLineNum = 90;BA.debugLine="deiktess.Top = 33%y";
mostCurrent._deiktess.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA));
 //BA.debugLineNum = 91;BA.debugLine="deiktess.Left = 3%x";
mostCurrent._deiktess.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 92;BA.debugLine="deiktess.height = 57.5%y";
mostCurrent._deiktess.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 93;BA.debugLine="deiktess.Width = 94%x";
mostCurrent._deiktess.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 94;BA.debugLine="Dim server As ServerSocket 'Add a reference to th";
_server = new anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper();
 //BA.debugLineNum = 95;BA.debugLine="server.Initialize(0, \"\")";
_server.Initialize(processBA,(int) (0),"");
 //BA.debugLineNum = 96;BA.debugLine="If server.GetMyIP = \"127.0.0.1\" Then  'this is th";
if ((_server.GetMyIP()).equals("127.0.0.1")) { 
 //BA.debugLineNum = 97;BA.debugLine="Msgbox(\"Δεν υπαρχει συνδεση στο διαδικτυο\",\"\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Δεν υπαρχει συνδεση στο διαδικτυο"),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 }else {
 //BA.debugLineNum = 100;BA.debugLine="load";
_load();
 };
 //BA.debugLineNum = 103;BA.debugLine="simanseislabel.BringToFront";
mostCurrent._simanseislabel.BringToFront();
 //BA.debugLineNum = 104;BA.debugLine="listabel.BringToFront";
mostCurrent._listabel.BringToFront();
 //BA.debugLineNum = 105;BA.debugLine="katigorlabel.BringToFront";
mostCurrent._katigorlabel.BringToFront();
 //BA.debugLineNum = 106;BA.debugLine="ousialabel.BringToFront";
mostCurrent._ousialabel.BringToFront();
 //BA.debugLineNum = 107;BA.debugLine="ililabel.BringToFront";
mostCurrent._ililabel.BringToFront();
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 119;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public static String  _checkmina() throws Exception{
 //BA.debugLineNum = 373;BA.debugLine="Sub checkMina";
 //BA.debugLineNum = 374;BA.debugLine="If Label11.Text = \"06\" Then";
if ((mostCurrent._label11.getText()).equals("06")) { 
 //BA.debugLineNum = 375;BA.debugLine="If Label22.Text = \"30\" Then";
if ((mostCurrent._label22.getText()).equals("30")) { 
 //BA.debugLineNum = 376;BA.debugLine="Label22.Text = \"01\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("01"));
 //BA.debugLineNum = 377;BA.debugLine="Label11.Text = \"07\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("07"));
 //BA.debugLineNum = 378;BA.debugLine="epomeno";
_epomeno();
 };
 };
 //BA.debugLineNum = 385;BA.debugLine="If Label11.Text = \"07\" Then";
if ((mostCurrent._label11.getText()).equals("07")) { 
 //BA.debugLineNum = 386;BA.debugLine="If Label22.Text = \"31\" Then";
if ((mostCurrent._label22.getText()).equals("31")) { 
 //BA.debugLineNum = 387;BA.debugLine="Label22.Text = \"01\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("01"));
 //BA.debugLineNum = 388;BA.debugLine="Label11.Text = \"08\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("08"));
 //BA.debugLineNum = 389;BA.debugLine="epomeno";
_epomeno();
 };
 };
 //BA.debugLineNum = 394;BA.debugLine="If Label11.Text = \"08\" Then";
if ((mostCurrent._label11.getText()).equals("08")) { 
 //BA.debugLineNum = 395;BA.debugLine="If Label22.Text = \"31\" Then";
if ((mostCurrent._label22.getText()).equals("31")) { 
 //BA.debugLineNum = 396;BA.debugLine="Label22.Text = \"01\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("01"));
 //BA.debugLineNum = 397;BA.debugLine="Label11.Text = \"09\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("09"));
 //BA.debugLineNum = 398;BA.debugLine="epomeno";
_epomeno();
 };
 };
 //BA.debugLineNum = 402;BA.debugLine="If Label11.Text = \"09\" Then";
if ((mostCurrent._label11.getText()).equals("09")) { 
 //BA.debugLineNum = 403;BA.debugLine="If Label22.Text = \"30\" Then";
if ((mostCurrent._label22.getText()).equals("30")) { 
 //BA.debugLineNum = 404;BA.debugLine="Label22.Text = \"01\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("01"));
 //BA.debugLineNum = 405;BA.debugLine="Label11.Text = \"10\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("10"));
 //BA.debugLineNum = 406;BA.debugLine="epomeno";
_epomeno();
 };
 };
 //BA.debugLineNum = 410;BA.debugLine="If Label11.Text = \"10\" Then";
if ((mostCurrent._label11.getText()).equals("10")) { 
 //BA.debugLineNum = 411;BA.debugLine="If Label22.Text = \"31\" Then";
if ((mostCurrent._label22.getText()).equals("31")) { 
 //BA.debugLineNum = 412;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"n";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 };
 //BA.debugLineNum = 418;BA.debugLine="If Label11.Text = \"01\" Then";
if ((mostCurrent._label11.getText()).equals("01")) { 
 //BA.debugLineNum = 419;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 421;BA.debugLine="If Label11.Text = \"02\" Then";
if ((mostCurrent._label11.getText()).equals("02")) { 
 //BA.debugLineNum = 422;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 424;BA.debugLine="If Label11.Text = \"03\" Then";
if ((mostCurrent._label11.getText()).equals("03")) { 
 //BA.debugLineNum = 425;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 427;BA.debugLine="If Label11.Text = \"04\" Then";
if ((mostCurrent._label11.getText()).equals("04")) { 
 //BA.debugLineNum = 428;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 430;BA.debugLine="If Label11.Text = \"05\" Then";
if ((mostCurrent._label11.getText()).equals("05")) { 
 //BA.debugLineNum = 431;BA.debugLine="If Label22.Text = \"31\" Then";
if ((mostCurrent._label22.getText()).equals("31")) { 
 //BA.debugLineNum = 432;BA.debugLine="Label22.Text = \"01\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("01"));
 //BA.debugLineNum = 433;BA.debugLine="Label11.Text = \"06\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("06"));
 //BA.debugLineNum = 434;BA.debugLine="epomeno";
_epomeno();
 }else {
 //BA.debugLineNum = 436;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"n";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 };
 //BA.debugLineNum = 439;BA.debugLine="If Label11.Text = \"11\" Then";
if ((mostCurrent._label11.getText()).equals("11")) { 
 //BA.debugLineNum = 440;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 442;BA.debugLine="If Label11.Text = \"12\" Then";
if ((mostCurrent._label11.getText()).equals("12")) { 
 //BA.debugLineNum = 443;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 445;BA.debugLine="End Sub";
return "";
}
public static String  _epomeno() throws Exception{
 //BA.debugLineNum = 461;BA.debugLine="Sub epomeno";
 //BA.debugLineNum = 462;BA.debugLine="If Label11.Text = \"01\" Then";
if ((mostCurrent._label11.getText()).equals("01")) { 
 //BA.debugLineNum = 463;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 465;BA.debugLine="If Label11.Text = \"02\" Then";
if ((mostCurrent._label11.getText()).equals("02")) { 
 //BA.debugLineNum = 466;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 468;BA.debugLine="If Label11.Text = \"03\" Then";
if ((mostCurrent._label11.getText()).equals("03")) { 
 //BA.debugLineNum = 469;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 471;BA.debugLine="If Label11.Text = \"04\" Then";
if ((mostCurrent._label11.getText()).equals("04")) { 
 //BA.debugLineNum = 472;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 474;BA.debugLine="If Label11.Text = \"05\" Then";
if ((mostCurrent._label11.getText()).equals("05")) { 
 //BA.debugLineNum = 475;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 478;BA.debugLine="If Label11.Text= \"06\" Then";
if ((mostCurrent._label11.getText()).equals("06")) { 
 //BA.debugLineNum = 479;BA.debugLine="getImg  = \"https://www.civilprotection.gr/sites/";
mostCurrent._getimg = "https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg";
 //BA.debugLineNum = 480;BA.debugLine="job3.Download(\"https://www.civilprotection.gr/si";
mostCurrent._job3._download /*String*/ ("https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg");
 //BA.debugLineNum = 481;BA.debugLine="Log(getImg)";
anywheresoftware.b4a.keywords.Common.LogImpl("75439508",mostCurrent._getimg,0);
 };
 //BA.debugLineNum = 483;BA.debugLine="If Label11.Text= \"07\" Then";
if ((mostCurrent._label11.getText()).equals("07")) { 
 //BA.debugLineNum = 484;BA.debugLine="getImg  = \"https://www.civilprotection.gr/sites/";
mostCurrent._getimg = "https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg";
 //BA.debugLineNum = 485;BA.debugLine="job3.Download(\"https://www.civilprotection.gr/si";
mostCurrent._job3._download /*String*/ ("https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg");
 //BA.debugLineNum = 486;BA.debugLine="Log(getImg)";
anywheresoftware.b4a.keywords.Common.LogImpl("75439513",mostCurrent._getimg,0);
 };
 //BA.debugLineNum = 488;BA.debugLine="If Label11.Text= \"08\" Then";
if ((mostCurrent._label11.getText()).equals("08")) { 
 //BA.debugLineNum = 489;BA.debugLine="getImg  = \"https://www.civilprotection.gr/sites/";
mostCurrent._getimg = "https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg";
 //BA.debugLineNum = 490;BA.debugLine="job3.Download(\"https://www.civilprotection.gr/si";
mostCurrent._job3._download /*String*/ ("https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg");
 //BA.debugLineNum = 491;BA.debugLine="Log(getImg)";
anywheresoftware.b4a.keywords.Common.LogImpl("75439518",mostCurrent._getimg,0);
 };
 //BA.debugLineNum = 493;BA.debugLine="If Label11.Text= \"09\" Then";
if ((mostCurrent._label11.getText()).equals("09")) { 
 //BA.debugLineNum = 494;BA.debugLine="getImg  = \"https://www.civilprotection.gr/sites/";
mostCurrent._getimg = "https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg";
 //BA.debugLineNum = 495;BA.debugLine="job3.Download(\"https://www.civilprotection.gr/si";
mostCurrent._job3._download /*String*/ ("https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg");
 //BA.debugLineNum = 496;BA.debugLine="Log(getImg)";
anywheresoftware.b4a.keywords.Common.LogImpl("75439523",mostCurrent._getimg,0);
 };
 //BA.debugLineNum = 498;BA.debugLine="If Label11.Text= \"10\" Then";
if ((mostCurrent._label11.getText()).equals("10")) { 
 //BA.debugLineNum = 499;BA.debugLine="getImg  = \"https://www.civilprotection.gr/sites/";
mostCurrent._getimg = "https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg";
 //BA.debugLineNum = 500;BA.debugLine="job3.Download(\"https://www.civilprotection.gr/si";
mostCurrent._job3._download /*String*/ ("https://www.civilprotection.gr/sites/default/gscp_uploads/"+mostCurrent._label33.getText()+mostCurrent._label11.getText()+mostCurrent._label22.getText()+".jpg");
 //BA.debugLineNum = 501;BA.debugLine="Log(getImg)";
anywheresoftware.b4a.keywords.Common.LogImpl("75439528",mostCurrent._getimg,0);
 };
 //BA.debugLineNum = 503;BA.debugLine="If Label11.Text = \"11\" Then";
if ((mostCurrent._label11.getText()).equals("11")) { 
 //BA.debugLineNum = 504;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 506;BA.debugLine="If Label11.Text = \"12\" Then";
if ((mostCurrent._label11.getText()).equals("12")) { 
 //BA.debugLineNum = 507;BA.debugLine="deiktess.Bitmap = LoadBitmap(File.DirAssets, \"no";
mostCurrent._deiktess.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"no.jpg").getObject()));
 };
 //BA.debugLineNum = 511;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim deiktess As ImageView";
mostCurrent._deiktess = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Dim Label11 As Label";
mostCurrent._label11 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim Label22 As Label";
mostCurrent._label22 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Dim Label33 As Label";
mostCurrent._label33 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Dim getImg As String";
mostCurrent._getimg = "";
 //BA.debugLineNum = 20;BA.debugLine="Dim job3 As HttpJob";
mostCurrent._job3 = new firefighter.companion.httpjob();
 //BA.debugLineNum = 24;BA.debugLine="Private mple As Label";
mostCurrent._mple = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private simanseislabel As Label";
mostCurrent._simanseislabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private listabel As Label";
mostCurrent._listabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private katigorlabel As Label";
mostCurrent._katigorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private ousialabel As Label";
mostCurrent._ousialabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private ililabel As Label";
mostCurrent._ililabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _gpss_click() throws Exception{
 //BA.debugLineNum = 535;BA.debugLine="Sub gpss_Click";
 //BA.debugLineNum = 537;BA.debugLine="StartActivity(\"gpssingal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssingal"));
 //BA.debugLineNum = 538;BA.debugLine="End Sub";
return "";
}
public static String  _ili_click() throws Exception{
 //BA.debugLineNum = 518;BA.debugLine="Sub ili_Click";
 //BA.debugLineNum = 519;BA.debugLine="StartActivity(\"firstaid\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("firstaid"));
 //BA.debugLineNum = 520;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
 //BA.debugLineNum = 552;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 553;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 554;BA.debugLine="StartActivity(p.OpenBrowser(\"https://www.facebook";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_p.OpenBrowser("https://www.facebook.com/groups/256720274824210/")));
 //BA.debugLineNum = 556;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(firefighter.companion.httpjob _job) throws Exception{
 //BA.debugLineNum = 446;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 447;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("75373953","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
 //BA.debugLineNum = 448;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 449;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"Job3")) {
case 0: {
 //BA.debugLineNum = 452;BA.debugLine="deiktess.SetBackgroundImage(Job.GetBitmap)";
mostCurrent._deiktess.SetBackgroundImageNew((android.graphics.Bitmap)(_job._getbitmap /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ ().getObject()));
 break; }
}
;
 }else {
 //BA.debugLineNum = 455;BA.debugLine="ToastMessageShow(\"Δεν ήταν δυνατή η σύνδεση.Οι χ";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Δεν ήταν δυνατή η σύνδεση.Οι χάρτες αναρτώνται μετα την 13:00 περιπου"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 457;BA.debugLine="Job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 458;BA.debugLine="End Sub";
return "";
}
public static String  _katigor_click() throws Exception{
 //BA.debugLineNum = 532;BA.debugLine="Sub katigor_Click";
 //BA.debugLineNum = 533;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 534;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 546;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 547;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 548;BA.debugLine="End Sub";
return "";
}
public static String  _lista_click() throws Exception{
 //BA.debugLineNum = 528;BA.debugLine="Sub lista_Click";
 //BA.debugLineNum = 529;BA.debugLine="StartActivity(\"thlefona\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("thlefona"));
 //BA.debugLineNum = 530;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 543;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 544;BA.debugLine="StartActivity(\"thlefona\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("thlefona"));
 //BA.debugLineNum = 545;BA.debugLine="End Sub";
return "";
}
public static String  _load() throws Exception{
 //BA.debugLineNum = 121;BA.debugLine="Sub load";
 //BA.debugLineNum = 122;BA.debugLine="job3.Initialize(\"Job3\", Me)";
mostCurrent._job3._initialize /*String*/ (processBA,"Job3",avrio.getObject());
 //BA.debugLineNum = 124;BA.debugLine="Label11.Text = DateTime.GetMonth(DateTime.now)";
mostCurrent._label11.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 125;BA.debugLine="Label22.Text = DateTime.GetDayOfMonth(DateTime.no";
mostCurrent._label22.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 126;BA.debugLine="Label33.Text = DateTime.GetYear(DateTime.now)";
mostCurrent._label33.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 129;BA.debugLine="If Label11.Text = \"1\" Then";
if ((mostCurrent._label11.getText()).equals("1")) { 
 //BA.debugLineNum = 130;BA.debugLine="Label11.Text = \"01\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("01"));
 };
 //BA.debugLineNum = 132;BA.debugLine="If Label11.Text = \"2\" Then";
if ((mostCurrent._label11.getText()).equals("2")) { 
 //BA.debugLineNum = 133;BA.debugLine="Label11.Text = \"02\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("02"));
 };
 //BA.debugLineNum = 135;BA.debugLine="If Label11.Text = \"3\" Then";
if ((mostCurrent._label11.getText()).equals("3")) { 
 //BA.debugLineNum = 136;BA.debugLine="Label11.Text = \"03\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("03"));
 };
 //BA.debugLineNum = 138;BA.debugLine="If Label11.Text = \"4\" Then";
if ((mostCurrent._label11.getText()).equals("4")) { 
 //BA.debugLineNum = 139;BA.debugLine="Label11.Text = \"04\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("04"));
 };
 //BA.debugLineNum = 141;BA.debugLine="If Label11.Text = \"5\" Then";
if ((mostCurrent._label11.getText()).equals("5")) { 
 //BA.debugLineNum = 142;BA.debugLine="Label11.Text = \"05\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("05"));
 };
 //BA.debugLineNum = 144;BA.debugLine="If Label11.Text = \"6\" Then";
if ((mostCurrent._label11.getText()).equals("6")) { 
 //BA.debugLineNum = 145;BA.debugLine="Label11.Text = \"06\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("06"));
 };
 //BA.debugLineNum = 147;BA.debugLine="If Label11.Text = \"7\" Then";
if ((mostCurrent._label11.getText()).equals("7")) { 
 //BA.debugLineNum = 148;BA.debugLine="Label11.Text = \"07\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("07"));
 };
 //BA.debugLineNum = 150;BA.debugLine="If Label11.Text = \"8\" Then";
if ((mostCurrent._label11.getText()).equals("8")) { 
 //BA.debugLineNum = 151;BA.debugLine="Label11.Text = \"08\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("08"));
 };
 //BA.debugLineNum = 153;BA.debugLine="If Label11.Text = \"9\" Then";
if ((mostCurrent._label11.getText()).equals("9")) { 
 //BA.debugLineNum = 154;BA.debugLine="Label11.Text = \"09\"";
mostCurrent._label11.setText(BA.ObjectToCharSequence("09"));
 };
 //BA.debugLineNum = 159;BA.debugLine="If Label22.Text = \"1\" Then";
if ((mostCurrent._label22.getText()).equals("1")) { 
 //BA.debugLineNum = 160;BA.debugLine="Label22.Text = \"02\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("02"));
 };
 //BA.debugLineNum = 162;BA.debugLine="If Label22.Text = \"2\" Then";
if ((mostCurrent._label22.getText()).equals("2")) { 
 //BA.debugLineNum = 163;BA.debugLine="Label22.Text = \"03\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("03"));
 };
 //BA.debugLineNum = 165;BA.debugLine="If Label22.Text = \"3\" Then";
if ((mostCurrent._label22.getText()).equals("3")) { 
 //BA.debugLineNum = 166;BA.debugLine="Label22.Text = \"04\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("04"));
 };
 //BA.debugLineNum = 168;BA.debugLine="If Label22.Text = \"4\" Then";
if ((mostCurrent._label22.getText()).equals("4")) { 
 //BA.debugLineNum = 169;BA.debugLine="Label22.Text = \"05\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("05"));
 };
 //BA.debugLineNum = 171;BA.debugLine="If Label22.Text = \"5\" Then";
if ((mostCurrent._label22.getText()).equals("5")) { 
 //BA.debugLineNum = 172;BA.debugLine="Label22.Text = \"06\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("06"));
 };
 //BA.debugLineNum = 174;BA.debugLine="If Label22.Text = \"6\" Then";
if ((mostCurrent._label22.getText()).equals("6")) { 
 //BA.debugLineNum = 175;BA.debugLine="Label22.Text = \"07\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("07"));
 };
 //BA.debugLineNum = 177;BA.debugLine="If Label22.Text = \"7\" Then";
if ((mostCurrent._label22.getText()).equals("7")) { 
 //BA.debugLineNum = 178;BA.debugLine="Label22.Text = \"08\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("08"));
 };
 //BA.debugLineNum = 180;BA.debugLine="If Label22.Text = \"8\" Then";
if ((mostCurrent._label22.getText()).equals("8")) { 
 //BA.debugLineNum = 181;BA.debugLine="Label22.Text = \"09\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("09"));
 };
 //BA.debugLineNum = 183;BA.debugLine="If Label22.Text = \"9\" Then";
if ((mostCurrent._label22.getText()).equals("9")) { 
 //BA.debugLineNum = 184;BA.debugLine="Label22.Text = \"10\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("10"));
 };
 //BA.debugLineNum = 186;BA.debugLine="If Label22.Text = \"10\" Then";
if ((mostCurrent._label22.getText()).equals("10")) { 
 //BA.debugLineNum = 187;BA.debugLine="Label22.Text = \"11\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("11"));
 };
 //BA.debugLineNum = 189;BA.debugLine="If Label22.Text = \"11\" Then";
if ((mostCurrent._label22.getText()).equals("11")) { 
 //BA.debugLineNum = 190;BA.debugLine="Label22.Text = \"12\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("12"));
 };
 //BA.debugLineNum = 192;BA.debugLine="If Label22.Text = \"12\" Then";
if ((mostCurrent._label22.getText()).equals("12")) { 
 //BA.debugLineNum = 193;BA.debugLine="Label22.Text = \"13\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("13"));
 };
 //BA.debugLineNum = 195;BA.debugLine="If Label22.Text = \"13\" Then";
if ((mostCurrent._label22.getText()).equals("13")) { 
 //BA.debugLineNum = 196;BA.debugLine="Label22.Text = \"14\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("14"));
 };
 //BA.debugLineNum = 198;BA.debugLine="If Label22.Text = \"14\" Then";
if ((mostCurrent._label22.getText()).equals("14")) { 
 //BA.debugLineNum = 199;BA.debugLine="Label22.Text = \"15\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("15"));
 };
 //BA.debugLineNum = 201;BA.debugLine="If Label22.Text = \"15\" Then";
if ((mostCurrent._label22.getText()).equals("15")) { 
 //BA.debugLineNum = 202;BA.debugLine="Label22.Text = \"16\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("16"));
 };
 //BA.debugLineNum = 204;BA.debugLine="If Label22.Text = \"16\" Then";
if ((mostCurrent._label22.getText()).equals("16")) { 
 //BA.debugLineNum = 205;BA.debugLine="Label22.Text = \"17\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("17"));
 };
 //BA.debugLineNum = 207;BA.debugLine="If Label22.Text = \"17\" Then";
if ((mostCurrent._label22.getText()).equals("17")) { 
 //BA.debugLineNum = 208;BA.debugLine="Label22.Text = \"18\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("18"));
 };
 //BA.debugLineNum = 210;BA.debugLine="If Label22.Text = \"18\" Then";
if ((mostCurrent._label22.getText()).equals("18")) { 
 //BA.debugLineNum = 211;BA.debugLine="Label22.Text = \"19\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("19"));
 };
 //BA.debugLineNum = 213;BA.debugLine="If Label22.Text = \"19\" Then";
if ((mostCurrent._label22.getText()).equals("19")) { 
 //BA.debugLineNum = 214;BA.debugLine="Label22.Text = \"20\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("20"));
 };
 //BA.debugLineNum = 216;BA.debugLine="If Label22.Text = \"20\" Then";
if ((mostCurrent._label22.getText()).equals("20")) { 
 //BA.debugLineNum = 217;BA.debugLine="Label22.Text = \"21\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("21"));
 };
 //BA.debugLineNum = 219;BA.debugLine="If Label22.Text = \"21\" Then";
if ((mostCurrent._label22.getText()).equals("21")) { 
 //BA.debugLineNum = 220;BA.debugLine="Label22.Text = \"22\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("22"));
 };
 //BA.debugLineNum = 222;BA.debugLine="If Label22.Text = \"22\" Then";
if ((mostCurrent._label22.getText()).equals("22")) { 
 //BA.debugLineNum = 223;BA.debugLine="Label22.Text = \"23\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("23"));
 };
 //BA.debugLineNum = 225;BA.debugLine="If Label22.Text = \"23\" Then";
if ((mostCurrent._label22.getText()).equals("23")) { 
 //BA.debugLineNum = 226;BA.debugLine="Label22.Text = \"24\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("24"));
 };
 //BA.debugLineNum = 228;BA.debugLine="If Label22.Text = \"24\" Then";
if ((mostCurrent._label22.getText()).equals("24")) { 
 //BA.debugLineNum = 229;BA.debugLine="Label22.Text = \"25\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("25"));
 };
 //BA.debugLineNum = 231;BA.debugLine="If Label22.Text = \"25\" Then";
if ((mostCurrent._label22.getText()).equals("25")) { 
 //BA.debugLineNum = 232;BA.debugLine="Label22.Text = \"26\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("26"));
 };
 //BA.debugLineNum = 234;BA.debugLine="If Label22.Text = \"26\" Then";
if ((mostCurrent._label22.getText()).equals("26")) { 
 //BA.debugLineNum = 235;BA.debugLine="Label22.Text = \"27\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("27"));
 };
 //BA.debugLineNum = 237;BA.debugLine="If Label22.Text = \"27\" Then";
if ((mostCurrent._label22.getText()).equals("27")) { 
 //BA.debugLineNum = 238;BA.debugLine="Label22.Text = \"28\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("28"));
 };
 //BA.debugLineNum = 240;BA.debugLine="If Label22.Text = \"28\" Then";
if ((mostCurrent._label22.getText()).equals("28")) { 
 //BA.debugLineNum = 241;BA.debugLine="Label22.Text = \"29\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("29"));
 };
 //BA.debugLineNum = 243;BA.debugLine="If Label22.Text = \"29\" Then";
if ((mostCurrent._label22.getText()).equals("29")) { 
 //BA.debugLineNum = 244;BA.debugLine="Label22.Text = \"30\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("30"));
 };
 //BA.debugLineNum = 248;BA.debugLine="If Label22.Text = \"01\" Then";
if ((mostCurrent._label22.getText()).equals("01")) { 
 //BA.debugLineNum = 249;BA.debugLine="Label22.Text = \"02\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("02"));
 };
 //BA.debugLineNum = 251;BA.debugLine="If Label22.Text = \"02\" Then";
if ((mostCurrent._label22.getText()).equals("02")) { 
 //BA.debugLineNum = 252;BA.debugLine="Label22.Text = \"03\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("03"));
 };
 //BA.debugLineNum = 254;BA.debugLine="If Label22.Text = \"03\" Then";
if ((mostCurrent._label22.getText()).equals("03")) { 
 //BA.debugLineNum = 255;BA.debugLine="Label22.Text = \"04\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("04"));
 };
 //BA.debugLineNum = 257;BA.debugLine="If Label22.Text = \"04\" Then";
if ((mostCurrent._label22.getText()).equals("04")) { 
 //BA.debugLineNum = 258;BA.debugLine="Label22.Text = \"05\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("05"));
 };
 //BA.debugLineNum = 260;BA.debugLine="If Label22.Text = \"05\" Then";
if ((mostCurrent._label22.getText()).equals("05")) { 
 //BA.debugLineNum = 261;BA.debugLine="Label22.Text = \"06\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("06"));
 };
 //BA.debugLineNum = 263;BA.debugLine="If Label22.Text = \"06\" Then";
if ((mostCurrent._label22.getText()).equals("06")) { 
 //BA.debugLineNum = 264;BA.debugLine="Label22.Text = \"07\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("07"));
 };
 //BA.debugLineNum = 266;BA.debugLine="If Label22.Text = \"07\" Then";
if ((mostCurrent._label22.getText()).equals("07")) { 
 //BA.debugLineNum = 267;BA.debugLine="Label22.Text = \"08\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("08"));
 };
 //BA.debugLineNum = 269;BA.debugLine="If Label22.Text = \"08\" Then";
if ((mostCurrent._label22.getText()).equals("08")) { 
 //BA.debugLineNum = 270;BA.debugLine="Label22.Text = \"09\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("09"));
 };
 //BA.debugLineNum = 272;BA.debugLine="If Label22.Text = \"09\" Then";
if ((mostCurrent._label22.getText()).equals("09")) { 
 //BA.debugLineNum = 273;BA.debugLine="Label22.Text = \"10\"";
mostCurrent._label22.setText(BA.ObjectToCharSequence("10"));
 };
 //BA.debugLineNum = 277;BA.debugLine="If Label33.Text = 2000 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2000))) { 
 //BA.debugLineNum = 278;BA.debugLine="Label33.Text = \"00\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("00"));
 };
 //BA.debugLineNum = 280;BA.debugLine="If Label33.Text = 2001 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2001))) { 
 //BA.debugLineNum = 281;BA.debugLine="Label33.Text = \"01\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("01"));
 };
 //BA.debugLineNum = 283;BA.debugLine="If Label33.Text = 2002 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2002))) { 
 //BA.debugLineNum = 284;BA.debugLine="Label33.Text = \"02\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("02"));
 };
 //BA.debugLineNum = 286;BA.debugLine="If Label33.Text = 2003 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2003))) { 
 //BA.debugLineNum = 287;BA.debugLine="Label33.Text = \"03\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("03"));
 };
 //BA.debugLineNum = 289;BA.debugLine="If Label33.Text = 2004 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2004))) { 
 //BA.debugLineNum = 290;BA.debugLine="Label33.Text = \"04\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("04"));
 };
 //BA.debugLineNum = 292;BA.debugLine="If Label33.Text = 2005 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2005))) { 
 //BA.debugLineNum = 293;BA.debugLine="Label33.Text = \"05\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("05"));
 };
 //BA.debugLineNum = 295;BA.debugLine="If Label33.Text = 2006 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2006))) { 
 //BA.debugLineNum = 296;BA.debugLine="Label33.Text = \"06\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("06"));
 };
 //BA.debugLineNum = 298;BA.debugLine="If Label33.Text = 2007 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2007))) { 
 //BA.debugLineNum = 299;BA.debugLine="Label33.Text = \"07\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("07"));
 };
 //BA.debugLineNum = 301;BA.debugLine="If Label33.Text = 2008 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2008))) { 
 //BA.debugLineNum = 302;BA.debugLine="Label33.Text = \"08\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("08"));
 };
 //BA.debugLineNum = 304;BA.debugLine="If Label33.Text = 2009 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2009))) { 
 //BA.debugLineNum = 305;BA.debugLine="Label33.Text = \"09\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("09"));
 };
 //BA.debugLineNum = 307;BA.debugLine="If Label33.Text = 2010 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2010))) { 
 //BA.debugLineNum = 308;BA.debugLine="Label33.Text = \"10\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("10"));
 };
 //BA.debugLineNum = 310;BA.debugLine="If Label33.Text = 2011 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2011))) { 
 //BA.debugLineNum = 311;BA.debugLine="Label33.Text = \"11\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("11"));
 };
 //BA.debugLineNum = 313;BA.debugLine="If Label33.Text = 2012 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2012))) { 
 //BA.debugLineNum = 314;BA.debugLine="Label33.Text = \"12\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("12"));
 };
 //BA.debugLineNum = 316;BA.debugLine="If Label33.Text = 2013 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2013))) { 
 //BA.debugLineNum = 317;BA.debugLine="Label33.Text = \"13\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("13"));
 };
 //BA.debugLineNum = 319;BA.debugLine="If Label33.Text = 2014 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2014))) { 
 //BA.debugLineNum = 320;BA.debugLine="Label33.Text = \"14\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("14"));
 };
 //BA.debugLineNum = 322;BA.debugLine="If Label33.Text = 2015 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2015))) { 
 //BA.debugLineNum = 323;BA.debugLine="Label33.Text = \"15\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("15"));
 };
 //BA.debugLineNum = 325;BA.debugLine="If Label33.Text = 2016 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2016))) { 
 //BA.debugLineNum = 326;BA.debugLine="Label33.Text = \"16\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("16"));
 };
 //BA.debugLineNum = 328;BA.debugLine="If Label33.Text = 2017 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2017))) { 
 //BA.debugLineNum = 329;BA.debugLine="Label33.Text = \"17\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("17"));
 };
 //BA.debugLineNum = 331;BA.debugLine="If Label33.Text = 2018 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2018))) { 
 //BA.debugLineNum = 332;BA.debugLine="Label33.Text = \"18\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("18"));
 };
 //BA.debugLineNum = 334;BA.debugLine="If Label33.Text = 2019 Then";
if ((mostCurrent._label33.getText()).equals(BA.NumberToString(2019))) { 
 //BA.debugLineNum = 335;BA.debugLine="Label33.Text = \"19\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("19"));
 };
 //BA.debugLineNum = 337;BA.debugLine="If Label33.Text = \"2020\" Then";
if ((mostCurrent._label33.getText()).equals("2020")) { 
 //BA.debugLineNum = 338;BA.debugLine="Label33.Text = \"20\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("20"));
 };
 //BA.debugLineNum = 340;BA.debugLine="If Label33.Text = \"2021\" Then";
if ((mostCurrent._label33.getText()).equals("2021")) { 
 //BA.debugLineNum = 341;BA.debugLine="Label33.Text = \"21\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("21"));
 };
 //BA.debugLineNum = 343;BA.debugLine="If Label33.Text = \"2022\" Then";
if ((mostCurrent._label33.getText()).equals("2022")) { 
 //BA.debugLineNum = 344;BA.debugLine="Label33.Text = \"22\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("22"));
 };
 //BA.debugLineNum = 346;BA.debugLine="If Label33.Text = \"2023\" Then";
if ((mostCurrent._label33.getText()).equals("2023")) { 
 //BA.debugLineNum = 347;BA.debugLine="Label33.Text = \"23\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("23"));
 };
 //BA.debugLineNum = 349;BA.debugLine="If Label33.Text = \"2024\" Then";
if ((mostCurrent._label33.getText()).equals("2024")) { 
 //BA.debugLineNum = 350;BA.debugLine="Label33.Text = \"24\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("24"));
 };
 //BA.debugLineNum = 352;BA.debugLine="If Label33.Text = \"2025\" Then";
if ((mostCurrent._label33.getText()).equals("2025")) { 
 //BA.debugLineNum = 353;BA.debugLine="Label33.Text = \"25\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("25"));
 };
 //BA.debugLineNum = 355;BA.debugLine="If Label33.Text = \"2026\" Then";
if ((mostCurrent._label33.getText()).equals("2026")) { 
 //BA.debugLineNum = 356;BA.debugLine="Label33.Text = \"26\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("26"));
 };
 //BA.debugLineNum = 358;BA.debugLine="If Label33.Text = \"2027\" Then";
if ((mostCurrent._label33.getText()).equals("2027")) { 
 //BA.debugLineNum = 359;BA.debugLine="Label33.Text = \"27\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("27"));
 };
 //BA.debugLineNum = 361;BA.debugLine="If Label33.Text = \"2028\" Then";
if ((mostCurrent._label33.getText()).equals("2028")) { 
 //BA.debugLineNum = 362;BA.debugLine="Label33.Text = \"28\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("28"));
 };
 //BA.debugLineNum = 364;BA.debugLine="If Label33.Text = \"2029\" Then";
if ((mostCurrent._label33.getText()).equals("2029")) { 
 //BA.debugLineNum = 365;BA.debugLine="Label33.Text = \"29\"";
mostCurrent._label33.setText(BA.ObjectToCharSequence("29"));
 };
 //BA.debugLineNum = 369;BA.debugLine="checkMina";
_checkmina();
 //BA.debugLineNum = 371;BA.debugLine="End Sub";
return "";
}
public static String  _ousia_click() throws Exception{
 //BA.debugLineNum = 521;BA.debugLine="Sub ousia_Click";
 //BA.debugLineNum = 522;BA.debugLine="StartActivity(\"gpssignal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssignal"));
 //BA.debugLineNum = 523;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 549;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 550;BA.debugLine="StartActivity(\"gpssignal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssignal"));
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
public static String  _pixi_click() throws Exception{
 //BA.debugLineNum = 524;BA.debugLine="Sub pixi_Click";
 //BA.debugLineNum = 525;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 526;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 540;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 541;BA.debugLine="StartActivity(\"deiktes\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("deiktes"));
 //BA.debugLineNum = 542;BA.debugLine="End Sub";
return "";
}
public static String  _simansi_click() throws Exception{
 //BA.debugLineNum = 557;BA.debugLine="Sub simansi_Click";
 //BA.debugLineNum = 558;BA.debugLine="StartActivity(\"deiktes\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("deiktes"));
 //BA.debugLineNum = 559;BA.debugLine="End Sub";
return "";
}
}
