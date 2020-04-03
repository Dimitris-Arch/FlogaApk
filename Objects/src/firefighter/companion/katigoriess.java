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

public class katigoriess extends Activity implements B4AActivity{
	public static katigoriess mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.katigoriess");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (katigoriess).");
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
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.katigoriess");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.katigoriess", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (katigoriess) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (katigoriess) Resume **");
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
		return katigoriess.class;
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
        BA.LogInfo("** Activity (katigoriess) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            katigoriess mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (katigoriess) Resume **");
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
public static int _s = 0;
public anywheresoftware.b4a.objects.LabelWrapper _tgtlabel = null;
public static String[] _myarray = null;
public anywheresoftware.b4a.objects.LabelWrapper _katigo = null;
public anywheresoftware.b4a.objects.LabelWrapper _epilogi = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _searching = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _back1 = null;
public firefighter.companion.customlistview _clv2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
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
 //BA.debugLineNum = 58;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 59;BA.debugLine="Activity.LoadLayout(\"katigorrrr.bal\")";
mostCurrent._activity.LoadLayout("katigorrrr.bal",mostCurrent.activityBA);
 //BA.debugLineNum = 62;BA.debugLine="simanseislabel.Top = 3%y";
mostCurrent._simanseislabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 63;BA.debugLine="simanseislabel.left = 3.5%x";
mostCurrent._simanseislabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3.5),mostCurrent.activityBA));
 //BA.debugLineNum = 64;BA.debugLine="simanseislabel.height = 27.5%y";
mostCurrent._simanseislabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (27.5),mostCurrent.activityBA));
 //BA.debugLineNum = 65;BA.debugLine="simanseislabel.Width  = 45%x";
mostCurrent._simanseislabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 66;BA.debugLine="simansi.Top = 3%y";
mostCurrent._simansi.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 67;BA.debugLine="simansi.left = 3%x";
mostCurrent._simansi.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 68;BA.debugLine="simansi.height = 28%y";
mostCurrent._simansi.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (28),mostCurrent.activityBA));
 //BA.debugLineNum = 69;BA.debugLine="simansi.Width  = 45%x";
mostCurrent._simansi.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 74;BA.debugLine="lista.Top = 3%y";
mostCurrent._lista.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 75;BA.debugLine="lista.left = 51.5%x";
mostCurrent._lista.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.5),mostCurrent.activityBA));
 //BA.debugLineNum = 76;BA.debugLine="lista.height = 13%y";
mostCurrent._lista.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 77;BA.debugLine="lista.Width  = 21.25%x";
mostCurrent._lista.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 79;BA.debugLine="listabel.Top = 3%y";
mostCurrent._listabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 80;BA.debugLine="listabel.left = 51.75%x";
mostCurrent._listabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 81;BA.debugLine="listabel.height = 13%y";
mostCurrent._listabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 82;BA.debugLine="listabel.Width  = 21.25%x";
mostCurrent._listabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 86;BA.debugLine="katigor.Top = 18%y";
mostCurrent._katigor.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 87;BA.debugLine="katigor.left = 51.50%x";
mostCurrent._katigor.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.50),mostCurrent.activityBA));
 //BA.debugLineNum = 88;BA.debugLine="katigor.height = 13%y";
mostCurrent._katigor.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 89;BA.debugLine="katigor.Width  = 21.25%x";
mostCurrent._katigor.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 91;BA.debugLine="katigorlabel.Top = 18%y";
mostCurrent._katigorlabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 92;BA.debugLine="katigorlabel.left = 51.75%x";
mostCurrent._katigorlabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 93;BA.debugLine="katigorlabel.height = 13%y";
mostCurrent._katigorlabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 94;BA.debugLine="katigorlabel.Width  = 21.25%x";
mostCurrent._katigorlabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 96;BA.debugLine="ousia.Top = 3%y";
mostCurrent._ousia.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 97;BA.debugLine="ousia.left = 75.75%x";
mostCurrent._ousia.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75.75),mostCurrent.activityBA));
 //BA.debugLineNum = 98;BA.debugLine="ousia.height = 13%y";
mostCurrent._ousia.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 99;BA.debugLine="ousia.Width  = 21.25%x";
mostCurrent._ousia.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 100;BA.debugLine="ousialabel.Top = 3%y";
mostCurrent._ousialabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 101;BA.debugLine="ousialabel.left = 76%x";
mostCurrent._ousialabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 102;BA.debugLine="ousialabel.height = 13%y";
mostCurrent._ousialabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 103;BA.debugLine="ousialabel.Width  = 21.25%x";
mostCurrent._ousialabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 105;BA.debugLine="ili.Top = 18%y";
mostCurrent._ili.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 106;BA.debugLine="ili.left = 75.75%x";
mostCurrent._ili.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75.75),mostCurrent.activityBA));
 //BA.debugLineNum = 107;BA.debugLine="ili.height = 13%y";
mostCurrent._ili.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 108;BA.debugLine="ili.Width  = 21.25%x";
mostCurrent._ili.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 109;BA.debugLine="ililabel.Top = 18%y";
mostCurrent._ililabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 110;BA.debugLine="ililabel.left = 76%x";
mostCurrent._ililabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 111;BA.debugLine="ililabel.height = 13%y";
mostCurrent._ililabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 112;BA.debugLine="ililabel.Width  = 21.25%x";
mostCurrent._ililabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 115;BA.debugLine="mple.top = 93%y";
mostCurrent._mple.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (93),mostCurrent.activityBA));
 //BA.debugLineNum = 116;BA.debugLine="mple.left = 3%x";
mostCurrent._mple.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 117;BA.debugLine="mple.width = 94%x";
mostCurrent._mple.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 118;BA.debugLine="mple.height = 7%y";
mostCurrent._mple.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (7),mostCurrent.activityBA));
 //BA.debugLineNum = 126;BA.debugLine="clv2.Initialize(Me, \"clv2\")";
mostCurrent._clv2._initialize /*String*/ (mostCurrent.activityBA,katigoriess.getObject(),"clv2");
 //BA.debugLineNum = 127;BA.debugLine="Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y";
mostCurrent._panel2.AddView((android.view.View)(mostCurrent._clv2._asview /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ ().getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 128;BA.debugLine="Panel2.Top = 33%y";
mostCurrent._panel2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA));
 //BA.debugLineNum = 129;BA.debugLine="Panel2.Left = 3%x";
mostCurrent._panel2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 130;BA.debugLine="Panel2.Width = 94%x";
mostCurrent._panel2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 131;BA.debugLine="Panel2.Height = 57.5%y";
mostCurrent._panel2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 132;BA.debugLine="clv2.DefaultTextBackgroundColor = Colors.DarkGray";
mostCurrent._clv2._defaulttextbackgroundcolor /*int*/  = anywheresoftware.b4a.keywords.Common.Colors.DarkGray;
 //BA.debugLineNum = 133;BA.debugLine="clv2.AddTextItem(\"20 ασφυξιογόνο αέριο ή αέριο με";
mostCurrent._clv2._addtextitem /*String*/ ("20 ασφυξιογόνο αέριο ή αέριο με κανένα δευτερεύοντα κίνδυνο",(Object)(""));
 //BA.debugLineNum = 134;BA.debugLine="clv2.AddTextItem(\"22 υγροποιημένο αέριο υπό ψύξη,";
mostCurrent._clv2._addtextitem /*String*/ ("22 υγροποιημένο αέριο υπό ψύξη, ασφυξιογόνο",(Object)(""));
 //BA.debugLineNum = 135;BA.debugLine="clv2.AddTextItem(\"223 υγροποιημένο αέριο υπό ψύξη,";
mostCurrent._clv2._addtextitem /*String*/ ("223 υγροποιημένο αέριο υπό ψύξη, εύφλεκτο",(Object)(""));
 //BA.debugLineNum = 136;BA.debugLine="clv2.AddTextItem(\"225 υγροποιημένο αέριο υπό ψύξη,";
mostCurrent._clv2._addtextitem /*String*/ ("225 υγροποιημένο αέριο υπό ψύξη, οξειδωτικό (πυροδυναμωτικό)",(Object)(""));
 //BA.debugLineNum = 137;BA.debugLine="clv2.AddTextItem(\"23 εύφλεκτο αέριο\" ,\"\")";
mostCurrent._clv2._addtextitem /*String*/ ("23 εύφλεκτο αέριο",(Object)(""));
 //BA.debugLineNum = 138;BA.debugLine="clv2.AddTextItem(\"239 εύφλεκτο αέριο, που μπορεί α";
mostCurrent._clv2._addtextitem /*String*/ ("239 εύφλεκτο αέριο, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 139;BA.debugLine="clv2.AddTextItem(\"25 οξειδωτικό αέριο (πυροδυναμωτ";
mostCurrent._clv2._addtextitem /*String*/ ("25 οξειδωτικό αέριο (πυροδυναμωτικό)",(Object)(""));
 //BA.debugLineNum = 140;BA.debugLine="clv2.AddTextItem(\"26 τοξικό αέριο\" ,\"\")";
mostCurrent._clv2._addtextitem /*String*/ ("26 τοξικό αέριο",(Object)(""));
 //BA.debugLineNum = 141;BA.debugLine="clv2.AddTextItem(\"263 τοξικό αέριο, εύφλεκτο\" ,\"\")";
mostCurrent._clv2._addtextitem /*String*/ ("263 τοξικό αέριο, εύφλεκτο",(Object)(""));
 //BA.debugLineNum = 142;BA.debugLine="clv2.AddTextItem(\"265 τοξικό αέριο, οξειδωτικό (πυ";
mostCurrent._clv2._addtextitem /*String*/ ("265 τοξικό αέριο, οξειδωτικό (πυροδυναμωτικό)",(Object)(""));
 //BA.debugLineNum = 143;BA.debugLine="clv2.AddTextItem(\"268 τοξικό αέριο, διαβρωτικό\" ,\"";
mostCurrent._clv2._addtextitem /*String*/ ("268 τοξικό αέριο, διαβρωτικό",(Object)(""));
 //BA.debugLineNum = 144;BA.debugLine="clv2.AddTextItem(\"30 εύφλεκτο υγρό (με σημείο ανάφ";
mostCurrent._clv2._addtextitem /*String*/ ("30 εύφλεκτο υγρό (με σημείο ανάφλεξης μεταξύ 23°C και 60°C, συμπεριλαμβανομένου) ή εύφλεκτο υγρό ή στερεό σε τηγμένη μορφή με σημείο ανάφλεξης πάνω από τους 60°C, που έχει θερμανθεί σε θερμοκρασία ίση με ή πάνω από το σημείο ανάφλεξής του, ή αυτοθερμαινόμενο υγρό",(Object)(""));
 //BA.debugLineNum = 145;BA.debugLine="clv2.AddTextItem(\"323 εύφλεκτο υγρό που αντιδρά με";
mostCurrent._clv2._addtextitem /*String*/ ("323 εύφλεκτο υγρό που αντιδρά με το νερό και εκπέμπει εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 146;BA.debugLine="clv2.AddTextItem(\"Χ323 εύφλεκτο υγρό που αντιδρά ε";
mostCurrent._clv2._addtextitem /*String*/ ("Χ323 εύφλεκτο υγρό που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 147;BA.debugLine="clv2.AddTextItem(\"33 πολύ εύφλεκτο υγρό (σημείο αν";
mostCurrent._clv2._addtextitem /*String*/ ("33 πολύ εύφλεκτο υγρό (σημείο ανάφλεξης κάτω από 23°C)",(Object)(""));
 //BA.debugLineNum = 148;BA.debugLine="clv2.AddTextItem(\"333 πυροφορικό υγρό\" ,\"\")";
mostCurrent._clv2._addtextitem /*String*/ ("333 πυροφορικό υγρό",(Object)(""));
 //BA.debugLineNum = 149;BA.debugLine="clv2.AddTextItem(\"Χ333 πυροφορικό υγρό (ΑΠΑΓΟΡΕΥΕΤ";
mostCurrent._clv2._addtextitem /*String*/ ("Χ333 πυροφορικό υγρό (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 150;BA.debugLine="clv2.AddTextItem(\"336 πολύ εύφλεκτο υγρό, τοξικό\"";
mostCurrent._clv2._addtextitem /*String*/ ("336 πολύ εύφλεκτο υγρό, τοξικό",(Object)(""));
 //BA.debugLineNum = 151;BA.debugLine="clv2.AddTextItem(\"338 πολύ εύφλεκτο υγρό, διαβρωτι";
mostCurrent._clv2._addtextitem /*String*/ ("338 πολύ εύφλεκτο υγρό, διαβρωτικό",(Object)(""));
 //BA.debugLineNum = 152;BA.debugLine="clv2.AddTextItem(\"Χ338 πολύ εύφλεκτο υγρό, διαβρωτ";
mostCurrent._clv2._addtextitem /*String*/ ("Χ338 πολύ εύφλεκτο υγρό, διαβρωτικό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 153;BA.debugLine="clv2.AddTextItem(\"339 πολύ εύφλεκτο υγρό που μπορε";
mostCurrent._clv2._addtextitem /*String*/ ("339 πολύ εύφλεκτο υγρό που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 154;BA.debugLine="clv2.AddTextItem(\"36 εύφλεκτο υγρό (σημείο ανάφλεξ";
mostCurrent._clv2._addtextitem /*String*/ ("36 εύφλεκτο υγρό (σημείο ανάφλεξης μεταξύ 23ºC και 60ºC, συμπεριλαμβανομένου), ελαφρώς τοξικό, ή αυτοθερμαινόμενο υγρό, τοξικό",(Object)(""));
 //BA.debugLineNum = 155;BA.debugLine="clv2.AddTextItem(\"362 εύφλεκτο υγρό, τοξικό, που α";
mostCurrent._clv2._addtextitem /*String*/ ("362 εύφλεκτο υγρό, τοξικό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 156;BA.debugLine="clv2.AddTextItem(\"Χ362 εύφλεκτο υγρό, τοξικό, που";
mostCurrent._clv2._addtextitem /*String*/ ("Χ362 εύφλεκτο υγρό, τοξικό, που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 157;BA.debugLine="clv2.AddTextItem(\"368 εύφλεκτο υγρό, τοξικό, διαβρ";
mostCurrent._clv2._addtextitem /*String*/ ("368 εύφλεκτο υγρό, τοξικό, διαβρωτικό",(Object)(""));
 //BA.debugLineNum = 158;BA.debugLine="clv2.AddTextItem(\"38 εύφλεκτο υγρό (σημείο ανάφλεξ";
mostCurrent._clv2._addtextitem /*String*/ ("38 εύφλεκτο υγρό (σημείο ανάφλεξης μεταξύ 23ºC και 60ºC, συμπεριλαμβανομένου), ελαφρώς διαβρωτικό ή αυτοθερμαινόμενο υγρό, διαβρωτικό",(Object)(""));
 //BA.debugLineNum = 159;BA.debugLine="clv2.AddTextItem(\"382 εύφλεκτο υγρό, διαβρωτικό, π";
mostCurrent._clv2._addtextitem /*String*/ ("382 εύφλεκτο υγρό, διαβρωτικό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 160;BA.debugLine="clv2.AddTextItem(\"Χ382 εύφλεκτο υγρό, διαβρωτικό,";
mostCurrent._clv2._addtextitem /*String*/ ("Χ382 εύφλεκτο υγρό, διαβρωτικό, που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 161;BA.debugLine="clv2.AddTextItem(\"39 εύφλεκτο υγρό, που μπορεί αυθ";
mostCurrent._clv2._addtextitem /*String*/ ("39 εύφλεκτο υγρό, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 162;BA.debugLine="clv2.AddTextItem(\"40 εύφλεκτο στερεό ή αυτενεργή ο";
mostCurrent._clv2._addtextitem /*String*/ ("40 εύφλεκτο στερεό ή αυτενεργή ουσία ή αυτοθερμαινόμενη ουσία",(Object)(""));
 //BA.debugLineNum = 163;BA.debugLine="clv2.AddTextItem(\"423 στερεό που αντιδρά με το νερ";
mostCurrent._clv2._addtextitem /*String*/ ("423 στερεό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 164;BA.debugLine="clv2.AddTextItem(\"Χ423 εύφλεκτο στερεό που αντιδρά";
mostCurrent._clv2._addtextitem /*String*/ ("Χ423 εύφλεκτο στερεό που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 165;BA.debugLine="clv2.AddTextItem(\"43 αυθόρμητα εύφλεκτο (αυταναφλέ";
mostCurrent._clv2._addtextitem /*String*/ ("43 αυθόρμητα εύφλεκτο (αυταναφλέξιμο) στερεό",(Object)(""));
 //BA.debugLineNum = 166;BA.debugLine="clv2.AddTextItem(\"44 εύφλεκτο στερεό, σε τηγμένη μ";
mostCurrent._clv2._addtextitem /*String*/ ("44 εύφλεκτο στερεό, σε τηγμένη μορφή σε αυξημένη θερμοκρασία",(Object)(""));
 //BA.debugLineNum = 167;BA.debugLine="clv2.AddTextItem(\"446 εύφλεκτο στερεό, τοξικό, σε";
mostCurrent._clv2._addtextitem /*String*/ ("446 εύφλεκτο στερεό, τοξικό, σε τηγμένη μορφή, σε αυξημένη θερμοκρασία",(Object)(""));
 //BA.debugLineNum = 168;BA.debugLine="clv2.AddTextItem(\"46 εύφλεκτο ή αυτοθερμαινόμενο σ";
mostCurrent._clv2._addtextitem /*String*/ ("46 εύφλεκτο ή αυτοθερμαινόμενο στερεό, τοξικό",(Object)(""));
 //BA.debugLineNum = 169;BA.debugLine="clv2.AddTextItem(\"462 τοξικό στερεό, που αντιδρά μ";
mostCurrent._clv2._addtextitem /*String*/ ("462 τοξικό στερεό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 170;BA.debugLine="clv2.AddTextItem(\"Χ462 στερεό που αντιδρά επικίνδυ";
mostCurrent._clv2._addtextitem /*String*/ ("Χ462 στερεό που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 171;BA.debugLine="clv2.AddTextItem(\"48 εύφλεκτο ή αυτοθερμαινόμενο σ";
mostCurrent._clv2._addtextitem /*String*/ ("48 εύφλεκτο ή αυτοθερμαινόμενο στερεό, διαβρωτικό",(Object)(""));
 //BA.debugLineNum = 172;BA.debugLine="clv2.AddTextItem(\"482 διαβρωτικό στερεό που αντιδρ";
mostCurrent._clv2._addtextitem /*String*/ ("482 διαβρωτικό στερεό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 173;BA.debugLine="clv2.AddTextItem(\"Χ482 στερεό που αντιδρά επικίνδυ";
mostCurrent._clv2._addtextitem /*String*/ ("Χ482 στερεό που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 174;BA.debugLine="clv2.AddTextItem(\"50 οξειδωτική (πυροδυναμωτική) ο";
mostCurrent._clv2._addtextitem /*String*/ ("50 οξειδωτική (πυροδυναμωτική) ουσία",(Object)(""));
 //BA.debugLineNum = 175;BA.debugLine="clv2.AddTextItem(\"539 εύφλεκτο οργανικό υπεροξείδι";
mostCurrent._clv2._addtextitem /*String*/ ("539 εύφλεκτο οργανικό υπεροξείδιο",(Object)(""));
 //BA.debugLineNum = 176;BA.debugLine="clv2.AddTextItem(\"55 έντονα οξειδωτική (πυροδυναμω";
mostCurrent._clv2._addtextitem /*String*/ ("55 έντονα οξειδωτική (πυροδυναμωτική) ουσία",(Object)(""));
 //BA.debugLineNum = 177;BA.debugLine="clv2.AddTextItem(\"556 έντονα οξειδωτική (πυροδυναμ";
mostCurrent._clv2._addtextitem /*String*/ ("556 έντονα οξειδωτική (πυροδυναμωτική) ουσία, τοξική",(Object)(""));
 //BA.debugLineNum = 178;BA.debugLine="clv2.AddTextItem(\"558 έντονα οξειδωτική (πυροδυναμ";
mostCurrent._clv2._addtextitem /*String*/ ("558 έντονα οξειδωτική (πυροδυναμωτική) ουσία, διαβρωτική",(Object)(""));
 //BA.debugLineNum = 179;BA.debugLine="clv2.AddTextItem(\"559 έντονα οξειδωτική (πυροδυναμ";
mostCurrent._clv2._addtextitem /*String*/ ("559 έντονα οξειδωτική (πυροδυναμωτική) ουσία, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 180;BA.debugLine="clv2.AddTextItem(\"56 οξειδωτική ουσία (πυροδυναμωτ";
mostCurrent._clv2._addtextitem /*String*/ ("56 οξειδωτική ουσία (πυροδυναμωτική), τοξική",(Object)(""));
 //BA.debugLineNum = 181;BA.debugLine="clv2.AddTextItem(\"568 οξειδωτική ουσία (πυροδυναμω";
mostCurrent._clv2._addtextitem /*String*/ ("568 οξειδωτική ουσία (πυροδυναμωτική), τοξική, διαβρωτική",(Object)(""));
 //BA.debugLineNum = 182;BA.debugLine="clv2.AddTextItem(\"58 οξειδωτική ουσία (πυροδυναμωτ";
mostCurrent._clv2._addtextitem /*String*/ ("58 οξειδωτική ουσία (πυροδυναμωτική), διαβρωτική",(Object)(""));
 //BA.debugLineNum = 183;BA.debugLine="clv2.AddTextItem(\"59 οξειδωτική ουσία (πυροδυναμωτ";
mostCurrent._clv2._addtextitem /*String*/ ("59 οξειδωτική ουσία (πυροδυναμωτική) που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 184;BA.debugLine="clv2.AddTextItem(\"60 τοξική ή ελαφρώς τοξική ουσία";
mostCurrent._clv2._addtextitem /*String*/ ("60 τοξική ή ελαφρώς τοξική ουσία",(Object)(""));
 //BA.debugLineNum = 185;BA.debugLine="clv2.AddTextItem(\"606 μολυσματική ουσία\" ,\"\")";
mostCurrent._clv2._addtextitem /*String*/ ("606 μολυσματική ουσία",(Object)(""));
 //BA.debugLineNum = 186;BA.debugLine="clv2.AddTextItem(\"623 τοξικό υγρό, που αντιδρά με";
mostCurrent._clv2._addtextitem /*String*/ ("623 τοξικό υγρό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 187;BA.debugLine="clv2.AddTextItem(\"63 τοξική ουσία, εύφλεκτη (σημεί";
mostCurrent._clv2._addtextitem /*String*/ ("63 τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C, συμπεριλαμβανομένου)",(Object)(""));
 //BA.debugLineNum = 188;BA.debugLine="clv2.AddTextItem(\"638 τοξική ουσία, εύφλεκτη (σημε";
mostCurrent._clv2._addtextitem /*String*/ ("638 τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C, συμπεριλαμβανομένου), διαβρωτική",(Object)(""));
 //BA.debugLineNum = 189;BA.debugLine="clv2.AddTextItem(\"639 τοξική ουσία, εύφλεκτη (σημε";
mostCurrent._clv2._addtextitem /*String*/ ("639 τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης όχι μεγαλύτερο από τους 60°C) που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 190;BA.debugLine="clv2.AddTextItem(\"64 τοξικό στερεό, εύφλεκτο ή αυτ";
mostCurrent._clv2._addtextitem /*String*/ ("64 τοξικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο",(Object)(""));
 //BA.debugLineNum = 191;BA.debugLine="clv2.AddTextItem(\"642 τοξικό στερεό, που αντιδρά μ";
mostCurrent._clv2._addtextitem /*String*/ ("642 τοξικό στερεό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 192;BA.debugLine="clv2.AddTextItem(\"65 τοξική ουσία, οξειδωτική (πυρ";
mostCurrent._clv2._addtextitem /*String*/ ("65 τοξική ουσία, οξειδωτική (πυροδυναμωτική)",(Object)(""));
 //BA.debugLineNum = 193;BA.debugLine="clv2.AddTextItem(\"66 πολύ τοξική ουσία\" ,\"\")";
mostCurrent._clv2._addtextitem /*String*/ ("66 πολύ τοξική ουσία",(Object)(""));
 //BA.debugLineNum = 194;BA.debugLine="clv2.AddTextItem(\"663 πολύ τοξική ουσία, εύφλεκτη";
mostCurrent._clv2._addtextitem /*String*/ ("663 πολύ τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης όχι μεγαλύτερο από τους 60°C)",(Object)(""));
 //BA.debugLineNum = 195;BA.debugLine="clv2.AddTextItem(\"664 πολύ τοξικό στερεό, εύφλεκτο";
mostCurrent._clv2._addtextitem /*String*/ ("664 πολύ τοξικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο",(Object)(""));
 //BA.debugLineNum = 196;BA.debugLine="clv2.AddTextItem(\"665 πολύ τοξική ουσία, οξειδωτικ";
mostCurrent._clv2._addtextitem /*String*/ ("665 πολύ τοξική ουσία, οξειδωτική (πυροδυναμωτική)",(Object)(""));
 //BA.debugLineNum = 197;BA.debugLine="clv2.AddTextItem(\"668 πολύ τοξική ουσία, διαβρωτικ";
mostCurrent._clv2._addtextitem /*String*/ ("668 πολύ τοξική ουσία, διαβρωτική",(Object)(""));
 //BA.debugLineNum = 198;BA.debugLine="clv2.AddTextItem(\"669 πολύ τοξική ουσία που μπορεί";
mostCurrent._clv2._addtextitem /*String*/ ("669 πολύ τοξική ουσία που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 199;BA.debugLine="clv2.AddTextItem(\"68 τοξική ουσία, διαβρωτική\" ,\"\"";
mostCurrent._clv2._addtextitem /*String*/ ("68 τοξική ουσία, διαβρωτική",(Object)(""));
 //BA.debugLineNum = 200;BA.debugLine="clv2.AddTextItem(\"69 τοξική ή ελαφρώς τοξική ουσία";
mostCurrent._clv2._addtextitem /*String*/ ("69 τοξική ή ελαφρώς τοξική ουσία, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 201;BA.debugLine="clv2.AddTextItem(\"70 ραδιενεργό υλικό\" ,\"\")";
mostCurrent._clv2._addtextitem /*String*/ ("70 ραδιενεργό υλικό",(Object)(""));
 //BA.debugLineNum = 202;BA.debugLine="clv2.AddTextItem(\"78 ραδιενεργό υλικό, διαβρωτικό\"";
mostCurrent._clv2._addtextitem /*String*/ ("78 ραδιενεργό υλικό, διαβρωτικό",(Object)(""));
 //BA.debugLineNum = 203;BA.debugLine="clv2.AddTextItem(\"80 διαβρωτική ή ελαφρώς διαβρωτι";
mostCurrent._clv2._addtextitem /*String*/ ("80 διαβρωτική ή ελαφρώς διαβρωτική ουσία",(Object)(""));
 //BA.debugLineNum = 204;BA.debugLine="clv2.AddTextItem(\"Χ80 διαβρωτική ή ελαφρώς διαβρωτ";
mostCurrent._clv2._addtextitem /*String*/ ("Χ80 διαβρωτική ή ελαφρώς διαβρωτική ουσία, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 205;BA.debugLine="clv2.AddTextItem(\"823 διαβρωτικό υγρό που αντιδρά";
mostCurrent._clv2._addtextitem /*String*/ ("823 διαβρωτικό υγρό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 206;BA.debugLine="clv2.AddTextItem(\"83 διαβρωτική ή ελαφρώς διαβρωτι";
mostCurrent._clv2._addtextitem /*String*/ ("83 διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C)",(Object)(""));
 //BA.debugLineNum = 207;BA.debugLine="clv2.AddTextItem(\"Χ83 διαβρωτική ή ελαφρώς διαβρωτ";
mostCurrent._clv2._addtextitem /*String*/ ("Χ83 διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C ), (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 208;BA.debugLine="clv2.AddTextItem(\"839 διαβρωτική ή ελαφρώς διαβρωτ";
mostCurrent._clv2._addtextitem /*String*/ ("839 διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C συμπεριλαμβανομένου) που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 209;BA.debugLine="clv2.AddTextItem(\"Χ839 διαβρωτική ή ελαφρώς διαβρω";
mostCurrent._clv2._addtextitem /*String*/ ("Χ839 διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C συμπεριλαμβανομένου), που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση και (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 210;BA.debugLine="clv2.AddTextItem(\"84 διαβρωτικό στερεό, εύφλεκτο ή";
mostCurrent._clv2._addtextitem /*String*/ ("84 διαβρωτικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο",(Object)(""));
 //BA.debugLineNum = 211;BA.debugLine="clv2.AddTextItem(\"842 διαβρωτικό στερεό που αντιδρ";
mostCurrent._clv2._addtextitem /*String*/ ("842 διαβρωτικό στερεό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια",(Object)(""));
 //BA.debugLineNum = 212;BA.debugLine="clv2.AddTextItem(\"85 διαβρωτική ή ελαφρώς διαβρωτι";
mostCurrent._clv2._addtextitem /*String*/ ("85 διαβρωτική ή ελαφρώς διαβρωτική ουσία, οξειδωτική (πυροδυναμωτική)",(Object)(""));
 //BA.debugLineNum = 213;BA.debugLine="clv2.AddTextItem(\"856 διαβρωτική ή ελαφρώς διαβρωτ";
mostCurrent._clv2._addtextitem /*String*/ ("856 διαβρωτική ή ελαφρώς διαβρωτική ουσία, οξειδωτική (πυροδυναμωτική) και τοξική",(Object)(""));
 //BA.debugLineNum = 214;BA.debugLine="clv2.AddTextItem(\"86 διαβρωτική ή ελαφρώς διαβρωτι";
mostCurrent._clv2._addtextitem /*String*/ ("86 διαβρωτική ή ελαφρώς διαβρωτική ουσία, τοξική",(Object)(""));
 //BA.debugLineNum = 215;BA.debugLine="clv2.AddTextItem(\"88 πολύ διαβρωτική ουσία\" ,\"\")";
mostCurrent._clv2._addtextitem /*String*/ ("88 πολύ διαβρωτική ουσία",(Object)(""));
 //BA.debugLineNum = 216;BA.debugLine="clv2.AddTextItem(\"Χ88 πολύ διαβρωτική ουσία, (ΑΠΑΓ";
mostCurrent._clv2._addtextitem /*String*/ ("Χ88 πολύ διαβρωτική ουσία, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 217;BA.debugLine="clv2.AddTextItem(\"883 πολύ διαβρωτική ουσία, εύφλε";
mostCurrent._clv2._addtextitem /*String*/ ("883 πολύ διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C συμπεριλαμβανομένου)",(Object)(""));
 //BA.debugLineNum = 218;BA.debugLine="clv2.AddTextItem(\"884 πολύ διαβρωτικό στερεό, εύφλ";
mostCurrent._clv2._addtextitem /*String*/ ("884 πολύ διαβρωτικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο",(Object)(""));
 //BA.debugLineNum = 219;BA.debugLine="clv2.AddTextItem(\"885 πολύ διαβρωτική ουσία, οξειδ";
mostCurrent._clv2._addtextitem /*String*/ ("885 πολύ διαβρωτική ουσία, οξειδωτική (πυροδυναμωτική)",(Object)(""));
 //BA.debugLineNum = 220;BA.debugLine="clv2.AddTextItem(\"886 πολύ διαβρωτική ουσία, τοξικ";
mostCurrent._clv2._addtextitem /*String*/ ("886 πολύ διαβρωτική ουσία, τοξική",(Object)(""));
 //BA.debugLineNum = 221;BA.debugLine="clv2.AddTextItem(\"Χ886 πολύ διαβρωτική ουσία, τοξι";
mostCurrent._clv2._addtextitem /*String*/ ("Χ886 πολύ διαβρωτική ουσία, τοξική, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)",(Object)(""));
 //BA.debugLineNum = 222;BA.debugLine="clv2.AddTextItem(\"89 διαβρωτική ή ελαφρώς διαβρωτι";
mostCurrent._clv2._addtextitem /*String*/ ("89 διαβρωτική ή ελαφρώς διαβρωτική ουσία, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση",(Object)(""));
 //BA.debugLineNum = 223;BA.debugLine="clv2.AddTextItem(\"90 περιβαλλοντικά επικίνδυνη ουσ";
mostCurrent._clv2._addtextitem /*String*/ ("90 περιβαλλοντικά επικίνδυνη ουσία, διάφορες επικίνδυνες ουσίες",(Object)(""));
 //BA.debugLineNum = 224;BA.debugLine="clv2.AddTextItem(\"99 διάφορες επικίνδυνες ουσίες π";
mostCurrent._clv2._addtextitem /*String*/ ("99 διάφορες επικίνδυνες ουσίες που μεταφέρονται σε αυξημένη θερμοκρασία",(Object)(""));
 //BA.debugLineNum = 226;BA.debugLine="simanseislabel.BringToFront";
mostCurrent._simanseislabel.BringToFront();
 //BA.debugLineNum = 227;BA.debugLine="listabel.BringToFront";
mostCurrent._listabel.BringToFront();
 //BA.debugLineNum = 228;BA.debugLine="katigorlabel.BringToFront";
mostCurrent._katigorlabel.BringToFront();
 //BA.debugLineNum = 229;BA.debugLine="ousialabel.BringToFront";
mostCurrent._ousialabel.BringToFront();
 //BA.debugLineNum = 230;BA.debugLine="ililabel.BringToFront";
mostCurrent._ililabel.BringToFront();
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 297;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 298;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 300;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 302;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 237;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim s As Int";
_s = 0;
 //BA.debugLineNum = 14;BA.debugLine="Dim tgtlabel As Label";
mostCurrent._tgtlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Dim myarray(90) As String";
mostCurrent._myarray = new String[(int) (90)];
java.util.Arrays.fill(mostCurrent._myarray,"");
 //BA.debugLineNum = 18;BA.debugLine="Dim katigo As Label";
mostCurrent._katigo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Dim epilogi As Label";
mostCurrent._epilogi = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Dim searching As ImageView";
mostCurrent._searching = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private back1 As ImageView";
mostCurrent._back1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim clv2 As CustomListView";
mostCurrent._clv2 = new firefighter.companion.customlistview();
 //BA.debugLineNum = 29;BA.debugLine="Dim Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim ili As Button";
mostCurrent._ili = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Dim ousia As Button";
mostCurrent._ousia = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Dim simansi As Button";
mostCurrent._simansi = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim pixi As Button";
mostCurrent._pixi = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Dim lista As Button";
mostCurrent._lista = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private katigor As Button";
mostCurrent._katigor = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Dim fakos As Label";
mostCurrent._fakos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private mple As ImageView";
mostCurrent._mple = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private simanseislabel As Label";
mostCurrent._simanseislabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private listabel As Label";
mostCurrent._listabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private katigorlabel As Label";
mostCurrent._katigorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private ousialabel As Label";
mostCurrent._ousialabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private ililabel As Label";
mostCurrent._ililabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _gpss_click() throws Exception{
 //BA.debugLineNum = 267;BA.debugLine="Sub gpss_Click";
 //BA.debugLineNum = 269;BA.debugLine="StartActivity(\"gpssingal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssingal"));
 //BA.debugLineNum = 270;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
return "";
}
public static String  _ili_click() throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Sub ili_Click";
 //BA.debugLineNum = 246;BA.debugLine="StartActivity(\"ilika\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ilika"));
 //BA.debugLineNum = 247;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
 //BA.debugLineNum = 289;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 290;BA.debugLine="StartActivity(\"ilika\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ilika"));
 //BA.debugLineNum = 291;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return "";
}
public static String  _katigor_click() throws Exception{
 //BA.debugLineNum = 263;BA.debugLine="Sub katigor_Click";
 //BA.debugLineNum = 264;BA.debugLine="StartActivity(\"simanseis\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("simanseis"));
 //BA.debugLineNum = 265;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 266;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 281;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 282;BA.debugLine="StartActivity(\"simanseis\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("simanseis"));
 //BA.debugLineNum = 283;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return "";
}
public static String  _lista_click() throws Exception{
 //BA.debugLineNum = 258;BA.debugLine="Sub lista_Click";
 //BA.debugLineNum = 259;BA.debugLine="StartActivity(\"listaousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("listaousies"));
 //BA.debugLineNum = 260;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 277;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 278;BA.debugLine="StartActivity(\"listaousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("listaousies"));
 //BA.debugLineNum = 279;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 280;BA.debugLine="End Sub";
return "";
}
public static String  _ousia_click() throws Exception{
 //BA.debugLineNum = 249;BA.debugLine="Sub ousia_Click";
 //BA.debugLineNum = 250;BA.debugLine="StartActivity(\"ousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ousies"));
 //BA.debugLineNum = 251;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 285;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 286;BA.debugLine="StartActivity(\"ousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ousies"));
 //BA.debugLineNum = 287;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
return "";
}
public static String  _pixi_click() throws Exception{
 //BA.debugLineNum = 253;BA.debugLine="Sub pixi_Click";
 //BA.debugLineNum = 254;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 255;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 273;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 274;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 //BA.debugLineNum = 275;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return "";
}
public static String  _simansi_click() throws Exception{
 //BA.debugLineNum = 293;BA.debugLine="Sub simansi_Click";
 //BA.debugLineNum = 294;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 //BA.debugLineNum = 295;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 296;BA.debugLine="End Sub";
return "";
}
}
