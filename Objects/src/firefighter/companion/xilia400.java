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

public class xilia400 extends Activity implements B4AActivity{
	public static xilia400 mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.xilia400");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (xilia400).");
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
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.xilia400");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.xilia400", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (xilia400) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (xilia400) Resume **");
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
		return xilia400.class;
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
        BA.LogInfo("** Activity (xilia400) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            xilia400 mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (xilia400) Resume **");
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
public anywheresoftware.b4a.objects.ScrollViewWrapper _sc = null;
public anywheresoftware.b4a.objects.ButtonWrapper _ili = null;
public anywheresoftware.b4a.objects.ButtonWrapper _ousia = null;
public anywheresoftware.b4a.objects.ButtonWrapper _simansi = null;
public anywheresoftware.b4a.objects.ButtonWrapper _pixi = null;
public anywheresoftware.b4a.objects.ButtonWrapper _lista = null;
public anywheresoftware.b4a.objects.ButtonWrapper _katigor = null;
public anywheresoftware.b4a.objects.LabelWrapper _fakos = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _mple = null;
public anywheresoftware.b4a.objects.LabelWrapper _simanseislabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _listabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _katigorlabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ousialabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ililabel = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel = null;
public firefighter.companion.customlistview _clv2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
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
 //BA.debugLineNum = 42;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"adr.bal\")";
mostCurrent._activity.LoadLayout("adr.bal",mostCurrent.activityBA);
 //BA.debugLineNum = 48;BA.debugLine="simanseislabel.Top = 3%y";
mostCurrent._simanseislabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 49;BA.debugLine="simanseislabel.left = 3.5%x";
mostCurrent._simanseislabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3.5),mostCurrent.activityBA));
 //BA.debugLineNum = 50;BA.debugLine="simanseislabel.height = 27.5%y";
mostCurrent._simanseislabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (27.5),mostCurrent.activityBA));
 //BA.debugLineNum = 51;BA.debugLine="simanseislabel.Width  = 45%x";
mostCurrent._simanseislabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 52;BA.debugLine="simansi.Top = 3%y";
mostCurrent._simansi.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 53;BA.debugLine="simansi.left = 3%x";
mostCurrent._simansi.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 54;BA.debugLine="simansi.height = 28%y";
mostCurrent._simansi.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (28),mostCurrent.activityBA));
 //BA.debugLineNum = 55;BA.debugLine="simansi.Width  = 45%x";
mostCurrent._simansi.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 60;BA.debugLine="lista.Top = 3%y";
mostCurrent._lista.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 61;BA.debugLine="lista.left = 51.5%x";
mostCurrent._lista.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.5),mostCurrent.activityBA));
 //BA.debugLineNum = 62;BA.debugLine="lista.height = 13%y";
mostCurrent._lista.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 63;BA.debugLine="lista.Width  = 21.25%x";
mostCurrent._lista.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 65;BA.debugLine="listabel.Top = 3%y";
mostCurrent._listabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 66;BA.debugLine="listabel.left = 51.75%x";
mostCurrent._listabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 67;BA.debugLine="listabel.height = 13%y";
mostCurrent._listabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 68;BA.debugLine="listabel.Width  = 21.25%x";
mostCurrent._listabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 72;BA.debugLine="katigor.Top = 18%y";
mostCurrent._katigor.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 73;BA.debugLine="katigor.left = 51.50%x";
mostCurrent._katigor.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.50),mostCurrent.activityBA));
 //BA.debugLineNum = 74;BA.debugLine="katigor.height = 13%y";
mostCurrent._katigor.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 75;BA.debugLine="katigor.Width  = 21.25%x";
mostCurrent._katigor.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 77;BA.debugLine="katigorlabel.Top = 18%y";
mostCurrent._katigorlabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 78;BA.debugLine="katigorlabel.left = 51.75%x";
mostCurrent._katigorlabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 79;BA.debugLine="katigorlabel.height = 13%y";
mostCurrent._katigorlabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 80;BA.debugLine="katigorlabel.Width  = 21.25%x";
mostCurrent._katigorlabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 82;BA.debugLine="ousia.Top = 3%y";
mostCurrent._ousia.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 83;BA.debugLine="ousia.left = 75.75%x";
mostCurrent._ousia.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75.75),mostCurrent.activityBA));
 //BA.debugLineNum = 84;BA.debugLine="ousia.height = 13%y";
mostCurrent._ousia.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 85;BA.debugLine="ousia.Width  = 21.25%x";
mostCurrent._ousia.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 86;BA.debugLine="ousialabel.Top = 3%y";
mostCurrent._ousialabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 87;BA.debugLine="ousialabel.left = 76%x";
mostCurrent._ousialabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 88;BA.debugLine="ousialabel.height = 13%y";
mostCurrent._ousialabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 89;BA.debugLine="ousialabel.Width  = 21.25%x";
mostCurrent._ousialabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 91;BA.debugLine="ili.Top = 18%y";
mostCurrent._ili.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 92;BA.debugLine="ili.left = 75.75%x";
mostCurrent._ili.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75.75),mostCurrent.activityBA));
 //BA.debugLineNum = 93;BA.debugLine="ili.height = 13%y";
mostCurrent._ili.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 94;BA.debugLine="ili.Width  = 21.25%x";
mostCurrent._ili.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 95;BA.debugLine="ililabel.Top = 18%y";
mostCurrent._ililabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 96;BA.debugLine="ililabel.left = 76%x";
mostCurrent._ililabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 97;BA.debugLine="ililabel.height = 13%y";
mostCurrent._ililabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 98;BA.debugLine="ililabel.Width  = 21.25%x";
mostCurrent._ililabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 101;BA.debugLine="mple.top = 93%y";
mostCurrent._mple.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (93),mostCurrent.activityBA));
 //BA.debugLineNum = 102;BA.debugLine="mple.left = 3%x";
mostCurrent._mple.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 103;BA.debugLine="mple.width = 94%x";
mostCurrent._mple.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 104;BA.debugLine="mple.height = 7%y";
mostCurrent._mple.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (7),mostCurrent.activityBA));
 //BA.debugLineNum = 116;BA.debugLine="clv2.Initialize(Me, \"clv2\")";
mostCurrent._clv2._initialize /*String*/ (mostCurrent.activityBA,xilia400.getObject(),"clv2");
 //BA.debugLineNum = 117;BA.debugLine="Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y";
mostCurrent._panel2.AddView((android.view.View)(mostCurrent._clv2._asview /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ ().getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 118;BA.debugLine="Panel2.Top = 33%y";
mostCurrent._panel2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA));
 //BA.debugLineNum = 119;BA.debugLine="Panel2.Left = 3%x";
mostCurrent._panel2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 120;BA.debugLine="Panel2.Width = 94%x";
mostCurrent._panel2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 121;BA.debugLine="Panel2.Height = 57.5%y";
mostCurrent._panel2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 122;BA.debugLine="clv2.DefaultTextBackgroundColor = Colors.DarkGray";
mostCurrent._clv2._defaulttextbackgroundcolor /*int*/  = anywheresoftware.b4a.keywords.Common.Colors.DarkGray;
 //BA.debugLineNum = 125;BA.debugLine="clv2.AddTextItem(\"1301	ΚΑΤΗΓΟΡΙΑ 3	Οξικό βινύλιο ,";
mostCurrent._clv2._addtextitem /*String*/ ("1301	ΚΑΤΗΓΟΡΙΑ 3	Οξικό βινύλιο , αναστέλλεται	   ",(Object)(""));
 //BA.debugLineNum = 126;BA.debugLine="clv2.AddTextItem(\"1302	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλ βινυλ αιθ";
mostCurrent._clv2._addtextitem /*String*/ ("1302	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλ βινυλ αιθέρας , παρεμπόδισε	   ",(Object)(""));
 //BA.debugLineNum = 127;BA.debugLine="clv2.AddTextItem(\"1303	ΚΑΤΗΓΟΡΙΑ 3	Χλωριούχο βινυλ";
mostCurrent._clv2._addtextitem /*String*/ ("1303	ΚΑΤΗΓΟΡΙΑ 3	Χλωριούχο βινυλιδένιο , παρεμπόδισε	     ",(Object)(""));
 //BA.debugLineNum = 128;BA.debugLine="clv2.AddTextItem(\"1304	ΚΑΤΗΓΟΡΙΑ 3	Vinyl ισοβουτυλ";
mostCurrent._clv2._addtextitem /*String*/ ("1304	ΚΑΤΗΓΟΡΙΑ 3	Vinyl ισοβουτυλαιθέρα , αναστέλλεται	   ",(Object)(""));
 //BA.debugLineNum = 129;BA.debugLine="clv2.AddTextItem(\"1305	ΚΑΤΗΓΟΡΙΑ 3	Vinyltrichloros";
mostCurrent._clv2._addtextitem /*String*/ ("1305	ΚΑΤΗΓΟΡΙΑ 3	Vinyltrichlorosilane , αναστέλλεται	   ",(Object)(""));
 //BA.debugLineNum = 130;BA.debugLine="clv2.AddTextItem(\"1306	ΚΑΤΗΓΟΡΙΑ 3	Συντηρητικά ξύλ";
mostCurrent._clv2._addtextitem /*String*/ ("1306	ΚΑΤΗΓΟΡΙΑ 3	Συντηρητικά ξύλου , υγρό	      ",(Object)(""));
 //BA.debugLineNum = 131;BA.debugLine="clv2.AddTextItem(\"1307	ΚΑΤΗΓΟΡΙΑ 3	Ξυλόλια	      \"";
mostCurrent._clv2._addtextitem /*String*/ ("1307	ΚΑΤΗΓΟΡΙΑ 3	Ξυλόλια	      ",(Object)(""));
 //BA.debugLineNum = 132;BA.debugLine="clv2.AddTextItem(\"1308	ΚΑΤΗΓΟΡΙΑ 3	Ζιρκόνιο εναιωρ";
mostCurrent._clv2._addtextitem /*String*/ ("1308	ΚΑΤΗΓΟΡΙΑ 3	Ζιρκόνιο εναιωρείται σε ένα υγρό	   ",(Object)(""));
 //BA.debugLineNum = 133;BA.debugLine="clv2.AddTextItem(\"1309	ΚΑΤΗΓΟΡΙΑ 4.1	Αλουμίνιο σε";
mostCurrent._clv2._addtextitem /*String*/ ("1309	ΚΑΤΗΓΟΡΙΑ 4.1	Αλουμίνιο σε σκόνη, με επικάλυψη	   ",(Object)(""));
 //BA.debugLineNum = 134;BA.debugLine="clv2.AddTextItem(\"1310	ΚΑΤΗΓΟΡΙΑ 4.1	Πικρικό αμμών";
mostCurrent._clv2._addtextitem /*String*/ ("1310	ΚΑΤΗΓΟΡΙΑ 4.1	Πικρικό αμμώνιο 	      ",(Object)(""));
 //BA.debugLineNum = 135;BA.debugLine="clv2.AddTextItem(\"1312	ΚΑΤΗΓΟΡΙΑ 4.1	Βορνεόλη";
mostCurrent._clv2._addtextitem /*String*/ ("1312	ΚΑΤΗΓΟΡΙΑ 4.1	Βορνεόλη	      ",(Object)(""));
 //BA.debugLineNum = 136;BA.debugLine="clv2.AddTextItem(\"1313	ΚΑΤΗΓΟΡΙΑ 4.1	Αβιετικός ασβ";
mostCurrent._clv2._addtextitem /*String*/ ("1313	ΚΑΤΗΓΟΡΙΑ 4.1	Αβιετικός ασβεστίου	      ",(Object)(""));
 //BA.debugLineNum = 137;BA.debugLine="clv2.AddTextItem(\"1314	ΚΑΤΗΓΟΡΙΑ 4.1	Αβιετικός ασβ";
mostCurrent._clv2._addtextitem /*String*/ ("1314	ΚΑΤΗΓΟΡΙΑ 4.1	Αβιετικός ασβέστιο, λιωμένο	      ",(Object)(""));
 //BA.debugLineNum = 138;BA.debugLine="clv2.AddTextItem(\"1318	ΚΑΤΗΓΟΡΙΑ 4.1	Κοβάλτιο αβιε";
mostCurrent._clv2._addtextitem /*String*/ ("1318	ΚΑΤΗΓΟΡΙΑ 4.1	Κοβάλτιο αβιετικός , καθιζάνει	      ",(Object)(""));
 //BA.debugLineNum = 139;BA.debugLine="clv2.AddTextItem(\"1320	ΚΑΤΗΓΟΡΙΑ 4.1	Δινιτροφαινόλ";
mostCurrent._clv2._addtextitem /*String*/ ("1320	ΚΑΤΗΓΟΡΙΑ 4.1	Δινιτροφαινόλης 	      ",(Object)(""));
 //BA.debugLineNum = 140;BA.debugLine="clv2.AddTextItem(\"1321	ΚΑΤΗΓΟΡΙΑ 4.1	Dinitrophenol";
mostCurrent._clv2._addtextitem /*String*/ ("1321	ΚΑΤΗΓΟΡΙΑ 4.1	Dinitrophenolates	      ",(Object)(""));
 //BA.debugLineNum = 141;BA.debugLine="clv2.AddTextItem(\"1322	ΚΑΤΗΓΟΡΙΑ 4.1	Dinitroresorc";
mostCurrent._clv2._addtextitem /*String*/ ("1322	ΚΑΤΗΓΟΡΙΑ 4.1	Dinitroresorcinol 	      ",(Object)(""));
 //BA.debugLineNum = 142;BA.debugLine="clv2.AddTextItem(\"1323	ΚΑΤΗΓΟΡΙΑ 4.1	Ferrocerium";
mostCurrent._clv2._addtextitem /*String*/ ("1323	ΚΑΤΗΓΟΡΙΑ 4.1	Ferrocerium	      ",(Object)(""));
 //BA.debugLineNum = 143;BA.debugLine="clv2.AddTextItem(\"1324	ΚΑΤΗΓΟΡΙΑ 4.1	Ταινίες, νιτρ";
mostCurrent._clv2._addtextitem /*String*/ ("1324	ΚΑΤΗΓΟΡΙΑ 4.1	Ταινίες, νιτροκυτταρίνη βάση	      ",(Object)(""));
 //BA.debugLineNum = 144;BA.debugLine="clv2.AddTextItem(\"1325	ΚΑΤΗΓΟΡΙΑ 4.1	Εύφλεκτα στερ";
mostCurrent._clv2._addtextitem /*String*/ ("1325	ΚΑΤΗΓΟΡΙΑ 4.1	Εύφλεκτα στερεά, οργανικά, 	      ",(Object)(""));
 //BA.debugLineNum = 145;BA.debugLine="clv2.AddTextItem(\"1326	ΚΑΤΗΓΟΡΙΑ 4.1	Άφνιο σκόνη";
mostCurrent._clv2._addtextitem /*String*/ ("1326	ΚΑΤΗΓΟΡΙΑ 4.1	Άφνιο σκόνη	      ",(Object)(""));
 //BA.debugLineNum = 146;BA.debugLine="clv2.AddTextItem(\"1327	ΚΑΤΗΓΟΡΙΑ 4.1	Σανό, άχυρο ή";
mostCurrent._clv2._addtextitem /*String*/ ("1327	ΚΑΤΗΓΟΡΙΑ 4.1	Σανό, άχυρο ή Bhusa, υγρό, υγρό ή έχουν μολυνθεί με πετρέλαιο   ",(Object)(""));
 //BA.debugLineNum = 147;BA.debugLine="clv2.AddTextItem(\"1328	ΚΑΤΗΓΟΡΙΑ 4.1	Εξαμεθυλενοτε";
mostCurrent._clv2._addtextitem /*String*/ ("1328	ΚΑΤΗΓΟΡΙΑ 4.1	Εξαμεθυλενοτετραμίνη	      ",(Object)(""));
 //BA.debugLineNum = 148;BA.debugLine="clv2.AddTextItem(\"1330	ΚΑΤΗΓΟΡΙΑ 4.1	Μαγγάνιο αβιε";
mostCurrent._clv2._addtextitem /*String*/ ("1330	ΚΑΤΗΓΟΡΙΑ 4.1	Μαγγάνιο αβιετικός	      ",(Object)(""));
 //BA.debugLineNum = 149;BA.debugLine="clv2.AddTextItem(\"1331	ΚΑΤΗΓΟΡΙΑ 4.1	Αγώνες , χτυπ";
mostCurrent._clv2._addtextitem /*String*/ ("1331	ΚΑΤΗΓΟΡΙΑ 4.1	Αγώνες , χτυπήσει οπουδήποτε	      ",(Object)(""));
 //BA.debugLineNum = 150;BA.debugLine="clv2.AddTextItem(\"1332	ΚΑΤΗΓΟΡΙΑ 4.1	Μεταλδεΰδη";
mostCurrent._clv2._addtextitem /*String*/ ("1332	ΚΑΤΗΓΟΡΙΑ 4.1	Μεταλδεΰδη	      ",(Object)(""));
 //BA.debugLineNum = 151;BA.debugLine="clv2.AddTextItem(\"1333	ΚΑΤΗΓΟΡΙΑ 4.1	Δημήτριο , πλ";
mostCurrent._clv2._addtextitem /*String*/ ("1333	ΚΑΤΗΓΟΡΙΑ 4.1	Δημήτριο , πλάκες, ράβδους, βέργες    ",(Object)(""));
 //BA.debugLineNum = 152;BA.debugLine="clv2.AddTextItem(\"1334	ΚΑΤΗΓΟΡΙΑ 4.1	Ναφθαλίνης ,";
mostCurrent._clv2._addtextitem /*String*/ ("1334	ΚΑΤΗΓΟΡΙΑ 4.1	Ναφθαλίνης , ακατέργαστα ή ναφθαλίνης, εξευγενισμένα	   ",(Object)(""));
 //BA.debugLineNum = 153;BA.debugLine="clv2.AddTextItem(\"1336	ΚΑΤΗΓΟΡΙΑ 4.1	Νιτρογουανιδί";
mostCurrent._clv2._addtextitem /*String*/ ("1336	ΚΑΤΗΓΟΡΙΑ 4.1	Νιτρογουανιδίνη , νωπό ή Picrite	      ",(Object)(""));
 //BA.debugLineNum = 154;BA.debugLine="clv2.AddTextItem(\"1337	ΚΑΤΗΓΟΡΙΑ 4.1	Nitrostarch";
mostCurrent._clv2._addtextitem /*String*/ ("1337	ΚΑΤΗΓΟΡΙΑ 4.1	Nitrostarch      ",(Object)(""));
 //BA.debugLineNum = 155;BA.debugLine="clv2.AddTextItem(\"1338	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος , άμ";
mostCurrent._clv2._addtextitem /*String*/ ("1338	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος , άμορφο	      ",(Object)(""));
 //BA.debugLineNum = 156;BA.debugLine="clv2.AddTextItem(\"1339	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος hept";
mostCurrent._clv2._addtextitem /*String*/ ("1339	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος heptasulfide , ελεύθερα από κίτρινο ή λευκό φώσφορο   ",(Object)(""));
 //BA.debugLineNum = 157;BA.debugLine="clv2.AddTextItem(\"1340	ΚΑΤΗΓΟΡΙΑ 4.3	Πενταθειούχο";
mostCurrent._clv2._addtextitem /*String*/ ("1340	ΚΑΤΗΓΟΡΙΑ 4.3	Πενταθειούχο φωσφόρο , ελεύθερα από κίτρινο ή λευκό φώσφορο	   ",(Object)(""));
 //BA.debugLineNum = 158;BA.debugLine="clv2.AddTextItem(\"1341	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος sesq";
mostCurrent._clv2._addtextitem /*String*/ ("1341	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος sesquisulfide , ελεύθερα από κίτρινο ή λευκό φώσφορο	   ",(Object)(""));
 //BA.debugLineNum = 159;BA.debugLine="clv2.AddTextItem(\"1343	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος τρισ";
mostCurrent._clv2._addtextitem /*String*/ ("1343	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος τρισουλφίδιο , ελεύθερα από κίτρινο ή λευκό φώσφορο	   ",(Object)(""));
 //BA.debugLineNum = 160;BA.debugLine="clv2.AddTextItem(\"1344	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροφαινό";
mostCurrent._clv2._addtextitem /*String*/ ("1344	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροφαινόλη   ",(Object)(""));
 //BA.debugLineNum = 161;BA.debugLine="clv2.AddTextItem(\"1345	ΚΑΤΗΓΟΡΙΑ 4.1	Καουτσούκ θρα";
mostCurrent._clv2._addtextitem /*String*/ ("1345	ΚΑΤΗΓΟΡΙΑ 4.1	Καουτσούκ θραύσματα ή κακής ποιότητας   ",(Object)(""));
 //BA.debugLineNum = 162;BA.debugLine="clv2.AddTextItem(\"1346	ΚΑΤΗΓΟΡΙΑ 4.1	Πυρίτιο σκόνη";
mostCurrent._clv2._addtextitem /*String*/ ("1346	ΚΑΤΗΓΟΡΙΑ 4.1	Πυρίτιο σκόνη, άμορφο	      ",(Object)(""));
 //BA.debugLineNum = 163;BA.debugLine="clv2.AddTextItem(\"1347	ΚΑΤΗΓΟΡΙΑ 4.1	Ασήμι πικρικό";
mostCurrent._clv2._addtextitem /*String*/ ("1347	ΚΑΤΗΓΟΡΙΑ 4.1	Ασήμι πικρικό 	      ",(Object)(""));
 //BA.debugLineNum = 164;BA.debugLine="clv2.AddTextItem(\"1348	ΚΑΤΗΓΟΡΙΑ 4.1	Δινιτρο-ο-κρε";
mostCurrent._clv2._addtextitem /*String*/ ("1348	ΚΑΤΗΓΟΡΙΑ 4.1	Δινιτρο-ο-κρεζολικό νάτριο       ",(Object)(""));
 //BA.debugLineNum = 165;BA.debugLine="clv2.AddTextItem(\"1349	ΚΑΤΗΓΟΡΙΑ 4.1	Picramate νάτ";
mostCurrent._clv2._addtextitem /*String*/ ("1349	ΚΑΤΗΓΟΡΙΑ 4.1	Picramate νάτριο       ",(Object)(""));
 //BA.debugLineNum = 166;BA.debugLine="clv2.AddTextItem(\"1350	ΚΑΤΗΓΟΡΙΑ 4.1	Θείο	      \"";
mostCurrent._clv2._addtextitem /*String*/ ("1350	ΚΑΤΗΓΟΡΙΑ 4.1	Θείο	      ",(Object)(""));
 //BA.debugLineNum = 167;BA.debugLine="clv2.AddTextItem(\"1352	ΚΑΤΗΓΟΡΙΑ 4.1	Τιτάνιο σκόνη";
mostCurrent._clv2._addtextitem /*String*/ ("1352	ΚΑΤΗΓΟΡΙΑ 4.1	Τιτάνιο σκόνη    ",(Object)(""));
 //BA.debugLineNum = 168;BA.debugLine="clv2.AddTextItem(\"1353	ΚΑΤΗΓΟΡΙΑ 4.1	Ίνες ή υφάσμα";
mostCurrent._clv2._addtextitem /*String*/ ("1353	ΚΑΤΗΓΟΡΙΑ 4.1	Ίνες ή υφάσματα εμποτισμένα με ασθενώς νιτρωμένη νιτροκυτταρίνη, 	      ",(Object)(""));
 //BA.debugLineNum = 169;BA.debugLine="clv2.AddTextItem(\"1354	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροβενζό";
mostCurrent._clv2._addtextitem /*String*/ ("1354	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροβενζόλιο     ",(Object)(""));
 //BA.debugLineNum = 170;BA.debugLine="clv2.AddTextItem(\"1355	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροβενζο";
mostCurrent._clv2._addtextitem /*String*/ ("1355	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροβενζοϊκό οξύ	   ",(Object)(""));
 //BA.debugLineNum = 171;BA.debugLine="clv2.AddTextItem(\"1356	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροτολου";
mostCurrent._clv2._addtextitem /*String*/ ("1356	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροτολουένιο νωπή     ",(Object)(""));
 //BA.debugLineNum = 172;BA.debugLine="clv2.AddTextItem(\"1357	ΚΑΤΗΓΟΡΙΑ 4.1	Νιτρικό ουρία";
mostCurrent._clv2._addtextitem /*String*/ ("1357	ΚΑΤΗΓΟΡΙΑ 4.1	Νιτρικό ουρία 	      ",(Object)(""));
 //BA.debugLineNum = 173;BA.debugLine="clv2.AddTextItem(\"1358	ΚΑΤΗΓΟΡΙΑ 4.1	Ζιρκόνιο σκόν";
mostCurrent._clv2._addtextitem /*String*/ ("1358	ΚΑΤΗΓΟΡΙΑ 4.1	Ζιρκόνιο σκόνη      ",(Object)(""));
 //BA.debugLineNum = 174;BA.debugLine="clv2.AddTextItem(\"1360	ΚΑΤΗΓΟΡΙΑ 4.2	Φωσφορούχο ασ";
mostCurrent._clv2._addtextitem /*String*/ ("1360	ΚΑΤΗΓΟΡΙΑ 4.2	Φωσφορούχο ασβέστιο	    ",(Object)(""));
 //BA.debugLineNum = 175;BA.debugLine="clv2.AddTextItem(\"1361	ΚΑΤΗΓΟΡΙΑ 4.2	Άνθρακα , ζωι";
mostCurrent._clv2._addtextitem /*String*/ ("1361	ΚΑΤΗΓΟΡΙΑ 4.2	Άνθρακα , ζωικής ή φυτικής προέλευσης	      ",(Object)(""));
 //BA.debugLineNum = 176;BA.debugLine="clv2.AddTextItem(\"1362	ΚΑΤΗΓΟΡΙΑ 4 2	Άνθρακας, ενε";
mostCurrent._clv2._addtextitem /*String*/ ("1362	ΚΑΤΗΓΟΡΙΑ 4 2	Άνθρακας, ενεργοποιημένος	      ",(Object)(""));
 //BA.debugLineNum = 177;BA.debugLine="clv2.AddTextItem(\"1363	ΚΑΤΗΓΟΡΙΑ 4.2	Ξηρά κοκοκάρυ";
mostCurrent._clv2._addtextitem /*String*/ ("1363	ΚΑΤΗΓΟΡΙΑ 4.2	Ξηρά κοκοκάρυδα	      ",(Object)(""));
 //BA.debugLineNum = 178;BA.debugLine="clv2.AddTextItem(\"1364	ΚΑΤΗΓΟΡΙΑ 4.2	Βαμβάκι αποβλ";
mostCurrent._clv2._addtextitem /*String*/ ("1364	ΚΑΤΗΓΟΡΙΑ 4.2	Βαμβάκι αποβλήτων, τα λιπαρά   ",(Object)(""));
 //BA.debugLineNum = 179;BA.debugLine="clv2.AddTextItem(\"1365	ΚΑΤΗΓΟΡΙΑ 4.2	Βαμβάκι, υγρή";
mostCurrent._clv2._addtextitem /*String*/ ("1365	ΚΑΤΗΓΟΡΙΑ 4.2	Βαμβάκι, υγρή	      ",(Object)(""));
 //BA.debugLineNum = 180;BA.debugLine="clv2.AddTextItem(\"1366	ΚΑΤΗΓΟΡΙΑ 4.2	Διαιθυλοψευδά";
mostCurrent._clv2._addtextitem /*String*/ ("1366	ΚΑΤΗΓΟΡΙΑ 4.2	Διαιθυλοψευδάργυρο	   ",(Object)(""));
 //BA.debugLineNum = 181;BA.debugLine="clv2.AddTextItem(\"1369	ΚΑΤΗΓΟΡΙΑ 4.2	Ρ-νιτροζο";
mostCurrent._clv2._addtextitem /*String*/ ("1369	ΚΑΤΗΓΟΡΙΑ 4.2	Ρ-νιτροζο	      ",(Object)(""));
 //BA.debugLineNum = 182;BA.debugLine="clv2.AddTextItem(\"1370	ΚΑΤΗΓΟΡΙΑ 4.2	Διμεθυλψευδαρ";
mostCurrent._clv2._addtextitem /*String*/ ("1370	ΚΑΤΗΓΟΡΙΑ 4.2	Διμεθυλψευδαργύρου	   ",(Object)(""));
 //BA.debugLineNum = 183;BA.debugLine="clv2.AddTextItem(\"1373	ΚΑΤΗΓΟΡΙΑ 4.2	Ίνες ή υφάσμα";
mostCurrent._clv2._addtextitem /*String*/ ("1373	ΚΑΤΗΓΟΡΙΑ 4.2	Ίνες ή υφάσματα, ζωικά ή φυτικά ή συνθετικά,  με ζωικό ή φυτικό έλαιο   ",(Object)(""));
 //BA.debugLineNum = 184;BA.debugLine="clv2.AddTextItem(\"1374	ΚΑΤΗΓΟΡΙΑ 4.2	Ιχθυάλευρα ,";
mostCurrent._clv2._addtextitem /*String*/ ("1374	ΚΑΤΗΓΟΡΙΑ 4.2	Ιχθυάλευρα , μη σταθεροποιημένα ή ψάρια θραύσματα	   ",(Object)(""));
 //BA.debugLineNum = 185;BA.debugLine="clv2.AddTextItem(\"1376	ΚΑΤΗΓΟΡΙΑ 4.2	Οξείδιο  σιδή";
mostCurrent._clv2._addtextitem /*String*/ ("1376	ΚΑΤΗΓΟΡΙΑ 4.2	Οξείδιο  σιδήρου 	      ",(Object)(""));
 //BA.debugLineNum = 186;BA.debugLine="clv2.AddTextItem(\"1378	ΚΑΤΗΓΟΡΙΑ 4.2	Μέταλλο  κατα";
mostCurrent._clv2._addtextitem /*String*/ ("1378	ΚΑΤΗΓΟΡΙΑ 4.2	Μέταλλο  καταλύτη , διαβρέχεται με ορατή περίσσεια υγρού	      ",(Object)(""));
 //BA.debugLineNum = 187;BA.debugLine="clv2.AddTextItem(\"1379	ΚΑΤΗΓΟΡΙΑ 4.2	Χαρτί , ακόρε";
mostCurrent._clv2._addtextitem /*String*/ ("1379	ΚΑΤΗΓΟΡΙΑ 4.2	Χαρτί , ακόρεστο λάδι ,καρμπόν	      ",(Object)(""));
 //BA.debugLineNum = 188;BA.debugLine="clv2.AddTextItem(\"1380	ΚΑΤΗΓΟΡΙΑ 4.2	Pentaborane";
mostCurrent._clv2._addtextitem /*String*/ ("1380	ΚΑΤΗΓΟΡΙΑ 4.2	Pentaborane	      ",(Object)(""));
 //BA.debugLineNum = 189;BA.debugLine="clv2.AddTextItem(\"1381	ΚΑΤΗΓΟΡΙΑ 4.2	Φωσφόρος, λευ";
mostCurrent._clv2._addtextitem /*String*/ ("1381	ΚΑΤΗΓΟΡΙΑ 4.2	Φωσφόρος, λευκός ξηρός ή φωσφόρος, λευκός   ",(Object)(""));
 //BA.debugLineNum = 190;BA.debugLine="clv2.AddTextItem(\"1382	ΚΑΤΗΓΟΡΙΑ 4.2	Θειούχο κάλιο";
mostCurrent._clv2._addtextitem /*String*/ ("1382	ΚΑΤΗΓΟΡΙΑ 4.2	Θειούχο κάλιο , άνυδρο ή Κάλιο σουλφίδιο	   ",(Object)(""));
 //BA.debugLineNum = 191;BA.debugLine="clv2.AddTextItem(\"1383	ΚΑΤΗΓΟΡΙΑ 4.2	Πυροφορικό με";
mostCurrent._clv2._addtextitem /*String*/ ("1383	ΚΑΤΗΓΟΡΙΑ 4.2	Πυροφορικό μετάλλων,  ή Πυροφορικά κράματα, 	      ",(Object)(""));
 //BA.debugLineNum = 192;BA.debugLine="clv2.AddTextItem(\"1384	ΚΑΤΗΓΟΡΙΑ 4.2	Διθειονώδης ν";
mostCurrent._clv2._addtextitem /*String*/ ("1384	ΚΑΤΗΓΟΡΙΑ 4.2	Διθειονώδης νάτριο ή υδροθειώδες νάτριο	      ",(Object)(""));
 //BA.debugLineNum = 193;BA.debugLine="clv2.AddTextItem(\"1385	ΚΑΤΗΓΟΡΙΑ 4.2	Θειούχο νάτρι";
mostCurrent._clv2._addtextitem /*String*/ ("1385	ΚΑΤΗΓΟΡΙΑ 4.2	Θειούχο νάτριο , άνυδρο ή νάτριο σουλφίδιο	      ",(Object)(""));
 //BA.debugLineNum = 194;BA.debugLine="clv2.AddTextItem(\"1389	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλίων και";
mostCurrent._clv2._addtextitem /*String*/ ("1389	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλίων και αμάλγαμα , υγρό ή αλκαλίων και αμάλγαμα, στερεά	   ",(Object)(""));
 //BA.debugLineNum = 195;BA.debugLine="clv2.AddTextItem(\"1390	ΚΑΤΗΓΟΡΙΑ 4.3	Αμίδια αλκαλι";
mostCurrent._clv2._addtextitem /*String*/ ("1390	ΚΑΤΗΓΟΡΙΑ 4.3	Αμίδια αλκαλιμετάλλου	      ",(Object)(""));
 //BA.debugLineNum = 196;BA.debugLine="clv2.AddTextItem(\"1391	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλιμετάλλο";
mostCurrent._clv2._addtextitem /*String*/ ("1391	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλιμετάλλου διασπορές, ή μετάλλου αλκαλικής γαίας διασπορές   ",(Object)(""));
 //BA.debugLineNum = 197;BA.debugLine="clv2.AddTextItem(\"1392	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλικής γαί";
mostCurrent._clv2._addtextitem /*String*/ ("1392	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλικής γαίας μέταλλο αμαλγάματα	      ",(Object)(""));
 //BA.debugLineNum = 198;BA.debugLine="clv2.AddTextItem(\"1393	ΚΑΤΗΓΟΡΙΑ 4.3	Μετάλλου αλκα";
mostCurrent._clv2._addtextitem /*String*/ ("1393	ΚΑΤΗΓΟΡΙΑ 4.3	Μετάλλου αλκαλικής γαίας κράματα , nos	     ",(Object)(""));
 //BA.debugLineNum = 199;BA.debugLine="clv2.AddTextItem(\"1394	ΚΑΤΗΓΟΡΙΑ 4.3	Αλουμίνιο καρ";
mostCurrent._clv2._addtextitem /*String*/ ("1394	ΚΑΤΗΓΟΡΙΑ 4.3	Αλουμίνιο καρβίδιο	      ",(Object)(""));
 //BA.debugLineNum = 200;BA.debugLine="clv2.AddTextItem(\"1395	ΚΑΤΗΓΟΡΙΑ 4.3	ΣιδηροπυρΙτιο";
mostCurrent._clv2._addtextitem /*String*/ ("1395	ΚΑΤΗΓΟΡΙΑ 4.3	ΣιδηροπυρΙτιο Αλουμινίου σκόνη	      ",(Object)(""));
 //BA.debugLineNum = 201;BA.debugLine="clv2.AddTextItem(\"1396	ΚΑΤΗΓΟΡΙΑ 4.3	Αλουμίνιο σε";
mostCurrent._clv2._addtextitem /*String*/ ("1396	ΚΑΤΗΓΟΡΙΑ 4.3	Αλουμίνιο σε σκόνη, χωρίς επικάλυψη	      ",(Object)(""));
 //BA.debugLineNum = 202;BA.debugLine="clv2.AddTextItem(\"1397	ΚΑΤΗΓΟΡΙΑ 4.3	Φωσφορούχο αρ";
mostCurrent._clv2._addtextitem /*String*/ ("1397	ΚΑΤΗΓΟΡΙΑ 4.3	Φωσφορούχο αργίλιο	      ",(Object)(""));
 //BA.debugLineNum = 203;BA.debugLine="clv2.AddTextItem(\"1398	ΚΑΤΗΓΟΡΙΑ 4.3	Αλουμινίου πυ";
mostCurrent._clv2._addtextitem /*String*/ ("1398	ΚΑΤΗΓΟΡΙΑ 4.3	Αλουμινίου πυριτίου σε σκόνη, χωρίς επικάλυψη	      ",(Object)(""));
 //BA.debugLineNum = 204;BA.debugLine="clv2.AddTextItem(\"1400	ΚΑΤΗΓΟΡΙΑ 4.3	Βάριο	    \"";
mostCurrent._clv2._addtextitem /*String*/ ("1400	ΚΑΤΗΓΟΡΙΑ 4.3	Βάριο	    ",(Object)(""));
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 285;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 286;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 288;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 290;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 239;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 240;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 235;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 237;BA.debugLine="End Sub";
return "";
}
public static String  _clv1_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 208;BA.debugLine="Sub clv1_ItemClick (Index As Int, Value As Object)";
 //BA.debugLineNum = 209;BA.debugLine="Activity.Title = Value";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _createlistitem(String _text,int _width,int _height) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.ButtonWrapper _b = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 212;BA.debugLine="Sub CreateListItem(Text As String, Width As Int, H";
 //BA.debugLineNum = 213;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 214;BA.debugLine="p.Initialize(\"\")";
_p.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 215;BA.debugLine="p.Color = Colors.Black";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 216;BA.debugLine="Dim b As Button";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 217;BA.debugLine="b.Initialize(\"button\") 'all buttons click events";
_b.Initialize(mostCurrent.activityBA,"button");
 //BA.debugLineNum = 218;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 219;BA.debugLine="chk.Initialize(\"\")";
_chk.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 220;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 221;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 222;BA.debugLine="lbl.Gravity = Bit.OR(Gravity.CENTER_VERTICAL, Gra";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL,anywheresoftware.b4a.keywords.Common.Gravity.LEFT));
 //BA.debugLineNum = 223;BA.debugLine="lbl.Text = Text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 224;BA.debugLine="lbl.TextSize = 16";
_lbl.setTextSize((float) (16));
 //BA.debugLineNum = 225;BA.debugLine="lbl.TextColor = Colors.White";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 226;BA.debugLine="b.Text = \"Click\"";
_b.setText(BA.ObjectToCharSequence("Click"));
 //BA.debugLineNum = 227;BA.debugLine="p.AddView(lbl, 5dip, 2dip, 150dip, Height - 4dip)";
_p.AddView((android.view.View)(_lbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),(int) (_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 //BA.debugLineNum = 228;BA.debugLine="p.AddView(b, 155dip, 2dip, 110dip, Height - 4dip)";
_p.AddView((android.view.View)(_b.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (155)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)),(int) (_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 //BA.debugLineNum = 229;BA.debugLine="p.AddView(chk, 280dip, 2dip, 50dip, Height - 4dip";
_p.AddView((android.view.View)(_chk.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 //BA.debugLineNum = 230;BA.debugLine="Return p";
if (true) return _p;
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim sc As ScrollView";
mostCurrent._sc = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Dim ili As Button";
mostCurrent._ili = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Dim ousia As Button";
mostCurrent._ousia = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Dim simansi As Button";
mostCurrent._simansi = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim pixi As Button";
mostCurrent._pixi = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Dim lista As Button";
mostCurrent._lista = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private katigor As Button";
mostCurrent._katigor = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Dim fakos As Label";
mostCurrent._fakos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private mple As ImageView";
mostCurrent._mple = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private simanseislabel As Label";
mostCurrent._simanseislabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private listabel As Label";
mostCurrent._listabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private katigorlabel As Label";
mostCurrent._katigorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private ousialabel As Label";
mostCurrent._ousialabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private ililabel As Label";
mostCurrent._ililabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Dim Panel As Panel";
mostCurrent._panel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Dim clv2 As CustomListView";
mostCurrent._clv2 = new firefighter.companion.customlistview();
 //BA.debugLineNum = 39;BA.debugLine="Dim Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public static String  _gpss_click() throws Exception{
 //BA.debugLineNum = 259;BA.debugLine="Sub gpss_Click";
 //BA.debugLineNum = 261;BA.debugLine="StartActivity(\"gpssingal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssingal"));
 //BA.debugLineNum = 262;BA.debugLine="End Sub";
return "";
}
public static String  _ili_click() throws Exception{
 //BA.debugLineNum = 242;BA.debugLine="Sub ili_Click";
 //BA.debugLineNum = 243;BA.debugLine="StartActivity(\"ilika\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ilika"));
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
 //BA.debugLineNum = 276;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 277;BA.debugLine="StartActivity(\"ilika\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ilika"));
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return "";
}
public static String  _katigor_click() throws Exception{
 //BA.debugLineNum = 256;BA.debugLine="Sub katigor_Click";
 //BA.debugLineNum = 257;BA.debugLine="StartActivity(\"katigoriess\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("katigoriess"));
 //BA.debugLineNum = 258;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 270;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 271;BA.debugLine="StartActivity(\"katigoriess\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("katigoriess"));
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
return "";
}
public static String  _lista_click() throws Exception{
 //BA.debugLineNum = 252;BA.debugLine="Sub lista_Click";
 //BA.debugLineNum = 253;BA.debugLine="StartActivity(\"listaousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("listaousies"));
 //BA.debugLineNum = 254;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 267;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 268;BA.debugLine="StartActivity(\"listaousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("listaousies"));
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public static String  _ousia_click() throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Sub ousia_Click";
 //BA.debugLineNum = 246;BA.debugLine="StartActivity(\"ousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ousies"));
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 273;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 274;BA.debugLine="StartActivity(\"ousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ousies"));
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return "";
}
public static String  _pixi_click() throws Exception{
 //BA.debugLineNum = 248;BA.debugLine="Sub pixi_Click";
 //BA.debugLineNum = 249;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 264;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 265;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 //BA.debugLineNum = 266;BA.debugLine="End Sub";
return "";
}
public static String  _simansi_click() throws Exception{
 //BA.debugLineNum = 280;BA.debugLine="Sub simansi_Click";
 //BA.debugLineNum = 281;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 //BA.debugLineNum = 282;BA.debugLine="End Sub";
return "";
}
}
