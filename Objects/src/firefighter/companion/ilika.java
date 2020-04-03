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

public class ilika extends Activity implements B4AActivity{
	public static ilika mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.ilika");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (ilika).");
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
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.ilika");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.ilika", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (ilika) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (ilika) Resume **");
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
		return ilika.class;
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
        BA.LogInfo("** Activity (ilika) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            ilika mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (ilika) Resume **");
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
public anywheresoftware.b4a.objects.PanelWrapper _panel = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin5 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin6 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin7 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin8 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin9 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin10 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin11 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin12 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin13 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin14 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin15 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin16 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin17 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin18 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin19 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin20 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin21 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin8 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin9 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin10 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin12 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin13 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin14 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin15 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin16 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin17 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin18 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin19 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin20 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin21 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview0 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview5 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview6 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview7 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview8 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview9 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview10 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview11 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview12 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview13 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview14 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview15 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview16 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview17 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview18 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview19 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview20 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview21 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _back1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _back2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _back3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _back4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _back5 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _back6 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _back7 = null;
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
 //BA.debugLineNum = 101;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 102;BA.debugLine="Activity.LoadLayout(\"ilikaa.bal\")";
mostCurrent._activity.LoadLayout("ilikaa.bal",mostCurrent.activityBA);
 //BA.debugLineNum = 103;BA.debugLine="sc.initialize(1000dip)";
mostCurrent._sc.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1000)));
 //BA.debugLineNum = 104;BA.debugLine="Activity.AddView(sc,3%x,33%y,94%x,57.5%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._sc.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 106;BA.debugLine="sc.Panel.Width = 96%x";
mostCurrent._sc.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA));
 //BA.debugLineNum = 107;BA.debugLine="sc.Panel.Height = 425%y";
mostCurrent._sc.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (425),mostCurrent.activityBA));
 //BA.debugLineNum = 110;BA.debugLine="Panel1.RemoveView";
mostCurrent._panel1.RemoveView();
 //BA.debugLineNum = 111;BA.debugLine="sc.Panel.AddView( Panel1,0%x,-9%y,99%x,434%y)";
mostCurrent._sc.getPanel().AddView((android.view.View)(mostCurrent._panel1.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),(int) (-anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (9),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (99),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (434),mostCurrent.activityBA));
 //BA.debugLineNum = 113;BA.debugLine="textpin1.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 114;BA.debugLine="textpin2.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 115;BA.debugLine="textpin3.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 116;BA.debugLine="textpin4.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin4.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 117;BA.debugLine="textpin5.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin5.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 118;BA.debugLine="textpin6.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin6.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 119;BA.debugLine="textpin7.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin7.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 120;BA.debugLine="textpin8.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin8.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 121;BA.debugLine="textpin9.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin9.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 122;BA.debugLine="textpin10.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin10.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 123;BA.debugLine="textpin11.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin11.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 124;BA.debugLine="textpin12.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin12.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 125;BA.debugLine="textpin13.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin13.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 126;BA.debugLine="textpin14.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin14.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 127;BA.debugLine="textpin15.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin15.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 128;BA.debugLine="textpin16.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin16.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 129;BA.debugLine="textpin17.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin17.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 130;BA.debugLine="textpin18.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin18.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 131;BA.debugLine="textpin19.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin19.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 132;BA.debugLine="textpin20.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin20.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 133;BA.debugLine="textpin21.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin21.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 135;BA.debugLine="ImageView0.Top = 9%y";
mostCurrent._imageview0.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (9),mostCurrent.activityBA));
 //BA.debugLineNum = 136;BA.debugLine="ImageView0.Left = 0%x";
mostCurrent._imageview0.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 137;BA.debugLine="ImageView0.Width = 100%x";
mostCurrent._imageview0.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 138;BA.debugLine="ImageView0.Height = 1%y";
mostCurrent._imageview0.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 140;BA.debugLine="pin1.Top = 10%y";
mostCurrent._pin1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 141;BA.debugLine="pin1.Left = 0%x";
mostCurrent._pin1.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 142;BA.debugLine="pin1.Width = 20%x";
mostCurrent._pin1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 143;BA.debugLine="pin1.Height = 14%y";
mostCurrent._pin1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 145;BA.debugLine="textpin1.Top = 10%y";
mostCurrent._textpin1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 146;BA.debugLine="textpin1.Left = 25%x";
mostCurrent._textpin1.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 147;BA.debugLine="textpin1.Width = 75%x";
mostCurrent._textpin1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 148;BA.debugLine="textpin1.Height = 14%y";
mostCurrent._textpin1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 151;BA.debugLine="ImageView1.Top = 26%y";
mostCurrent._imageview1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (26),mostCurrent.activityBA));
 //BA.debugLineNum = 152;BA.debugLine="ImageView1.Left = 0%x";
mostCurrent._imageview1.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 153;BA.debugLine="ImageView1.Width = 100%x";
mostCurrent._imageview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 154;BA.debugLine="ImageView1.Height = 1%y";
mostCurrent._imageview1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 156;BA.debugLine="back1.Top = 9.5%y";
mostCurrent._back1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (9.5),mostCurrent.activityBA));
 //BA.debugLineNum = 157;BA.debugLine="back1.Left = 0%x";
mostCurrent._back1.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 158;BA.debugLine="back1.Width = 100%x";
mostCurrent._back1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 159;BA.debugLine="back1.Height = 77%y";
mostCurrent._back1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (77),mostCurrent.activityBA));
 //BA.debugLineNum = 162;BA.debugLine="pin2.Top = 30%y";
mostCurrent._pin2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
 //BA.debugLineNum = 163;BA.debugLine="pin2.Left = 0%x";
mostCurrent._pin2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 164;BA.debugLine="pin2.Width = 20%x";
mostCurrent._pin2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 165;BA.debugLine="pin2.Height = 14%y";
mostCurrent._pin2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 166;BA.debugLine="ImageView2.Top = 46%y";
mostCurrent._imageview2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (46),mostCurrent.activityBA));
 //BA.debugLineNum = 167;BA.debugLine="ImageView2.Left = 0%x";
mostCurrent._imageview2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 168;BA.debugLine="ImageView2.Width = 100%x";
mostCurrent._imageview2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 169;BA.debugLine="ImageView2.Height = 1%y";
mostCurrent._imageview2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 171;BA.debugLine="textpin2.Top = 30%y";
mostCurrent._textpin2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
 //BA.debugLineNum = 172;BA.debugLine="textpin2.Left = 25%x";
mostCurrent._textpin2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 173;BA.debugLine="textpin2.Width = 75%x";
mostCurrent._textpin2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 174;BA.debugLine="textpin2.Height = 14%y";
mostCurrent._textpin2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 178;BA.debugLine="pin3.Top = 50%y";
mostCurrent._pin3.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
 //BA.debugLineNum = 179;BA.debugLine="pin3.Left = 0%x";
mostCurrent._pin3.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 180;BA.debugLine="pin3.Width = 20%x";
mostCurrent._pin3.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 181;BA.debugLine="pin3.Height = 14%y";
mostCurrent._pin3.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 182;BA.debugLine="ImageView3.Top = 66%y";
mostCurrent._imageview3.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (66),mostCurrent.activityBA));
 //BA.debugLineNum = 183;BA.debugLine="ImageView3.Left = 0%x";
mostCurrent._imageview3.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 184;BA.debugLine="ImageView3.Width = 100%x";
mostCurrent._imageview3.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 185;BA.debugLine="ImageView3.Height = 1%y";
mostCurrent._imageview3.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 187;BA.debugLine="textpin3.Top = 50%y";
mostCurrent._textpin3.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
 //BA.debugLineNum = 188;BA.debugLine="textpin3.Left = 25%x";
mostCurrent._textpin3.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 189;BA.debugLine="textpin3.Width = 75%x";
mostCurrent._textpin3.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 190;BA.debugLine="textpin3.Height = 14%y";
mostCurrent._textpin3.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 194;BA.debugLine="pin4.Top = 70%y";
mostCurrent._pin4.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 195;BA.debugLine="pin4.Left = 0%x";
mostCurrent._pin4.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 196;BA.debugLine="pin4.Width = 20%x";
mostCurrent._pin4.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 197;BA.debugLine="pin4.Height = 14%y";
mostCurrent._pin4.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 198;BA.debugLine="ImageView4.Top = 86%y";
mostCurrent._imageview4.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (86),mostCurrent.activityBA));
 //BA.debugLineNum = 199;BA.debugLine="ImageView4.Left = 0%x";
mostCurrent._imageview4.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 200;BA.debugLine="ImageView4.Width = 100%x";
mostCurrent._imageview4.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 201;BA.debugLine="ImageView4.Height = 1%y";
mostCurrent._imageview4.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 203;BA.debugLine="textpin4.Top = 70%y";
mostCurrent._textpin4.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 204;BA.debugLine="textpin4.Left = 25%x";
mostCurrent._textpin4.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 205;BA.debugLine="textpin4.Width = 75%x";
mostCurrent._textpin4.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 206;BA.debugLine="textpin4.Height = 14%y";
mostCurrent._textpin4.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 210;BA.debugLine="pin5.Top = 90%y";
mostCurrent._pin5.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (90),mostCurrent.activityBA));
 //BA.debugLineNum = 211;BA.debugLine="pin5.Left = 0%x";
mostCurrent._pin5.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 212;BA.debugLine="pin5.Width = 20%x";
mostCurrent._pin5.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 213;BA.debugLine="pin5.Height = 14%y";
mostCurrent._pin5.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 214;BA.debugLine="ImageView5.Top = 106%y";
mostCurrent._imageview5.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (106),mostCurrent.activityBA));
 //BA.debugLineNum = 215;BA.debugLine="ImageView5.Left = 0%x";
mostCurrent._imageview5.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 216;BA.debugLine="ImageView5.Width = 100%x";
mostCurrent._imageview5.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 217;BA.debugLine="ImageView5.Height = 1%y";
mostCurrent._imageview5.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 219;BA.debugLine="textpin5.Top = 90%y";
mostCurrent._textpin5.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (90),mostCurrent.activityBA));
 //BA.debugLineNum = 220;BA.debugLine="textpin5.Left = 25%x";
mostCurrent._textpin5.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 221;BA.debugLine="textpin5.Width = 75%x";
mostCurrent._textpin5.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 222;BA.debugLine="textpin5.Height = 14%y";
mostCurrent._textpin5.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 227;BA.debugLine="back2.Top = 77.5%y";
mostCurrent._back2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (77.5),mostCurrent.activityBA));
 //BA.debugLineNum = 228;BA.debugLine="back2.Left = 0%x";
mostCurrent._back2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 229;BA.debugLine="back2.Width = 100%x";
mostCurrent._back2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 230;BA.debugLine="back2.Height = 69%y";
mostCurrent._back2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (69),mostCurrent.activityBA));
 //BA.debugLineNum = 233;BA.debugLine="pin6.Top = 110%y";
mostCurrent._pin6.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (110),mostCurrent.activityBA));
 //BA.debugLineNum = 234;BA.debugLine="pin6.Left = 0%x";
mostCurrent._pin6.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 235;BA.debugLine="pin6.Width = 20%x";
mostCurrent._pin6.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 236;BA.debugLine="pin6.Height = 14%y";
mostCurrent._pin6.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 237;BA.debugLine="ImageView6.Top = 126%y";
mostCurrent._imageview6.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (126),mostCurrent.activityBA));
 //BA.debugLineNum = 238;BA.debugLine="ImageView6.Left = 0%x";
mostCurrent._imageview6.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 239;BA.debugLine="ImageView6.Width = 100%x";
mostCurrent._imageview6.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 240;BA.debugLine="ImageView6.Height = 1%y";
mostCurrent._imageview6.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 242;BA.debugLine="textpin6.Top = 110%y";
mostCurrent._textpin6.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (110),mostCurrent.activityBA));
 //BA.debugLineNum = 243;BA.debugLine="textpin6.Left = 25%x";
mostCurrent._textpin6.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 244;BA.debugLine="textpin6.Width = 75%x";
mostCurrent._textpin6.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 245;BA.debugLine="textpin6.Height = 14%y";
mostCurrent._textpin6.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 249;BA.debugLine="pin7.Top = 130%y";
mostCurrent._pin7.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (130),mostCurrent.activityBA));
 //BA.debugLineNum = 250;BA.debugLine="pin7.Left = 0%x";
mostCurrent._pin7.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 251;BA.debugLine="pin7.Width = 20%x";
mostCurrent._pin7.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 252;BA.debugLine="pin7.Height = 14%y";
mostCurrent._pin7.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 253;BA.debugLine="ImageView7.Top = 146%y";
mostCurrent._imageview7.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (146),mostCurrent.activityBA));
 //BA.debugLineNum = 254;BA.debugLine="ImageView7.Left = 0%x";
mostCurrent._imageview7.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 255;BA.debugLine="ImageView7.Width = 100%x";
mostCurrent._imageview7.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 256;BA.debugLine="ImageView7.Height = 1%y";
mostCurrent._imageview7.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 259;BA.debugLine="textpin7.Top = 130%y";
mostCurrent._textpin7.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (130),mostCurrent.activityBA));
 //BA.debugLineNum = 260;BA.debugLine="textpin7.Left = 25%x";
mostCurrent._textpin7.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 261;BA.debugLine="textpin7.Width = 75%x";
mostCurrent._textpin7.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 262;BA.debugLine="textpin7.Height = 14%y";
mostCurrent._textpin7.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 265;BA.debugLine="pin8.Top = 150%y";
mostCurrent._pin8.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (150),mostCurrent.activityBA));
 //BA.debugLineNum = 266;BA.debugLine="pin8.Left = 0%x";
mostCurrent._pin8.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 267;BA.debugLine="pin8.Width = 20%x";
mostCurrent._pin8.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 268;BA.debugLine="pin8.Height = 14%y";
mostCurrent._pin8.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 269;BA.debugLine="ImageView8.Top = 166%y";
mostCurrent._imageview8.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (166),mostCurrent.activityBA));
 //BA.debugLineNum = 270;BA.debugLine="ImageView8.Left = 0%x";
mostCurrent._imageview8.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 271;BA.debugLine="ImageView8.Width = 100%x";
mostCurrent._imageview8.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 272;BA.debugLine="ImageView8.Height = 1%y";
mostCurrent._imageview8.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 273;BA.debugLine="back3.Top = 146.5%y";
mostCurrent._back3.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (146.5),mostCurrent.activityBA));
 //BA.debugLineNum = 274;BA.debugLine="back3.Left = 0%x";
mostCurrent._back3.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 275;BA.debugLine="back3.Width = 100%x";
mostCurrent._back3.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 276;BA.debugLine="back3.Height = 20%y";
mostCurrent._back3.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 279;BA.debugLine="textpin8.Top = 150%y";
mostCurrent._textpin8.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (150),mostCurrent.activityBA));
 //BA.debugLineNum = 280;BA.debugLine="textpin8.Left = 25%x";
mostCurrent._textpin8.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 281;BA.debugLine="textpin8.Width = 75%x";
mostCurrent._textpin8.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 282;BA.debugLine="textpin8.Height = 14%y";
mostCurrent._textpin8.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 286;BA.debugLine="pin9.Top = 170%y";
mostCurrent._pin9.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (170),mostCurrent.activityBA));
 //BA.debugLineNum = 287;BA.debugLine="pin9.Left = 0%x";
mostCurrent._pin9.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 288;BA.debugLine="pin9.Width = 20%x";
mostCurrent._pin9.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 289;BA.debugLine="pin9.Height = 14%y";
mostCurrent._pin9.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 290;BA.debugLine="ImageView9.Top = 186%y";
mostCurrent._imageview9.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (186),mostCurrent.activityBA));
 //BA.debugLineNum = 291;BA.debugLine="ImageView9.Left = 0%x";
mostCurrent._imageview9.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 292;BA.debugLine="ImageView9.Width = 100%x";
mostCurrent._imageview9.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 293;BA.debugLine="ImageView9.Height = 1%y";
mostCurrent._imageview9.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 296;BA.debugLine="textpin9.Top = 170%y";
mostCurrent._textpin9.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (170),mostCurrent.activityBA));
 //BA.debugLineNum = 297;BA.debugLine="textpin9.Left = 25%x";
mostCurrent._textpin9.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 298;BA.debugLine="textpin9.Width = 75%x";
mostCurrent._textpin9.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 299;BA.debugLine="textpin9.Height = 14%y";
mostCurrent._textpin9.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 305;BA.debugLine="pin10.Top = 190%y";
mostCurrent._pin10.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (190),mostCurrent.activityBA));
 //BA.debugLineNum = 306;BA.debugLine="pin10.Left = 0%x";
mostCurrent._pin10.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 307;BA.debugLine="pin10.Width = 20%x";
mostCurrent._pin10.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 308;BA.debugLine="pin10.Height = 14%y";
mostCurrent._pin10.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 309;BA.debugLine="ImageView10.Top = 206%y";
mostCurrent._imageview10.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (206),mostCurrent.activityBA));
 //BA.debugLineNum = 310;BA.debugLine="ImageView10.Left = 0%x";
mostCurrent._imageview10.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 311;BA.debugLine="ImageView10.Width = 100%x";
mostCurrent._imageview10.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 312;BA.debugLine="ImageView10.Height = 1%y";
mostCurrent._imageview10.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 314;BA.debugLine="textpin10.Top = 190%y";
mostCurrent._textpin10.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (190),mostCurrent.activityBA));
 //BA.debugLineNum = 315;BA.debugLine="textpin10.Left = 25%x";
mostCurrent._textpin10.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 316;BA.debugLine="textpin10.Width = 75%x";
mostCurrent._textpin10.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 317;BA.debugLine="textpin10.Height = 14%y";
mostCurrent._textpin10.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 321;BA.debugLine="pin11.Top = 210%y";
mostCurrent._pin11.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (210),mostCurrent.activityBA));
 //BA.debugLineNum = 322;BA.debugLine="pin11.Left = 0%x";
mostCurrent._pin11.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 323;BA.debugLine="pin11.Width = 20%x";
mostCurrent._pin11.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 324;BA.debugLine="pin11.Height = 14%y";
mostCurrent._pin11.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 325;BA.debugLine="ImageView11.Top = 226%y";
mostCurrent._imageview11.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (226),mostCurrent.activityBA));
 //BA.debugLineNum = 326;BA.debugLine="ImageView11.Left = 0%x";
mostCurrent._imageview11.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 327;BA.debugLine="ImageView11.Width = 100%x";
mostCurrent._imageview11.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 328;BA.debugLine="ImageView11.Height = 1%y";
mostCurrent._imageview11.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 330;BA.debugLine="textpin11.Top = 210%y";
mostCurrent._textpin11.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (210),mostCurrent.activityBA));
 //BA.debugLineNum = 331;BA.debugLine="textpin11.Left = 25%x";
mostCurrent._textpin11.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 332;BA.debugLine="textpin11.Width = 75%x";
mostCurrent._textpin11.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 333;BA.debugLine="textpin11.Height = 14%y";
mostCurrent._textpin11.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 336;BA.debugLine="back4.Top = 166.5%y";
mostCurrent._back4.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (166.5),mostCurrent.activityBA));
 //BA.debugLineNum = 337;BA.debugLine="back4.Left = 0%x";
mostCurrent._back4.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 338;BA.debugLine="back4.Width = 100%x";
mostCurrent._back4.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 339;BA.debugLine="back4.Height = 79.5%y";
mostCurrent._back4.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (79.5),mostCurrent.activityBA));
 //BA.debugLineNum = 342;BA.debugLine="pin12.Top = 230%y";
mostCurrent._pin12.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (230),mostCurrent.activityBA));
 //BA.debugLineNum = 343;BA.debugLine="pin12.Left = 0%x";
mostCurrent._pin12.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 344;BA.debugLine="pin12.Width = 20%x";
mostCurrent._pin12.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 345;BA.debugLine="pin12.Height = 14%y";
mostCurrent._pin12.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 346;BA.debugLine="ImageView12.Top = 246%y";
mostCurrent._imageview12.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (246),mostCurrent.activityBA));
 //BA.debugLineNum = 347;BA.debugLine="ImageView12.Left = 0%x";
mostCurrent._imageview12.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 348;BA.debugLine="ImageView12.Width = 100%x";
mostCurrent._imageview12.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 349;BA.debugLine="ImageView12.Height = 1%y";
mostCurrent._imageview12.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 351;BA.debugLine="textpin12.Top = 230%y";
mostCurrent._textpin12.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (230),mostCurrent.activityBA));
 //BA.debugLineNum = 352;BA.debugLine="textpin12.Left = 25%x";
mostCurrent._textpin12.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 353;BA.debugLine="textpin12.Width = 75%x";
mostCurrent._textpin12.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 354;BA.debugLine="textpin12.Height = 14%y";
mostCurrent._textpin12.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 357;BA.debugLine="back5.Top = 226.5%y";
mostCurrent._back5.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (226.5),mostCurrent.activityBA));
 //BA.debugLineNum = 358;BA.debugLine="back5.Left = 0%x";
mostCurrent._back5.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 359;BA.debugLine="back5.Width = 100%x";
mostCurrent._back5.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 360;BA.debugLine="back5.Height = 39.5%y";
mostCurrent._back5.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (39.5),mostCurrent.activityBA));
 //BA.debugLineNum = 363;BA.debugLine="pin13.Top = 250%y";
mostCurrent._pin13.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (250),mostCurrent.activityBA));
 //BA.debugLineNum = 364;BA.debugLine="pin13.Left = 0%x";
mostCurrent._pin13.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 365;BA.debugLine="pin13.Width = 20%x";
mostCurrent._pin13.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 366;BA.debugLine="pin13.Height = 14%y";
mostCurrent._pin13.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 367;BA.debugLine="ImageView13.Top = 266%y";
mostCurrent._imageview13.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (266),mostCurrent.activityBA));
 //BA.debugLineNum = 368;BA.debugLine="ImageView13.Left = 0%x";
mostCurrent._imageview13.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 369;BA.debugLine="ImageView13.Width = 100%x";
mostCurrent._imageview13.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 370;BA.debugLine="ImageView13.Height = 1%y";
mostCurrent._imageview13.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 372;BA.debugLine="textpin13.Top = 250%y";
mostCurrent._textpin13.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (250),mostCurrent.activityBA));
 //BA.debugLineNum = 373;BA.debugLine="textpin13.Left = 25%x";
mostCurrent._textpin13.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 374;BA.debugLine="textpin13.Width = 75%x";
mostCurrent._textpin13.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 375;BA.debugLine="textpin13.Height = 14%y";
mostCurrent._textpin13.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 381;BA.debugLine="pin14.Top = 270%y";
mostCurrent._pin14.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (270),mostCurrent.activityBA));
 //BA.debugLineNum = 382;BA.debugLine="pin14.Left = 0%x";
mostCurrent._pin14.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 383;BA.debugLine="pin14.Width = 20%x";
mostCurrent._pin14.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 384;BA.debugLine="pin14.Height = 14%y";
mostCurrent._pin14.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 385;BA.debugLine="ImageView14.Top = 286%y";
mostCurrent._imageview14.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (286),mostCurrent.activityBA));
 //BA.debugLineNum = 386;BA.debugLine="ImageView14.Left = 0%x";
mostCurrent._imageview14.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 387;BA.debugLine="ImageView14.Width = 100%x";
mostCurrent._imageview14.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 388;BA.debugLine="ImageView14.Height = 1%y";
mostCurrent._imageview14.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 390;BA.debugLine="textpin14.Top = 270%y";
mostCurrent._textpin14.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (270),mostCurrent.activityBA));
 //BA.debugLineNum = 391;BA.debugLine="textpin14.Left = 25%x";
mostCurrent._textpin14.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 392;BA.debugLine="textpin14.Width = 75%x";
mostCurrent._textpin14.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 393;BA.debugLine="textpin14.Height = 14%y";
mostCurrent._textpin14.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 395;BA.debugLine="pin15.Top = 290%y";
mostCurrent._pin15.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (290),mostCurrent.activityBA));
 //BA.debugLineNum = 396;BA.debugLine="pin15.Left = 0%x";
mostCurrent._pin15.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 397;BA.debugLine="pin15.Width = 20%x";
mostCurrent._pin15.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 398;BA.debugLine="pin15.Height = 14%y";
mostCurrent._pin15.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 399;BA.debugLine="ImageView15.Top = 306%y";
mostCurrent._imageview15.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (306),mostCurrent.activityBA));
 //BA.debugLineNum = 400;BA.debugLine="ImageView15.Left = 0%x";
mostCurrent._imageview15.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 401;BA.debugLine="ImageView15.Width = 100%x";
mostCurrent._imageview15.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 402;BA.debugLine="ImageView15.Height = 1%y";
mostCurrent._imageview15.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 404;BA.debugLine="textpin15.Top = 290%y";
mostCurrent._textpin15.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (290),mostCurrent.activityBA));
 //BA.debugLineNum = 405;BA.debugLine="textpin15.Left = 25%x";
mostCurrent._textpin15.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 406;BA.debugLine="textpin15.Width = 75%x";
mostCurrent._textpin15.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 407;BA.debugLine="textpin15.Height = 14%y";
mostCurrent._textpin15.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 409;BA.debugLine="pin16.Top = 310%y";
mostCurrent._pin16.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (310),mostCurrent.activityBA));
 //BA.debugLineNum = 410;BA.debugLine="pin16.Left = 0%x";
mostCurrent._pin16.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 411;BA.debugLine="pin16.Width = 20%x";
mostCurrent._pin16.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 412;BA.debugLine="pin16.Height = 14%y";
mostCurrent._pin16.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 413;BA.debugLine="ImageView16.Top = 326%y";
mostCurrent._imageview16.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (326),mostCurrent.activityBA));
 //BA.debugLineNum = 414;BA.debugLine="ImageView16.Left = 0%x";
mostCurrent._imageview16.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 415;BA.debugLine="ImageView16.Width = 100%x";
mostCurrent._imageview16.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 416;BA.debugLine="ImageView16.Height = 1%y";
mostCurrent._imageview16.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 418;BA.debugLine="back6.Top = 266.5%y";
mostCurrent._back6.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (266.5),mostCurrent.activityBA));
 //BA.debugLineNum = 419;BA.debugLine="back6.Left = 0%x";
mostCurrent._back6.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 420;BA.debugLine="back6.Height = 40%y";
mostCurrent._back6.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (40),mostCurrent.activityBA));
 //BA.debugLineNum = 421;BA.debugLine="back6.Width = 100%x";
mostCurrent._back6.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 423;BA.debugLine="textpin16.Top = 310%y";
mostCurrent._textpin16.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (310),mostCurrent.activityBA));
 //BA.debugLineNum = 424;BA.debugLine="textpin16.Left = 25%x";
mostCurrent._textpin16.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 425;BA.debugLine="textpin16.Width = 75%x";
mostCurrent._textpin16.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 426;BA.debugLine="textpin16.Height = 14%y";
mostCurrent._textpin16.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 429;BA.debugLine="pin17.Top = 330%y";
mostCurrent._pin17.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (330),mostCurrent.activityBA));
 //BA.debugLineNum = 430;BA.debugLine="pin17.Left = 0%x";
mostCurrent._pin17.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 431;BA.debugLine="pin17.Width = 20%x";
mostCurrent._pin17.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 432;BA.debugLine="pin17.Height = 14%y";
mostCurrent._pin17.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 433;BA.debugLine="ImageView17.Top = 346%y";
mostCurrent._imageview17.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (346),mostCurrent.activityBA));
 //BA.debugLineNum = 434;BA.debugLine="ImageView17.Left = 0%x";
mostCurrent._imageview17.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 435;BA.debugLine="ImageView17.Width = 100%x";
mostCurrent._imageview17.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 436;BA.debugLine="ImageView17.Height = 1%y";
mostCurrent._imageview17.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 438;BA.debugLine="textpin17.Top = 330%y";
mostCurrent._textpin17.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (330),mostCurrent.activityBA));
 //BA.debugLineNum = 439;BA.debugLine="textpin17.Left = 25%x";
mostCurrent._textpin17.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 440;BA.debugLine="textpin17.Width = 75%x";
mostCurrent._textpin17.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 441;BA.debugLine="textpin17.Height = 14%y";
mostCurrent._textpin17.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 444;BA.debugLine="pin18.Top = 350%y";
mostCurrent._pin18.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (350),mostCurrent.activityBA));
 //BA.debugLineNum = 445;BA.debugLine="pin18.Left = 0%x";
mostCurrent._pin18.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 446;BA.debugLine="pin18.Width = 20%x";
mostCurrent._pin18.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 447;BA.debugLine="pin18.Height = 14%y";
mostCurrent._pin18.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 448;BA.debugLine="ImageView18.Top = 366%y";
mostCurrent._imageview18.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (366),mostCurrent.activityBA));
 //BA.debugLineNum = 449;BA.debugLine="ImageView18.Left = 0%x";
mostCurrent._imageview18.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 450;BA.debugLine="ImageView18.Width = 100%x";
mostCurrent._imageview18.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 451;BA.debugLine="ImageView18.Height = 1%y";
mostCurrent._imageview18.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 453;BA.debugLine="textpin18.Top = 350%y";
mostCurrent._textpin18.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (350),mostCurrent.activityBA));
 //BA.debugLineNum = 454;BA.debugLine="textpin18.Left = 25%x";
mostCurrent._textpin18.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 455;BA.debugLine="textpin18.Width = 75%x";
mostCurrent._textpin18.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 456;BA.debugLine="textpin18.Height = 14%y";
mostCurrent._textpin18.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 458;BA.debugLine="pin19.Top = 370%y";
mostCurrent._pin19.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (370),mostCurrent.activityBA));
 //BA.debugLineNum = 459;BA.debugLine="pin19.Left = 0%x";
mostCurrent._pin19.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 460;BA.debugLine="pin19.Width = 20%x";
mostCurrent._pin19.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 461;BA.debugLine="pin19.Height = 14%y";
mostCurrent._pin19.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 462;BA.debugLine="ImageView19.Top = 386%y";
mostCurrent._imageview19.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (386),mostCurrent.activityBA));
 //BA.debugLineNum = 463;BA.debugLine="ImageView19.Left = 0%x";
mostCurrent._imageview19.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 464;BA.debugLine="ImageView19.Width = 100%x";
mostCurrent._imageview19.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 465;BA.debugLine="ImageView19.Height = 1%y";
mostCurrent._imageview19.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 467;BA.debugLine="textpin19.Top = 370%y";
mostCurrent._textpin19.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (370),mostCurrent.activityBA));
 //BA.debugLineNum = 468;BA.debugLine="textpin19.Left = 25%x";
mostCurrent._textpin19.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 469;BA.debugLine="textpin19.Width = 75%x";
mostCurrent._textpin19.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 470;BA.debugLine="textpin19.Height = 14%y";
mostCurrent._textpin19.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 474;BA.debugLine="pin20.Top = 390%y";
mostCurrent._pin20.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (390),mostCurrent.activityBA));
 //BA.debugLineNum = 475;BA.debugLine="pin20.Left = 0%x";
mostCurrent._pin20.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 476;BA.debugLine="pin20.Width = 20%x";
mostCurrent._pin20.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 477;BA.debugLine="pin20.Height = 14%y";
mostCurrent._pin20.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 478;BA.debugLine="ImageView20.Top = 406%y";
mostCurrent._imageview20.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (406),mostCurrent.activityBA));
 //BA.debugLineNum = 479;BA.debugLine="ImageView20.Left = 0%x";
mostCurrent._imageview20.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 480;BA.debugLine="ImageView20.Width = 100%x";
mostCurrent._imageview20.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 481;BA.debugLine="ImageView20.Height = 1%y";
mostCurrent._imageview20.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 483;BA.debugLine="textpin20.Top = 390%y";
mostCurrent._textpin20.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (390),mostCurrent.activityBA));
 //BA.debugLineNum = 484;BA.debugLine="textpin20.Left = 25%x";
mostCurrent._textpin20.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 485;BA.debugLine="textpin20.Width = 75%x";
mostCurrent._textpin20.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 486;BA.debugLine="textpin20.Height = 14%y";
mostCurrent._textpin20.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 488;BA.debugLine="pin21.Top = 409%y";
mostCurrent._pin21.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (409),mostCurrent.activityBA));
 //BA.debugLineNum = 489;BA.debugLine="pin21.Left = 0%x";
mostCurrent._pin21.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 490;BA.debugLine="pin21.Width = 20%x";
mostCurrent._pin21.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 491;BA.debugLine="pin21.Height = 14%y";
mostCurrent._pin21.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 492;BA.debugLine="ImageView21.Top = 424%y";
mostCurrent._imageview21.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (424),mostCurrent.activityBA));
 //BA.debugLineNum = 493;BA.debugLine="ImageView21.Left = 0%x";
mostCurrent._imageview21.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 494;BA.debugLine="ImageView21.Width = 100%x";
mostCurrent._imageview21.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 495;BA.debugLine="ImageView21.Height = 1%y";
mostCurrent._imageview21.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 497;BA.debugLine="back7.Top = 406%y";
mostCurrent._back7.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (406),mostCurrent.activityBA));
 //BA.debugLineNum = 498;BA.debugLine="back7.Left = 0%x";
mostCurrent._back7.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 499;BA.debugLine="back7.Height = 18%y";
mostCurrent._back7.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 500;BA.debugLine="back7.Width = 101%x";
mostCurrent._back7.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (101),mostCurrent.activityBA));
 //BA.debugLineNum = 503;BA.debugLine="textpin21.Top = 411%y";
mostCurrent._textpin21.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (411),mostCurrent.activityBA));
 //BA.debugLineNum = 504;BA.debugLine="textpin21.Left = 25%x";
mostCurrent._textpin21.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 505;BA.debugLine="textpin21.Width = 75%x";
mostCurrent._textpin21.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75),mostCurrent.activityBA));
 //BA.debugLineNum = 506;BA.debugLine="textpin21.Height = 14%y";
mostCurrent._textpin21.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 516;BA.debugLine="simanseislabel.Top = 3%y";
mostCurrent._simanseislabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 517;BA.debugLine="simanseislabel.left = 3.5%x";
mostCurrent._simanseislabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3.5),mostCurrent.activityBA));
 //BA.debugLineNum = 518;BA.debugLine="simanseislabel.height = 27.5%y";
mostCurrent._simanseislabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (27.5),mostCurrent.activityBA));
 //BA.debugLineNum = 519;BA.debugLine="simanseislabel.Width  = 45%x";
mostCurrent._simanseislabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 527;BA.debugLine="listabel.Top = 3%y";
mostCurrent._listabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 528;BA.debugLine="listabel.left = 51.75%x";
mostCurrent._listabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 529;BA.debugLine="listabel.height = 13%y";
mostCurrent._listabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 530;BA.debugLine="listabel.Width  = 21.25%x";
mostCurrent._listabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 536;BA.debugLine="katigorlabel.Top = 18%y";
mostCurrent._katigorlabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 537;BA.debugLine="katigorlabel.left = 51.75%x";
mostCurrent._katigorlabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 538;BA.debugLine="katigorlabel.height = 13%y";
mostCurrent._katigorlabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 539;BA.debugLine="katigorlabel.Width  = 21.25%x";
mostCurrent._katigorlabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 542;BA.debugLine="ousialabel.Top = 3%y";
mostCurrent._ousialabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 543;BA.debugLine="ousialabel.left = 76%x";
mostCurrent._ousialabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 544;BA.debugLine="ousialabel.height = 13%y";
mostCurrent._ousialabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 545;BA.debugLine="ousialabel.Width  = 21.25%x";
mostCurrent._ousialabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 548;BA.debugLine="ililabel.Top = 18%y";
mostCurrent._ililabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 549;BA.debugLine="ililabel.left = 76%x";
mostCurrent._ililabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 550;BA.debugLine="ililabel.height = 13%y";
mostCurrent._ililabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 551;BA.debugLine="ililabel.Width  = 21.25%x";
mostCurrent._ililabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 554;BA.debugLine="mple.top = 93%y";
mostCurrent._mple.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (93),mostCurrent.activityBA));
 //BA.debugLineNum = 555;BA.debugLine="mple.left = 3%x";
mostCurrent._mple.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 556;BA.debugLine="mple.width = 94%x";
mostCurrent._mple.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 557;BA.debugLine="mple.height = 7%y";
mostCurrent._mple.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (7),mostCurrent.activityBA));
 //BA.debugLineNum = 558;BA.debugLine="simanseislabel.BringToFront";
mostCurrent._simanseislabel.BringToFront();
 //BA.debugLineNum = 559;BA.debugLine="listabel.BringToFront";
mostCurrent._listabel.BringToFront();
 //BA.debugLineNum = 560;BA.debugLine="katigorlabel.BringToFront";
mostCurrent._katigorlabel.BringToFront();
 //BA.debugLineNum = 561;BA.debugLine="ousialabel.BringToFront";
mostCurrent._ousialabel.BringToFront();
 //BA.debugLineNum = 562;BA.debugLine="ililabel.BringToFront";
mostCurrent._ililabel.BringToFront();
 //BA.debugLineNum = 565;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 844;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 845;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 847;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 849;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 571;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 573;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 567;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 569;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Dim sc As ScrollView";
mostCurrent._sc = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Dim Panel As Panel";
mostCurrent._panel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Dim Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Dim pin1 As ImageView";
mostCurrent._pin1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Dim pin2 As ImageView";
mostCurrent._pin2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim pin3 As ImageView";
mostCurrent._pin3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Dim pin4 As ImageView";
mostCurrent._pin4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Dim pin5 As ImageView";
mostCurrent._pin5 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Dim pin6 As ImageView";
mostCurrent._pin6 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Dim pin7 As ImageView";
mostCurrent._pin7 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim pin8 As ImageView";
mostCurrent._pin8 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Dim pin9 As ImageView";
mostCurrent._pin9 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Dim pin10 As ImageView";
mostCurrent._pin10 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Dim pin11 As ImageView";
mostCurrent._pin11 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Dim pin12 As ImageView";
mostCurrent._pin12 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim pin13 As ImageView";
mostCurrent._pin13 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Dim pin14 As ImageView";
mostCurrent._pin14 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim pin15 As ImageView";
mostCurrent._pin15 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim pin16 As ImageView";
mostCurrent._pin16 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Dim pin17 As ImageView";
mostCurrent._pin17 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Dim pin18 As ImageView";
mostCurrent._pin18 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim pin19 As ImageView";
mostCurrent._pin19 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Dim pin20 As ImageView";
mostCurrent._pin20 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Dim pin21 As ImageView";
mostCurrent._pin21 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Dim textpin1 As Label";
mostCurrent._textpin1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Dim textpin2 As Label";
mostCurrent._textpin2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Dim textpin3 As Label";
mostCurrent._textpin3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Dim textpin4 As Label";
mostCurrent._textpin4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Dim textpin5 As Label";
mostCurrent._textpin5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Dim textpin6 As Label";
mostCurrent._textpin6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Dim textpin7 As Label";
mostCurrent._textpin7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Dim textpin8 As Label";
mostCurrent._textpin8 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim textpin9 As Label";
mostCurrent._textpin9 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Dim textpin10 As Label";
mostCurrent._textpin10 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Dim textpin11 As Label";
mostCurrent._textpin11 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Dim textpin12 As Label";
mostCurrent._textpin12 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Dim textpin13 As Label";
mostCurrent._textpin13 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Dim textpin14 As Label";
mostCurrent._textpin14 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Dim textpin15 As Label";
mostCurrent._textpin15 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Dim textpin16 As Label";
mostCurrent._textpin16 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Dim textpin17 As Label";
mostCurrent._textpin17 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Dim textpin18 As Label";
mostCurrent._textpin18 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Dim textpin19 As Label";
mostCurrent._textpin19 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Dim textpin20 As Label";
mostCurrent._textpin20 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Dim textpin21 As Label";
mostCurrent._textpin21 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private ImageView0 As ImageView";
mostCurrent._imageview0 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private ImageView2 As ImageView";
mostCurrent._imageview2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private ImageView3 As ImageView";
mostCurrent._imageview3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private ImageView4 As ImageView";
mostCurrent._imageview4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private ImageView5 As ImageView";
mostCurrent._imageview5 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private ImageView6 As ImageView";
mostCurrent._imageview6 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private ImageView7 As ImageView";
mostCurrent._imageview7 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Private ImageView8 As ImageView";
mostCurrent._imageview8 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private ImageView9 As ImageView";
mostCurrent._imageview9 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private ImageView10 As ImageView";
mostCurrent._imageview10 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private ImageView11 As ImageView";
mostCurrent._imageview11 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private ImageView12 As ImageView";
mostCurrent._imageview12 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 73;BA.debugLine="Private ImageView13 As ImageView";
mostCurrent._imageview13 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Private ImageView14 As ImageView";
mostCurrent._imageview14 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private ImageView15 As ImageView";
mostCurrent._imageview15 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Private ImageView16 As ImageView";
mostCurrent._imageview16 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private ImageView17 As ImageView";
mostCurrent._imageview17 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private ImageView18 As ImageView";
mostCurrent._imageview18 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private ImageView19 As ImageView";
mostCurrent._imageview19 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private ImageView20 As ImageView";
mostCurrent._imageview20 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 81;BA.debugLine="Private ImageView21 As ImageView";
mostCurrent._imageview21 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Private back1 As ImageView";
mostCurrent._back1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 84;BA.debugLine="Private back2 As ImageView";
mostCurrent._back2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 85;BA.debugLine="Private back3 As ImageView";
mostCurrent._back3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 86;BA.debugLine="Private back4 As ImageView";
mostCurrent._back4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 87;BA.debugLine="Private back5 As ImageView";
mostCurrent._back5 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 88;BA.debugLine="Private back6 As ImageView";
mostCurrent._back6 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 90;BA.debugLine="Private back7 As ImageView";
mostCurrent._back7 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 93;BA.debugLine="Private mple As ImageView";
mostCurrent._mple = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 94;BA.debugLine="Private simanseislabel As Label";
mostCurrent._simanseislabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 95;BA.debugLine="Private listabel As Label";
mostCurrent._listabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 96;BA.debugLine="Private katigorlabel As Label";
mostCurrent._katigorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 97;BA.debugLine="Private ousialabel As Label";
mostCurrent._ousialabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 98;BA.debugLine="Private ililabel As Label";
mostCurrent._ililabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _gpss_click() throws Exception{
 //BA.debugLineNum = 816;BA.debugLine="Sub gpss_Click";
 //BA.debugLineNum = 818;BA.debugLine="StartActivity(\"gpssingal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssingal"));
 //BA.debugLineNum = 819;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 820;BA.debugLine="End Sub";
return "";
}
public static String  _ili_click() throws Exception{
 //BA.debugLineNum = 794;BA.debugLine="Sub ili_Click";
 //BA.debugLineNum = 795;BA.debugLine="StartActivity(\"simanseis\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("simanseis"));
 //BA.debugLineNum = 796;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 797;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
 //BA.debugLineNum = 838;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 839;BA.debugLine="StartActivity(\"simanseis\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("simanseis"));
 //BA.debugLineNum = 840;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 841;BA.debugLine="End Sub";
return "";
}
public static String  _katigor_click() throws Exception{
 //BA.debugLineNum = 812;BA.debugLine="Sub katigor_Click";
 //BA.debugLineNum = 813;BA.debugLine="StartActivity(\"katigoriess\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("katigoriess"));
 //BA.debugLineNum = 814;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 815;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 830;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 831;BA.debugLine="StartActivity(\"katigoriess\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("katigoriess"));
 //BA.debugLineNum = 832;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 833;BA.debugLine="End Sub";
return "";
}
public static String  _lista_click() throws Exception{
 //BA.debugLineNum = 807;BA.debugLine="Sub lista_Click";
 //BA.debugLineNum = 808;BA.debugLine="StartActivity(\"listaousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("listaousies"));
 //BA.debugLineNum = 809;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 810;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 826;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 827;BA.debugLine="StartActivity(\"listaousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("listaousies"));
 //BA.debugLineNum = 828;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 829;BA.debugLine="End Sub";
return "";
}
public static String  _ousia_click() throws Exception{
 //BA.debugLineNum = 798;BA.debugLine="Sub ousia_Click";
 //BA.debugLineNum = 799;BA.debugLine="StartActivity(\"ousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ousies"));
 //BA.debugLineNum = 800;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 801;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 834;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 835;BA.debugLine="StartActivity(\"ousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ousies"));
 //BA.debugLineNum = 836;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 837;BA.debugLine="End Sub";
return "";
}
public static String  _pin1_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 633;BA.debugLine="Sub pin1_Click";
 //BA.debugLineNum = 634;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 635;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"1.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 636;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 637;BA.debugLine="StartActivity(\"ena\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ena"));
 };
 //BA.debugLineNum = 639;BA.debugLine="End Sub";
return "";
}
public static String  _pin10_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 717;BA.debugLine="Sub pin10_Click";
 //BA.debugLineNum = 718;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 719;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"4.2.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 720;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 721;BA.debugLine="StartActivity(\"tessera2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("tessera2"));
 };
 //BA.debugLineNum = 723;BA.debugLine="End Sub";
return "";
}
public static String  _pin11_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 710;BA.debugLine="Sub pin11_Click";
 //BA.debugLineNum = 711;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 712;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"4.3.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 713;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 714;BA.debugLine="StartActivity(\"tessera3\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("tessera3"));
 };
 //BA.debugLineNum = 716;BA.debugLine="End Sub";
return "";
}
public static String  _pin12_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 703;BA.debugLine="Sub pin12_Click";
 //BA.debugLineNum = 704;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 705;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"5.1.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 706;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 707;BA.debugLine="StartActivity(\"pente\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pente"));
 };
 //BA.debugLineNum = 709;BA.debugLine="End Sub";
return "";
}
public static String  _pin13_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 696;BA.debugLine="Sub pin13_Click";
 //BA.debugLineNum = 697;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 698;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"5.2.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 699;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 700;BA.debugLine="StartActivity(\"pente2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pente2"));
 };
 //BA.debugLineNum = 702;BA.debugLine="End Sub";
return "";
}
public static String  _pin14_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 689;BA.debugLine="Sub pin14_Click";
 //BA.debugLineNum = 690;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 691;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"6.1.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 692;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 693;BA.debugLine="StartActivity(\"exi\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("exi"));
 };
 //BA.debugLineNum = 695;BA.debugLine="End Sub";
return "";
}
public static String  _pin15_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 682;BA.debugLine="Sub pin15_Click";
 //BA.debugLineNum = 683;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 684;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"6.2.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 685;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 686;BA.debugLine="StartActivity(\"exi2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("exi2"));
 };
 //BA.debugLineNum = 688;BA.debugLine="End Sub";
return "";
}
public static String  _pin16_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 675;BA.debugLine="Sub pin16_Click";
 //BA.debugLineNum = 676;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 677;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"7a.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 678;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 679;BA.debugLine="StartActivity(\"epta\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("epta"));
 };
 //BA.debugLineNum = 681;BA.debugLine="End Sub";
return "";
}
public static String  _pin17_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 668;BA.debugLine="Sub pin17_Click";
 //BA.debugLineNum = 669;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 670;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"7b.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 671;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 672;BA.debugLine="StartActivity(\"epta2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("epta2"));
 };
 //BA.debugLineNum = 674;BA.debugLine="End Sub";
return "";
}
public static String  _pin18_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 661;BA.debugLine="Sub pin18_Click";
 //BA.debugLineNum = 662;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 663;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"7c.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 664;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 665;BA.debugLine="StartActivity(\"epta3\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("epta3"));
 };
 //BA.debugLineNum = 667;BA.debugLine="End Sub";
return "";
}
public static String  _pin19_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 654;BA.debugLine="Sub pin19_Click";
 //BA.debugLineNum = 655;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 656;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"7d.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 657;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 658;BA.debugLine="StartActivity(\"epta4\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("epta4"));
 };
 //BA.debugLineNum = 660;BA.debugLine="End Sub";
return "";
}
public static String  _pin2_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 626;BA.debugLine="Sub pin2_Click";
 //BA.debugLineNum = 627;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 628;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"1.4.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 629;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 630;BA.debugLine="StartActivity(\"enatessera\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("enatessera"));
 };
 //BA.debugLineNum = 632;BA.debugLine="End Sub";
return "";
}
public static String  _pin20_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 647;BA.debugLine="Sub pin20_Click";
 //BA.debugLineNum = 648;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 649;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"8.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 650;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 651;BA.debugLine="StartActivity(\"okto\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("okto"));
 };
 //BA.debugLineNum = 653;BA.debugLine="End Sub";
return "";
}
public static String  _pin21_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 640;BA.debugLine="Sub pin21_Click";
 //BA.debugLineNum = 641;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 642;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"9.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 643;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 644;BA.debugLine="StartActivity(\"ennia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ennia"));
 };
 //BA.debugLineNum = 646;BA.debugLine="End Sub";
return "";
}
public static String  _pin3_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 619;BA.debugLine="Sub pin3_Click";
 //BA.debugLineNum = 620;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 621;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"1.5.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 622;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 623;BA.debugLine="StartActivity(\"enapente\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("enapente"));
 };
 //BA.debugLineNum = 625;BA.debugLine="End Sub";
return "";
}
public static String  _pin4_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 612;BA.debugLine="Sub pin4_Click";
 //BA.debugLineNum = 613;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 614;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"1.6.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 615;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 616;BA.debugLine="StartActivity(\"ena6\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ena6"));
 };
 //BA.debugLineNum = 618;BA.debugLine="End Sub";
return "";
}
public static String  _pin5_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 605;BA.debugLine="Sub pin5_Click";
 //BA.debugLineNum = 606;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 607;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"2.1.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 608;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 609;BA.debugLine="StartActivity(\"dyo\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("dyo"));
 };
 //BA.debugLineNum = 611;BA.debugLine="End Sub";
return "";
}
public static String  _pin6_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 598;BA.debugLine="Sub pin6_Click";
 //BA.debugLineNum = 599;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 600;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"   \"";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("   "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"2.2.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 601;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 602;BA.debugLine="StartActivity(\"dyo2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("dyo2"));
 };
 //BA.debugLineNum = 604;BA.debugLine="End Sub";
return "";
}
public static String  _pin7_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 591;BA.debugLine="Sub pin7_Click";
 //BA.debugLineNum = 592;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 593;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"2.3.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 594;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 595;BA.debugLine="StartActivity(\"dyo3\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("dyo3"));
 };
 //BA.debugLineNum = 597;BA.debugLine="End Sub";
return "";
}
public static String  _pin8_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 584;BA.debugLine="Sub pin8_Click";
 //BA.debugLineNum = 585;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 586;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"3.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 587;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 588;BA.debugLine="StartActivity(\"tria\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("tria"));
 };
 //BA.debugLineNum = 590;BA.debugLine="End Sub";
return "";
}
public static String  _pin9_click() throws Exception{
int _result = 0;
 //BA.debugLineNum = 577;BA.debugLine="Sub pin9_Click";
 //BA.debugLineNum = 578;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 579;BA.debugLine="result = Msgbox2(\"Μετάβαση στην κατηγορία;\", \"  \",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Μετάβαση στην κατηγορία;"),BA.ObjectToCharSequence("  "),"Ναι","","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"4.1.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 580;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 581;BA.debugLine="StartActivity(\"tesera\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("tesera"));
 };
 //BA.debugLineNum = 583;BA.debugLine="End Sub";
return "";
}
public static String  _pixi_click() throws Exception{
 //BA.debugLineNum = 802;BA.debugLine="Sub pixi_Click";
 //BA.debugLineNum = 803;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 804;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 805;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 822;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 823;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 //BA.debugLineNum = 824;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 825;BA.debugLine="End Sub";
return "";
}
public static String  _simansi_click() throws Exception{
 //BA.debugLineNum = 788;BA.debugLine="Sub simansi_Click";
 //BA.debugLineNum = 789;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 //BA.debugLineNum = 790;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 791;BA.debugLine="End Sub";
return "";
}
public static String  _textpin1_click() throws Exception{
 //BA.debugLineNum = 785;BA.debugLine="Sub textpin1_Click";
 //BA.debugLineNum = 786;BA.debugLine="StartActivity(\"ena\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ena"));
 //BA.debugLineNum = 787;BA.debugLine="End Sub";
return "";
}
public static String  _textpin10_click() throws Exception{
 //BA.debugLineNum = 782;BA.debugLine="Sub textpin10_Click";
 //BA.debugLineNum = 783;BA.debugLine="StartActivity(\"tessera2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("tessera2"));
 //BA.debugLineNum = 784;BA.debugLine="End Sub";
return "";
}
public static String  _textpin11_click() throws Exception{
 //BA.debugLineNum = 779;BA.debugLine="Sub textpin11_Click";
 //BA.debugLineNum = 780;BA.debugLine="StartActivity(\"tessera3\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("tessera3"));
 //BA.debugLineNum = 781;BA.debugLine="End Sub";
return "";
}
public static String  _textpin12_click() throws Exception{
 //BA.debugLineNum = 776;BA.debugLine="Sub textpin12_Click";
 //BA.debugLineNum = 777;BA.debugLine="StartActivity(\"pente\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pente"));
 //BA.debugLineNum = 778;BA.debugLine="End Sub";
return "";
}
public static String  _textpin13_click() throws Exception{
 //BA.debugLineNum = 773;BA.debugLine="Sub textpin13_Click";
 //BA.debugLineNum = 774;BA.debugLine="StartActivity(\"pente2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pente2"));
 //BA.debugLineNum = 775;BA.debugLine="End Sub";
return "";
}
public static String  _textpin14_click() throws Exception{
 //BA.debugLineNum = 770;BA.debugLine="Sub textpin14_Click";
 //BA.debugLineNum = 771;BA.debugLine="StartActivity(\"exi\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("exi"));
 //BA.debugLineNum = 772;BA.debugLine="End Sub";
return "";
}
public static String  _textpin15_click() throws Exception{
 //BA.debugLineNum = 767;BA.debugLine="Sub textpin15_Click";
 //BA.debugLineNum = 768;BA.debugLine="StartActivity(\"exi2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("exi2"));
 //BA.debugLineNum = 769;BA.debugLine="End Sub";
return "";
}
public static String  _textpin16_click() throws Exception{
 //BA.debugLineNum = 764;BA.debugLine="Sub textpin16_Click";
 //BA.debugLineNum = 765;BA.debugLine="StartActivity(\"epta\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("epta"));
 //BA.debugLineNum = 766;BA.debugLine="End Sub";
return "";
}
public static String  _textpin17_click() throws Exception{
 //BA.debugLineNum = 761;BA.debugLine="Sub textpin17_Click";
 //BA.debugLineNum = 762;BA.debugLine="StartActivity(\"epta2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("epta2"));
 //BA.debugLineNum = 763;BA.debugLine="End Sub";
return "";
}
public static String  _textpin18_click() throws Exception{
 //BA.debugLineNum = 758;BA.debugLine="Sub textpin18_Click";
 //BA.debugLineNum = 759;BA.debugLine="StartActivity(\"epta3\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("epta3"));
 //BA.debugLineNum = 760;BA.debugLine="End Sub";
return "";
}
public static String  _textpin19_click() throws Exception{
 //BA.debugLineNum = 755;BA.debugLine="Sub textpin19_Click";
 //BA.debugLineNum = 756;BA.debugLine="StartActivity(\"epta4\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("epta4"));
 //BA.debugLineNum = 757;BA.debugLine="End Sub";
return "";
}
public static String  _textpin2_click() throws Exception{
 //BA.debugLineNum = 752;BA.debugLine="Sub textpin2_Click";
 //BA.debugLineNum = 753;BA.debugLine="StartActivity(\"enatessera\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("enatessera"));
 //BA.debugLineNum = 754;BA.debugLine="End Sub";
return "";
}
public static String  _textpin20_click() throws Exception{
 //BA.debugLineNum = 749;BA.debugLine="Sub textpin20_Click";
 //BA.debugLineNum = 750;BA.debugLine="StartActivity(\"okto\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("okto"));
 //BA.debugLineNum = 751;BA.debugLine="End Sub";
return "";
}
public static String  _textpin21_click() throws Exception{
 //BA.debugLineNum = 746;BA.debugLine="Sub textpin21_Click";
 //BA.debugLineNum = 747;BA.debugLine="StartActivity(\"ennia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ennia"));
 //BA.debugLineNum = 748;BA.debugLine="End Sub";
return "";
}
public static String  _textpin3_click() throws Exception{
 //BA.debugLineNum = 743;BA.debugLine="Sub textpin3_Click";
 //BA.debugLineNum = 744;BA.debugLine="StartActivity(\"enapente\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("enapente"));
 //BA.debugLineNum = 745;BA.debugLine="End Sub";
return "";
}
public static String  _textpin4_click() throws Exception{
 //BA.debugLineNum = 740;BA.debugLine="Sub textpin4_Click";
 //BA.debugLineNum = 741;BA.debugLine="StartActivity(\"ena6\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ena6"));
 //BA.debugLineNum = 742;BA.debugLine="End Sub";
return "";
}
public static String  _textpin5_click() throws Exception{
 //BA.debugLineNum = 737;BA.debugLine="Sub textpin5_Click";
 //BA.debugLineNum = 738;BA.debugLine="StartActivity(\"dyo\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("dyo"));
 //BA.debugLineNum = 739;BA.debugLine="End Sub";
return "";
}
public static String  _textpin6_click() throws Exception{
 //BA.debugLineNum = 734;BA.debugLine="Sub textpin6_Click";
 //BA.debugLineNum = 735;BA.debugLine="StartActivity(\"dyo2\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("dyo2"));
 //BA.debugLineNum = 736;BA.debugLine="End Sub";
return "";
}
public static String  _textpin7_click() throws Exception{
 //BA.debugLineNum = 731;BA.debugLine="Sub textpin7_Click";
 //BA.debugLineNum = 732;BA.debugLine="StartActivity(\"dyo3\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("dyo3"));
 //BA.debugLineNum = 733;BA.debugLine="End Sub";
return "";
}
public static String  _textpin8_click() throws Exception{
 //BA.debugLineNum = 728;BA.debugLine="Sub textpin8_Click";
 //BA.debugLineNum = 729;BA.debugLine="StartActivity(\"tria\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("tria"));
 //BA.debugLineNum = 730;BA.debugLine="End Sub";
return "";
}
public static String  _textpin9_click() throws Exception{
 //BA.debugLineNum = 725;BA.debugLine="Sub textpin9_Click";
 //BA.debugLineNum = 726;BA.debugLine="StartActivity(\"tesera\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("tesera"));
 //BA.debugLineNum = 727;BA.debugLine="End Sub";
return "";
}
}
