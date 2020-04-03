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

public class xilia600 extends Activity implements B4AActivity{
	public static xilia600 mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.xilia600");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (xilia600).");
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
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.xilia600");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.xilia600", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (xilia600) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (xilia600) Resume **");
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
		return xilia600.class;
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
        BA.LogInfo("** Activity (xilia600) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            xilia600 mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (xilia600) Resume **");
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
public firefighter.companion.xilia400 _xilia400 = null;
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
 //BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 46;BA.debugLine="Activity.LoadLayout(\"adr.bal\")";
mostCurrent._activity.LoadLayout("adr.bal",mostCurrent.activityBA);
 //BA.debugLineNum = 51;BA.debugLine="simanseislabel.Top = 3%y";
mostCurrent._simanseislabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 52;BA.debugLine="simanseislabel.left = 3.5%x";
mostCurrent._simanseislabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3.5),mostCurrent.activityBA));
 //BA.debugLineNum = 53;BA.debugLine="simanseislabel.height = 27.5%y";
mostCurrent._simanseislabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (27.5),mostCurrent.activityBA));
 //BA.debugLineNum = 54;BA.debugLine="simanseislabel.Width  = 45%x";
mostCurrent._simanseislabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 55;BA.debugLine="simansi.Top = 3%y";
mostCurrent._simansi.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 56;BA.debugLine="simansi.left = 3%x";
mostCurrent._simansi.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 57;BA.debugLine="simansi.height = 28%y";
mostCurrent._simansi.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (28),mostCurrent.activityBA));
 //BA.debugLineNum = 58;BA.debugLine="simansi.Width  = 45%x";
mostCurrent._simansi.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 63;BA.debugLine="lista.Top = 3%y";
mostCurrent._lista.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 64;BA.debugLine="lista.left = 51.5%x";
mostCurrent._lista.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.5),mostCurrent.activityBA));
 //BA.debugLineNum = 65;BA.debugLine="lista.height = 13%y";
mostCurrent._lista.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 66;BA.debugLine="lista.Width  = 21.25%x";
mostCurrent._lista.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 68;BA.debugLine="listabel.Top = 3%y";
mostCurrent._listabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 69;BA.debugLine="listabel.left = 51.75%x";
mostCurrent._listabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 70;BA.debugLine="listabel.height = 13%y";
mostCurrent._listabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 71;BA.debugLine="listabel.Width  = 21.25%x";
mostCurrent._listabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 75;BA.debugLine="katigor.Top = 18%y";
mostCurrent._katigor.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 76;BA.debugLine="katigor.left = 51.50%x";
mostCurrent._katigor.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.50),mostCurrent.activityBA));
 //BA.debugLineNum = 77;BA.debugLine="katigor.height = 13%y";
mostCurrent._katigor.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 78;BA.debugLine="katigor.Width  = 21.25%x";
mostCurrent._katigor.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 80;BA.debugLine="katigorlabel.Top = 18%y";
mostCurrent._katigorlabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 81;BA.debugLine="katigorlabel.left = 51.75%x";
mostCurrent._katigorlabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 82;BA.debugLine="katigorlabel.height = 13%y";
mostCurrent._katigorlabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 83;BA.debugLine="katigorlabel.Width  = 21.25%x";
mostCurrent._katigorlabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 85;BA.debugLine="ousia.Top = 3%y";
mostCurrent._ousia.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 86;BA.debugLine="ousia.left = 75.75%x";
mostCurrent._ousia.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75.75),mostCurrent.activityBA));
 //BA.debugLineNum = 87;BA.debugLine="ousia.height = 13%y";
mostCurrent._ousia.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 88;BA.debugLine="ousia.Width  = 21.25%x";
mostCurrent._ousia.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 89;BA.debugLine="ousialabel.Top = 3%y";
mostCurrent._ousialabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 90;BA.debugLine="ousialabel.left = 76%x";
mostCurrent._ousialabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 91;BA.debugLine="ousialabel.height = 13%y";
mostCurrent._ousialabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 92;BA.debugLine="ousialabel.Width  = 21.25%x";
mostCurrent._ousialabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 94;BA.debugLine="ili.Top = 18%y";
mostCurrent._ili.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 95;BA.debugLine="ili.left = 75.75%x";
mostCurrent._ili.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75.75),mostCurrent.activityBA));
 //BA.debugLineNum = 96;BA.debugLine="ili.height = 13%y";
mostCurrent._ili.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 97;BA.debugLine="ili.Width  = 21.25%x";
mostCurrent._ili.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 98;BA.debugLine="ililabel.Top = 18%y";
mostCurrent._ililabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 99;BA.debugLine="ililabel.left = 76%x";
mostCurrent._ililabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 100;BA.debugLine="ililabel.height = 13%y";
mostCurrent._ililabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 101;BA.debugLine="ililabel.Width  = 21.25%x";
mostCurrent._ililabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 104;BA.debugLine="mple.top = 93%y";
mostCurrent._mple.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (93),mostCurrent.activityBA));
 //BA.debugLineNum = 105;BA.debugLine="mple.left = 3%x";
mostCurrent._mple.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 106;BA.debugLine="mple.width = 94%x";
mostCurrent._mple.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 107;BA.debugLine="mple.height = 7%y";
mostCurrent._mple.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (7),mostCurrent.activityBA));
 //BA.debugLineNum = 119;BA.debugLine="clv2.Initialize(Me, \"clv2\")";
mostCurrent._clv2._initialize /*String*/ (mostCurrent.activityBA,xilia600.getObject(),"clv2");
 //BA.debugLineNum = 120;BA.debugLine="Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y";
mostCurrent._panel2.AddView((android.view.View)(mostCurrent._clv2._asview /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ ().getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 121;BA.debugLine="Panel2.Top = 33%y";
mostCurrent._panel2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA));
 //BA.debugLineNum = 122;BA.debugLine="Panel2.Left = 3%x";
mostCurrent._panel2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 123;BA.debugLine="Panel2.Width = 94%x";
mostCurrent._panel2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 124;BA.debugLine="Panel2.Height = 57.5%y";
mostCurrent._panel2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 125;BA.debugLine="clv2.DefaultTextBackgroundColor = Colors.DarkGray";
mostCurrent._clv2._defaulttextbackgroundcolor /*int*/  = anywheresoftware.b4a.keywords.Common.Colors.DarkGray;
 //BA.debugLineNum = 128;BA.debugLine="clv2.AddTextItem(\"1502	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερχλωρικό ν";
mostCurrent._clv2._addtextitem /*String*/ ("1502	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερχλωρικό νάτριο	   ",(Object)(""));
 //BA.debugLineNum = 129;BA.debugLine="clv2.AddTextItem(\"1503	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερμαγγανικό";
mostCurrent._clv2._addtextitem /*String*/ ("1503	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερμαγγανικό νάτριο	   ",(Object)(""));
 //BA.debugLineNum = 130;BA.debugLine="clv2.AddTextItem(\"1504	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο";
mostCurrent._clv2._addtextitem /*String*/ ("1504	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο  νατρίου	   ",(Object)(""));
 //BA.debugLineNum = 131;BA.debugLine="clv2.AddTextItem(\"1505	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερθετικό νά";
mostCurrent._clv2._addtextitem /*String*/ ("1505	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερθετικό νάτριο	      ",(Object)(""));
 //BA.debugLineNum = 132;BA.debugLine="clv2.AddTextItem(\"1506	ΚΑΤΗΓΟΡΙΑ 5.1	Στρόντιο χλωρ";
mostCurrent._clv2._addtextitem /*String*/ ("1506	ΚΑΤΗΓΟΡΙΑ 5.1	Στρόντιο χλωρικό	      ",(Object)(""));
 //BA.debugLineNum = 133;BA.debugLine="clv2.AddTextItem(\"1507	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό στρόν";
mostCurrent._clv2._addtextitem /*String*/ ("1507	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό στρόντιο	      ",(Object)(""));
 //BA.debugLineNum = 134;BA.debugLine="clv2.AddTextItem(\"1508	ΚΑΤΗΓΟΡΙΑ 5.1	Στρόντιο υπερ";
mostCurrent._clv2._addtextitem /*String*/ ("1508	ΚΑΤΗΓΟΡΙΑ 5.1	Στρόντιο υπερχλωρικό	   ",(Object)(""));
 //BA.debugLineNum = 135;BA.debugLine="clv2.AddTextItem(\"1509	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο";
mostCurrent._clv2._addtextitem /*String*/ ("1509	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο  στροντίου	   ",(Object)(""));
 //BA.debugLineNum = 136;BA.debugLine="clv2.AddTextItem(\"1510	ΚΑΤΗΓΟΡΙΑ 5.1	Τετρανιτρομεθ";
mostCurrent._clv2._addtextitem /*String*/ ("1510	ΚΑΤΗΓΟΡΙΑ 5.1	Τετρανιτρομεθανίου	      ",(Object)(""));
 //BA.debugLineNum = 137;BA.debugLine="clv2.AddTextItem(\"1511	ΚΑΤΗΓΟΡΙΑ 5.1	Ουρία υπεροξε";
mostCurrent._clv2._addtextitem /*String*/ ("1511	ΚΑΤΗΓΟΡΙΑ 5.1	Ουρία υπεροξείδιο  υδρογόνου	      ",(Object)(""));
 //BA.debugLineNum = 138;BA.debugLine="clv2.AddTextItem(\"1512	ΚΑΤΗΓΟΡΙΑ 5.1	Ψευδάργυρος ν";
mostCurrent._clv2._addtextitem /*String*/ ("1512	ΚΑΤΗΓΟΡΙΑ 5.1	Ψευδάργυρος νιτρώδες αμμώνιο	   ",(Object)(""));
 //BA.debugLineNum = 139;BA.debugLine="clv2.AddTextItem(\"1513	ΚΑΤΗΓΟΡΙΑ 5.1	Χλωρικό ψευδα";
mostCurrent._clv2._addtextitem /*String*/ ("1513	ΚΑΤΗΓΟΡΙΑ 5.1	Χλωρικό ψευδαργύρου	      ",(Object)(""));
 //BA.debugLineNum = 140;BA.debugLine="clv2.AddTextItem(\"1514	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικού ψευδ";
mostCurrent._clv2._addtextitem /*String*/ ("1514	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικού ψευδαργύρου	      ",(Object)(""));
 //BA.debugLineNum = 141;BA.debugLine="clv2.AddTextItem(\"1515	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερμαγγανικό";
mostCurrent._clv2._addtextitem /*String*/ ("1515	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερμαγγανικό ψευδαργύρου	      ",(Object)(""));
 //BA.debugLineNum = 142;BA.debugLine="clv2.AddTextItem(\"1516	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο";
mostCurrent._clv2._addtextitem /*String*/ ("1516	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο  ψευδαργύρου	      ",(Object)(""));
 //BA.debugLineNum = 143;BA.debugLine="clv2.AddTextItem(\"1517	ΚΑΤΗΓΟΡΙΑ 4.1	Ζιρκόνιο picr";
mostCurrent._clv2._addtextitem /*String*/ ("1517	ΚΑΤΗΓΟΡΙΑ 4.1	Ζιρκόνιο picramate    ",(Object)(""));
 //BA.debugLineNum = 144;BA.debugLine="clv2.AddTextItem(\"1541	ΚΑΤΗΓΟΡΙΑ 6.1	Ακετόνη κυανο";
mostCurrent._clv2._addtextitem /*String*/ ("1541	ΚΑΤΗΓΟΡΙΑ 6.1	Ακετόνη κυανοϋδρίνης , σταθεροποιημένο	   ",(Object)(""));
 //BA.debugLineNum = 145;BA.debugLine="clv2.AddTextItem(\"1544	ΚΑΤΗΓΟΡΙΑ 6.1	Αλκαλοειδή";
mostCurrent._clv2._addtextitem /*String*/ ("1544	ΚΑΤΗΓΟΡΙΑ 6.1	Αλκαλοειδή       ",(Object)(""));
 //BA.debugLineNum = 146;BA.debugLine="clv2.AddTextItem(\"1545	ΚΑΤΗΓΟΡΙΑ 6.1	ΙΣΟΘΕΙΟΚΥΑΝΙΚ";
mostCurrent._clv2._addtextitem /*String*/ ("1545	ΚΑΤΗΓΟΡΙΑ 6.1	ΙΣΟΘΕΙΟΚΥΑΝΙΚΟ ΑΛΛΥΛΙΟ , σταθεροποιημένο	      ",(Object)(""));
 //BA.debugLineNum = 147;BA.debugLine="clv2.AddTextItem(\"1546	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικό αμ";
mostCurrent._clv2._addtextitem /*String*/ ("1546	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικό αμμώνιο	      ",(Object)(""));
 //BA.debugLineNum = 148;BA.debugLine="clv2.AddTextItem(\"1547	ΚΑΤΗΓΟΡΙΑ 6.1	Ανιλίνη";
mostCurrent._clv2._addtextitem /*String*/ ("1547	ΚΑΤΗΓΟΡΙΑ 6.1	Ανιλίνη	      ",(Object)(""));
 //BA.debugLineNum = 149;BA.debugLine="clv2.AddTextItem(\"1548	ΚΑΤΗΓΟΡΙΑ 6.1	Ανιλίνης";
mostCurrent._clv2._addtextitem /*String*/ ("1548	ΚΑΤΗΓΟΡΙΑ 6.1	Ανιλίνης	      ",(Object)(""));
 //BA.debugLineNum = 150;BA.debugLine="clv2.AddTextItem(\"1549	ΚΑΤΗΓΟΡΙΑ 6.1	Αντιμόνιο ενώ";
mostCurrent._clv2._addtextitem /*String*/ ("1549	ΚΑΤΗΓΟΡΙΑ 6.1	Αντιμόνιο ενώσεις, ανόργανες, στερεά, 	      ",(Object)(""));
 //BA.debugLineNum = 151;BA.debugLine="clv2.AddTextItem(\"1550	ΚΑΤΗΓΟΡΙΑ 6.1	Αντιμονίου γα";
mostCurrent._clv2._addtextitem /*String*/ ("1550	ΚΑΤΗΓΟΡΙΑ 6.1	Αντιμονίου γαλακτικό	   ",(Object)(""));
 //BA.debugLineNum = 152;BA.debugLine="clv2.AddTextItem(\"1551	ΚΑΤΗΓΟΡΙΑ 6.1	Αντιμόνιο τρυ";
mostCurrent._clv2._addtextitem /*String*/ ("1551	ΚΑΤΗΓΟΡΙΑ 6.1	Αντιμόνιο τρυγικό κάλιο	   ",(Object)(""));
 //BA.debugLineNum = 153;BA.debugLine="clv2.AddTextItem(\"1553	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό οξύ";
mostCurrent._clv2._addtextitem /*String*/ ("1553	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό οξύ , υγρό	      ",(Object)(""));
 //BA.debugLineNum = 154;BA.debugLine="clv2.AddTextItem(\"1554	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό οξύ,";
mostCurrent._clv2._addtextitem /*String*/ ("1554	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό οξύ, στερεό	   ",(Object)(""));
 //BA.debugLineNum = 155;BA.debugLine="clv2.AddTextItem(\"1555	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό βρωμ";
mostCurrent._clv2._addtextitem /*String*/ ("1555	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό βρωμιούχο	   ",(Object)(""));
 //BA.debugLineNum = 156;BA.debugLine="clv2.AddTextItem(\"1556	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό ενώσ";
mostCurrent._clv2._addtextitem /*String*/ ("1556	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό ενώσεις	      ",(Object)(""));
 //BA.debugLineNum = 157;BA.debugLine="clv2.AddTextItem(\"1557	ΚΑΤΗΓΟΡΙΑ 6.1	Ενώσεις αρσεν";
mostCurrent._clv2._addtextitem /*String*/ ("1557	ΚΑΤΗΓΟΡΙΑ 6.1	Ενώσεις αρσενικού,   ",(Object)(""));
 //BA.debugLineNum = 158;BA.debugLine="clv2.AddTextItem(\"1558	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό";
mostCurrent._clv2._addtextitem /*String*/ ("1558	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό	      ",(Object)(""));
 //BA.debugLineNum = 159;BA.debugLine="clv2.AddTextItem(\"1559 	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό πεν";
mostCurrent._clv2._addtextitem /*String*/ ("1559 	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό πεντοξείδιο	   ",(Object)(""));
 //BA.debugLineNum = 160;BA.debugLine="clv2.AddTextItem(\"1560	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό τριχ";
mostCurrent._clv2._addtextitem /*String*/ ("1560	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό τριχλωριούχου	   ",(Object)(""));
 //BA.debugLineNum = 161;BA.debugLine="clv2.AddTextItem(\"1561	ΚΑΤΗΓΟΡΙΑ 6.1	Τριοξείδιο  α";
mostCurrent._clv2._addtextitem /*String*/ ("1561	ΚΑΤΗΓΟΡΙΑ 6.1	Τριοξείδιο  αρσενικού   ",(Object)(""));
 //BA.debugLineNum = 162;BA.debugLine="clv2.AddTextItem(\"1562	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικού σκό";
mostCurrent._clv2._addtextitem /*String*/ ("1562	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικού σκόνη	      ",(Object)(""));
 //BA.debugLineNum = 163;BA.debugLine="clv2.AddTextItem(\"1564	ΚΑΤΗΓΟΡΙΑ 6.1	Βαρίου ενώσει";
mostCurrent._clv2._addtextitem /*String*/ ("1564	ΚΑΤΗΓΟΡΙΑ 6.1	Βαρίου ενώσεις, 	      ",(Object)(""));
 //BA.debugLineNum = 164;BA.debugLine="clv2.AddTextItem(\"1565	ΚΑΤΗΓΟΡΙΑ 6.1	Βάριο κυανίου";
mostCurrent._clv2._addtextitem /*String*/ ("1565	ΚΑΤΗΓΟΡΙΑ 6.1	Βάριο κυανίου	      ",(Object)(""));
 //BA.debugLineNum = 165;BA.debugLine="clv2.AddTextItem(\"1566	ΚΑΤΗΓΟΡΙΑ 6.1	Βηρυλλίου ενώ";
mostCurrent._clv2._addtextitem /*String*/ ("1566	ΚΑΤΗΓΟΡΙΑ 6.1	Βηρυλλίου ενώσεις, 	      ",(Object)(""));
 //BA.debugLineNum = 166;BA.debugLine="clv2.AddTextItem(\"1567	ΚΑΤΗΓΟΡΙΑ 6.1	Βηρύλλιο, σκό";
mostCurrent._clv2._addtextitem /*String*/ ("1567	ΚΑΤΗΓΟΡΙΑ 6.1	Βηρύλλιο, σκόνη	      ",(Object)(""));
 //BA.debugLineNum = 167;BA.debugLine="clv2.AddTextItem(\"1569	ΚΑΤΗΓΟΡΙΑ 6.1	Βρωμοακετόνη";
mostCurrent._clv2._addtextitem /*String*/ ("1569	ΚΑΤΗΓΟΡΙΑ 6.1	Βρωμοακετόνη	      ",(Object)(""));
 //BA.debugLineNum = 168;BA.debugLine="clv2.AddTextItem(\"1570	ΚΑΤΗΓΟΡΙΑ 6.1	Βρυκίνης";
mostCurrent._clv2._addtextitem /*String*/ ("1570	ΚΑΤΗΓΟΡΙΑ 6.1	Βρυκίνης	      ",(Object)(""));
 //BA.debugLineNum = 169;BA.debugLine="clv2.AddTextItem(\"1571	ΚΑΤΗΓΟΡΙΑ 4.1	Το αζίδιο  βα";
mostCurrent._clv2._addtextitem /*String*/ ("1571	ΚΑΤΗΓΟΡΙΑ 4.1	Το αζίδιο  βαρίου , βρεγμένο	      ",(Object)(""));
 //BA.debugLineNum = 170;BA.debugLine="clv2.AddTextItem(\"1572	ΚΑΤΗΓΟΡΙΑ 6.1	Κακωδυλικού ο";
mostCurrent._clv2._addtextitem /*String*/ ("1572	ΚΑΤΗΓΟΡΙΑ 6.1	Κακωδυλικού οξύ	      ",(Object)(""));
 //BA.debugLineNum = 171;BA.debugLine="clv2.AddTextItem(\"1573	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό ασβέ";
mostCurrent._clv2._addtextitem /*String*/ ("1573	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό ασβέστιο	      ",(Object)(""));
 //BA.debugLineNum = 172;BA.debugLine="clv2.AddTextItem(\"1574	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό ασβέ";
mostCurrent._clv2._addtextitem /*String*/ ("1574	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό ασβέστιο και arsenite ασβέστιο , μίγματα, στερεά	      ",(Object)(""));
 //BA.debugLineNum = 173;BA.debugLine="clv2.AddTextItem(\"1575	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχο ασβ";
mostCurrent._clv2._addtextitem /*String*/ ("1575	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχο ασβέστιο	      ",(Object)(""));
 //BA.debugLineNum = 174;BA.debugLine="clv2.AddTextItem(\"1577	ΚΑΤΗΓΟΡΙΑ 6.1	Chlorodinitro";
mostCurrent._clv2._addtextitem /*String*/ ("1577	ΚΑΤΗΓΟΡΙΑ 6.1	Chlorodinitrobenzenes	      ",(Object)(""));
 //BA.debugLineNum = 175;BA.debugLine="clv2.AddTextItem(\"1578	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωρονιτροβεν";
mostCurrent._clv2._addtextitem /*String*/ ("1578	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωρονιτροβενζόλιο , όρθο, υγρό	      ",(Object)(""));
 //BA.debugLineNum = 176;BA.debugLine="clv2.AddTextItem(\"1579	ΚΑΤΗΓΟΡΙΑ 6.1	Xλωρο-ο-τολου";
mostCurrent._clv2._addtextitem /*String*/ ("1579	ΚΑΤΗΓΟΡΙΑ 6.1	Xλωρο-ο-τολουϊδίνης υδροχλωρική	      ",(Object)(""));
 //BA.debugLineNum = 177;BA.debugLine="clv2.AddTextItem(\"1580	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροπικρίνη";
mostCurrent._clv2._addtextitem /*String*/ ("1580	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροπικρίνη	      ",(Object)(""));
 //BA.debugLineNum = 178;BA.debugLine="clv2.AddTextItem(\"1581	ΚΑΤΗΓΟΡΙΑ 2	Χλωροπικρίνης κ";
mostCurrent._clv2._addtextitem /*String*/ ("1581	ΚΑΤΗΓΟΡΙΑ 2	Χλωροπικρίνης και βρωμιούχου μεθυλίου μείγματα	      ",(Object)(""));
 //BA.debugLineNum = 179;BA.debugLine="clv2.AddTextItem(\"1582	ΚΑΤΗΓΟΡΙΑ 2	Χλωροπικρίνης κ";
mostCurrent._clv2._addtextitem /*String*/ ("1582	ΚΑΤΗΓΟΡΙΑ 2	Χλωροπικρίνης και χλωριούχου μεθυλίου μείγματα	    ",(Object)(""));
 //BA.debugLineNum = 180;BA.debugLine="clv2.AddTextItem(\"1583	ΚΑΤΗΓΟΡΙΑ 6.1	Μείγματα Χλωρ";
mostCurrent._clv2._addtextitem /*String*/ ("1583	ΚΑΤΗΓΟΡΙΑ 6.1	Μείγματα Χλωροπικρίνη, 	      ",(Object)(""));
 //BA.debugLineNum = 181;BA.debugLine="clv2.AddTextItem(\"1585	ΚΑΤΗΓΟΡΙΑ 6.1	Acetoarsenite";
mostCurrent._clv2._addtextitem /*String*/ ("1585	ΚΑΤΗΓΟΡΙΑ 6.1	Acetoarsenite χαλκού	      ",(Object)(""));
 //BA.debugLineNum = 182;BA.debugLine="clv2.AddTextItem(\"1586	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικώδου";
mostCurrent._clv2._addtextitem /*String*/ ("1586	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικώδους χαλκού	       ",(Object)(""));
 //BA.debugLineNum = 183;BA.debugLine="clv2.AddTextItem(\"1587	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχου χα";
mostCurrent._clv2._addtextitem /*String*/ ("1587	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχου χαλκού	      ",(Object)(""));
 //BA.debugLineNum = 184;BA.debugLine="clv2.AddTextItem(\"1588	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανίδια , αν";
mostCurrent._clv2._addtextitem /*String*/ ("1588	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανίδια , ανόργανα, στερεά, 	      ",(Object)(""));
 //BA.debugLineNum = 185;BA.debugLine="clv2.AddTextItem(\"1589	ΚΑΤΗΓΟΡΙΑ 2	Χλωριούχο κυάνι";
mostCurrent._clv2._addtextitem /*String*/ ("1589	ΚΑΤΗΓΟΡΙΑ 2	Χλωριούχο κυάνιο 	      ",(Object)(""));
 //BA.debugLineNum = 186;BA.debugLine="clv2.AddTextItem(\"1590	ΚΑΤΗΓΟΡΙΑ 6.1	Dichloroanili";
mostCurrent._clv2._addtextitem /*String*/ ("1590	ΚΑΤΗΓΟΡΙΑ 6.1	Dichloroanilines      ",(Object)(""));
 //BA.debugLineNum = 187;BA.debugLine="clv2.AddTextItem(\"1591	ΚΑΤΗΓΟΡΙΑ 6.1	Oδιχλωροβενζό";
mostCurrent._clv2._addtextitem /*String*/ ("1591	ΚΑΤΗΓΟΡΙΑ 6.1	Oδιχλωροβενζόλιο	      ",(Object)(""));
 //BA.debugLineNum = 188;BA.debugLine="clv2.AddTextItem(\"1593	ΚΑΤΗΓΟΡΙΑ 6.1	Διχλωρομεθάνι";
mostCurrent._clv2._addtextitem /*String*/ ("1593	ΚΑΤΗΓΟΡΙΑ 6.1	Διχλωρομεθάνιο	      ",(Object)(""));
 //BA.debugLineNum = 189;BA.debugLine="clv2.AddTextItem(\"1594	ΚΑΤΗΓΟΡΙΑ 6.1	Θειικό διαιθύ";
mostCurrent._clv2._addtextitem /*String*/ ("1594	ΚΑΤΗΓΟΡΙΑ 6.1	Θειικό διαιθύλιο	      ",(Object)(""));
 //BA.debugLineNum = 190;BA.debugLine="clv2.AddTextItem(\"1595	ΚΑΤΗΓΟΡΙΑ 6.1	Θειικό διμεθύ";
mostCurrent._clv2._addtextitem /*String*/ ("1595	ΚΑΤΗΓΟΡΙΑ 6.1	Θειικό διμεθύλιο	      ",(Object)(""));
 //BA.debugLineNum = 191;BA.debugLine="clv2.AddTextItem(\"1596	ΚΑΤΗΓΟΡΙΑ 6.1	Δινιτροανιλίν";
mostCurrent._clv2._addtextitem /*String*/ ("1596	ΚΑΤΗΓΟΡΙΑ 6.1	Δινιτροανιλίνες	      ",(Object)(""));
 //BA.debugLineNum = 192;BA.debugLine="clv2.AddTextItem(\"1597	ΚΑΤΗΓΟΡΙΑ 6.1	Dinitrobenzen";
mostCurrent._clv2._addtextitem /*String*/ ("1597	ΚΑΤΗΓΟΡΙΑ 6.1	Dinitrobenzenes , υγρό ή Dinitrobenzenes, στερεά	      ",(Object)(""));
 //BA.debugLineNum = 193;BA.debugLine="clv2.AddTextItem(\"1598	ΚΑΤΗΓΟΡΙΑ 6.1	Δινιτρο-ο-κρε";
mostCurrent._clv2._addtextitem /*String*/ ("1598	ΚΑΤΗΓΟΡΙΑ 6.1	Δινιτρο-ο-κρεζόλη , στερεά ή Dintro-ο-κρεζόλη, διάλυμα   ",(Object)(""));
 //BA.debugLineNum = 194;BA.debugLine="clv2.AddTextItem(\"1599	ΚΑΤΗΓΟΡΙΑ 6.1	Δινιτροφαινόλ";
mostCurrent._clv2._addtextitem /*String*/ ("1599	ΚΑΤΗΓΟΡΙΑ 6.1	Δινιτροφαινόλη	      ",(Object)(""));
 //BA.debugLineNum = 195;BA.debugLine="clv2.AddTextItem(\"1600	ΚΑΤΗΓΟΡΙΑ 6.1	Dinitrotolue";
mostCurrent._clv2._addtextitem /*String*/ ("1600	ΚΑΤΗΓΟΡΙΑ 6.1	Dinitrotoluenes	    ",(Object)(""));
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 280;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 281;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 283;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 232;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 233;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 228;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public static String  _clv1_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 201;BA.debugLine="Sub clv1_ItemClick (Index As Int, Value As Object)";
 //BA.debugLineNum = 202;BA.debugLine="Activity.Title = Value";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _createlistitem(String _text,int _width,int _height) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.ButtonWrapper _b = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 205;BA.debugLine="Sub CreateListItem(Text As String, Width As Int, H";
 //BA.debugLineNum = 206;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 207;BA.debugLine="p.Initialize(\"\")";
_p.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 208;BA.debugLine="p.Color = Colors.Black";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 209;BA.debugLine="Dim b As Button";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 210;BA.debugLine="b.Initialize(\"button\") 'all buttons click events";
_b.Initialize(mostCurrent.activityBA,"button");
 //BA.debugLineNum = 211;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 212;BA.debugLine="chk.Initialize(\"\")";
_chk.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 213;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 214;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 215;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_VERTICAL, Gra";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL,anywheresoftware.b4a.keywords.Common.Gravity.LEFT));
 //BA.debugLineNum = 216;BA.debugLine="lbl.Text = Text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 217;BA.debugLine="lbl.TextSize = 16";
_lbl.setTextSize((float) (16));
 //BA.debugLineNum = 218;BA.debugLine="lbl.TextColor = Colors.White";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 219;BA.debugLine="b.Text = \"Click\"";
_b.setText(BA.ObjectToCharSequence("Click"));
 //BA.debugLineNum = 220;BA.debugLine="p.AddView(lbl, 5dip, 2dip, 150dip, Height - 4dip)";
_p.AddView((android.view.View)(_lbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),(int) (_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 //BA.debugLineNum = 221;BA.debugLine="p.AddView(b, 155dip, 2dip, 110dip, Height - 4dip)";
_p.AddView((android.view.View)(_b.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (155)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)),(int) (_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 //BA.debugLineNum = 222;BA.debugLine="p.AddView(chk, 280dip, 2dip, 50dip, Height - 4dip";
_p.AddView((android.view.View)(_chk.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 //BA.debugLineNum = 223;BA.debugLine="Return p";
if (true) return _p;
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 38;BA.debugLine="Dim Panel As Panel";
mostCurrent._panel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Dim clv2 As CustomListView";
mostCurrent._clv2 = new firefighter.companion.customlistview();
 //BA.debugLineNum = 42;BA.debugLine="Dim Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static String  _gpss_click() throws Exception{
 //BA.debugLineNum = 253;BA.debugLine="Sub gpss_Click";
 //BA.debugLineNum = 255;BA.debugLine="StartActivity(\"gpssingal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssingal"));
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return "";
}
public static String  _ili_click() throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Sub ili_Click";
 //BA.debugLineNum = 237;BA.debugLine="StartActivity(\"ilika\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ilika"));
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
 //BA.debugLineNum = 270;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 271;BA.debugLine="StartActivity(\"ilika\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ilika"));
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
return "";
}
public static String  _katigor_click() throws Exception{
 //BA.debugLineNum = 250;BA.debugLine="Sub katigor_Click";
 //BA.debugLineNum = 251;BA.debugLine="StartActivity(\"katigoriess\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("katigoriess"));
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 264;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 265;BA.debugLine="StartActivity(\"katigoriess\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("katigoriess"));
 //BA.debugLineNum = 266;BA.debugLine="End Sub";
return "";
}
public static String  _lista_click() throws Exception{
 //BA.debugLineNum = 246;BA.debugLine="Sub lista_Click";
 //BA.debugLineNum = 247;BA.debugLine="StartActivity(\"listaousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("listaousies"));
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 261;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 262;BA.debugLine="StartActivity(\"listaousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("listaousies"));
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return "";
}
public static String  _ousia_click() throws Exception{
 //BA.debugLineNum = 239;BA.debugLine="Sub ousia_Click";
 //BA.debugLineNum = 240;BA.debugLine="StartActivity(\"ousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ousies"));
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 267;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 268;BA.debugLine="StartActivity(\"ousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ousies"));
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public static String  _pixi_click() throws Exception{
 //BA.debugLineNum = 242;BA.debugLine="Sub pixi_Click";
 //BA.debugLineNum = 243;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 258;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 259;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
return "";
}
public static String  _simansi_click() throws Exception{
 //BA.debugLineNum = 274;BA.debugLine="Sub simansi_Click";
 //BA.debugLineNum = 275;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return "";
}
}