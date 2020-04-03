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

public class firstaid extends Activity implements B4AActivity{
	public static firstaid mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.firstaid");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (firstaid).");
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
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.firstaid");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.firstaid", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (firstaid) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (firstaid) Resume **");
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
		return firstaid.class;
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
        BA.LogInfo("** Activity (firstaid) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            firstaid mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (firstaid) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _textpin1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin8 = null;
public anywheresoftware.b4a.objects.LabelWrapper _textpin9 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin5 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin6 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin7 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin8 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _pin9 = null;
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
 //BA.debugLineNum = 76;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 77;BA.debugLine="Activity.LoadLayout(\"first.bal\")";
mostCurrent._activity.LoadLayout("first.bal",mostCurrent.activityBA);
 //BA.debugLineNum = 78;BA.debugLine="sc.initialize(1000dip)";
mostCurrent._sc.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1000)));
 //BA.debugLineNum = 79;BA.debugLine="Activity.AddView(sc,3%x,33%y,94%x,57.5%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._sc.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (57.5),mostCurrent.activityBA));
 //BA.debugLineNum = 81;BA.debugLine="sc.Panel.Width = 96%x";
mostCurrent._sc.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (96),mostCurrent.activityBA));
 //BA.debugLineNum = 82;BA.debugLine="sc.Panel.Height = 187%y";
mostCurrent._sc.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (187),mostCurrent.activityBA));
 //BA.debugLineNum = 84;BA.debugLine="Panel1.RemoveView";
mostCurrent._panel1.RemoveView();
 //BA.debugLineNum = 85;BA.debugLine="sc.Panel.AddView( Panel1,0%x,-9%y,94%x,210%y)";
mostCurrent._sc.getPanel().AddView((android.view.View)(mostCurrent._panel1.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),(int) (-anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (9),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (210),mostCurrent.activityBA));
 //BA.debugLineNum = 87;BA.debugLine="textpin1.textcolor = Colors.black";
mostCurrent._textpin1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 88;BA.debugLine="textpin2.textcolor = Colors.black";
mostCurrent._textpin2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 89;BA.debugLine="textpin3.textcolor = Colors.black";
mostCurrent._textpin3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 90;BA.debugLine="textpin4.textcolor = Colors.black";
mostCurrent._textpin4.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 91;BA.debugLine="textpin5.textcolor = Colors.black";
mostCurrent._textpin5.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 92;BA.debugLine="textpin6.textcolor = Colors.black";
mostCurrent._textpin6.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 93;BA.debugLine="textpin7.textcolor = Colors.black";
mostCurrent._textpin7.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 94;BA.debugLine="textpin8.textcolor = Colors.black";
mostCurrent._textpin8.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 95;BA.debugLine="textpin9.textcolor = Colors.black";
mostCurrent._textpin9.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 96;BA.debugLine="textpin1.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 97;BA.debugLine="textpin2.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 98;BA.debugLine="textpin3.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 99;BA.debugLine="textpin4.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin4.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 100;BA.debugLine="textpin5.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin5.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 101;BA.debugLine="textpin6.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin6.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 102;BA.debugLine="textpin7.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin7.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 103;BA.debugLine="textpin8.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin8.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 104;BA.debugLine="textpin9.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._textpin9.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 108;BA.debugLine="textpin1.TextSize = 12";
mostCurrent._textpin1.setTextSize((float) (12));
 //BA.debugLineNum = 109;BA.debugLine="textpin2.TextSize = 12";
mostCurrent._textpin2.setTextSize((float) (12));
 //BA.debugLineNum = 110;BA.debugLine="textpin3.TextSize = 12";
mostCurrent._textpin3.setTextSize((float) (12));
 //BA.debugLineNum = 112;BA.debugLine="textpin4.TextSize = 12";
mostCurrent._textpin4.setTextSize((float) (12));
 //BA.debugLineNum = 113;BA.debugLine="textpin5.TextSize = 12";
mostCurrent._textpin5.setTextSize((float) (12));
 //BA.debugLineNum = 115;BA.debugLine="textpin6.TextSize = 12";
mostCurrent._textpin6.setTextSize((float) (12));
 //BA.debugLineNum = 116;BA.debugLine="textpin7.TextSize = 12";
mostCurrent._textpin7.setTextSize((float) (12));
 //BA.debugLineNum = 118;BA.debugLine="textpin8.TextSize = 12";
mostCurrent._textpin8.setTextSize((float) (12));
 //BA.debugLineNum = 119;BA.debugLine="textpin9.TextSize = 12";
mostCurrent._textpin9.setTextSize((float) (12));
 //BA.debugLineNum = 122;BA.debugLine="ImageView0.Top = 9%y";
mostCurrent._imageview0.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (9),mostCurrent.activityBA));
 //BA.debugLineNum = 123;BA.debugLine="ImageView0.Left = 0%x";
mostCurrent._imageview0.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 124;BA.debugLine="ImageView0.Width = 100%x";
mostCurrent._imageview0.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 125;BA.debugLine="ImageView0.Height = 1%y";
mostCurrent._imageview0.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 127;BA.debugLine="pin1.Top = 10%y";
mostCurrent._pin1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 128;BA.debugLine="pin1.Left = 0%x";
mostCurrent._pin1.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 129;BA.debugLine="pin1.Width = 20%x";
mostCurrent._pin1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 130;BA.debugLine="pin1.Height = 14%y";
mostCurrent._pin1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 132;BA.debugLine="textpin1.Top = 10%y";
mostCurrent._textpin1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 133;BA.debugLine="textpin1.Left = 25%x";
mostCurrent._textpin1.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 134;BA.debugLine="textpin1.Width = 70%x";
mostCurrent._textpin1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 135;BA.debugLine="textpin1.Height = 14%y";
mostCurrent._textpin1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 138;BA.debugLine="ImageView1.Top = 26%y";
mostCurrent._imageview1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (26),mostCurrent.activityBA));
 //BA.debugLineNum = 139;BA.debugLine="ImageView1.Left = 0%x";
mostCurrent._imageview1.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 140;BA.debugLine="ImageView1.Width = 100%x";
mostCurrent._imageview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 141;BA.debugLine="ImageView1.Height = 1%y";
mostCurrent._imageview1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 145;BA.debugLine="pin2.Top = 30%y";
mostCurrent._pin2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
 //BA.debugLineNum = 146;BA.debugLine="pin2.Left = 0%x";
mostCurrent._pin2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 147;BA.debugLine="pin2.Width = 20%x";
mostCurrent._pin2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 148;BA.debugLine="pin2.Height = 14%y";
mostCurrent._pin2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 149;BA.debugLine="ImageView2.Top = 46%y";
mostCurrent._imageview2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (46),mostCurrent.activityBA));
 //BA.debugLineNum = 150;BA.debugLine="ImageView2.Left = 0%x";
mostCurrent._imageview2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 151;BA.debugLine="ImageView2.Width = 100%x";
mostCurrent._imageview2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 152;BA.debugLine="ImageView2.Height = 1%y";
mostCurrent._imageview2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 154;BA.debugLine="textpin2.Top = 30%y";
mostCurrent._textpin2.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
 //BA.debugLineNum = 155;BA.debugLine="textpin2.Left = 25%x";
mostCurrent._textpin2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 156;BA.debugLine="textpin2.Width = 70%x";
mostCurrent._textpin2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 157;BA.debugLine="textpin2.Height = 14%y";
mostCurrent._textpin2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 161;BA.debugLine="pin3.Top = 50%y";
mostCurrent._pin3.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
 //BA.debugLineNum = 162;BA.debugLine="pin3.Left = 0%x";
mostCurrent._pin3.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 163;BA.debugLine="pin3.Width = 20%x";
mostCurrent._pin3.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 164;BA.debugLine="pin3.Height = 14%y";
mostCurrent._pin3.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 165;BA.debugLine="ImageView3.Top = 66%y";
mostCurrent._imageview3.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (66),mostCurrent.activityBA));
 //BA.debugLineNum = 166;BA.debugLine="ImageView3.Left = 0%x";
mostCurrent._imageview3.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 167;BA.debugLine="ImageView3.Width = 100%x";
mostCurrent._imageview3.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 168;BA.debugLine="ImageView3.Height = 1%y";
mostCurrent._imageview3.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 170;BA.debugLine="textpin3.Top = 50%y";
mostCurrent._textpin3.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA));
 //BA.debugLineNum = 171;BA.debugLine="textpin3.Left = 25%x";
mostCurrent._textpin3.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 172;BA.debugLine="textpin3.Width = 70%x";
mostCurrent._textpin3.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 173;BA.debugLine="textpin3.Height = 14%y";
mostCurrent._textpin3.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 177;BA.debugLine="pin4.Top = 70%y";
mostCurrent._pin4.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 178;BA.debugLine="pin4.Left = 0%x";
mostCurrent._pin4.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 179;BA.debugLine="pin4.Width = 20%x";
mostCurrent._pin4.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 180;BA.debugLine="pin4.Height = 14%y";
mostCurrent._pin4.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 181;BA.debugLine="ImageView4.Top = 86%y";
mostCurrent._imageview4.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (86),mostCurrent.activityBA));
 //BA.debugLineNum = 182;BA.debugLine="ImageView4.Left = 0%x";
mostCurrent._imageview4.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 183;BA.debugLine="ImageView4.Width = 100%x";
mostCurrent._imageview4.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 184;BA.debugLine="ImageView4.Height = 1%y";
mostCurrent._imageview4.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 186;BA.debugLine="textpin4.Top = 70%y";
mostCurrent._textpin4.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 187;BA.debugLine="textpin4.Left = 25%x";
mostCurrent._textpin4.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 188;BA.debugLine="textpin4.Width = 70%x";
mostCurrent._textpin4.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 189;BA.debugLine="textpin4.Height = 14%y";
mostCurrent._textpin4.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 193;BA.debugLine="pin5.Top = 90%y";
mostCurrent._pin5.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (90),mostCurrent.activityBA));
 //BA.debugLineNum = 194;BA.debugLine="pin5.Left = 0%x";
mostCurrent._pin5.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 195;BA.debugLine="pin5.Width = 20%x";
mostCurrent._pin5.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 196;BA.debugLine="pin5.Height = 14%y";
mostCurrent._pin5.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 197;BA.debugLine="ImageView5.Top = 106%y";
mostCurrent._imageview5.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (106),mostCurrent.activityBA));
 //BA.debugLineNum = 198;BA.debugLine="ImageView5.Left = 0%x";
mostCurrent._imageview5.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 199;BA.debugLine="ImageView5.Width = 100%x";
mostCurrent._imageview5.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 200;BA.debugLine="ImageView5.Height = 1%y";
mostCurrent._imageview5.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 202;BA.debugLine="textpin5.Top = 90%y";
mostCurrent._textpin5.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (90),mostCurrent.activityBA));
 //BA.debugLineNum = 203;BA.debugLine="textpin5.Left = 25%x";
mostCurrent._textpin5.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 204;BA.debugLine="textpin5.Width = 70%x";
mostCurrent._textpin5.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 205;BA.debugLine="textpin5.Height = 14%y";
mostCurrent._textpin5.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 211;BA.debugLine="pin6.Top = 110%y";
mostCurrent._pin6.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (110),mostCurrent.activityBA));
 //BA.debugLineNum = 212;BA.debugLine="pin6.Left = 0%x";
mostCurrent._pin6.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 213;BA.debugLine="pin6.Width = 20%x";
mostCurrent._pin6.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 214;BA.debugLine="pin6.Height = 14%y";
mostCurrent._pin6.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 215;BA.debugLine="ImageView6.Top = 126%y";
mostCurrent._imageview6.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (126),mostCurrent.activityBA));
 //BA.debugLineNum = 216;BA.debugLine="ImageView6.Left = 0%x";
mostCurrent._imageview6.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 217;BA.debugLine="ImageView6.Width = 100%x";
mostCurrent._imageview6.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 218;BA.debugLine="ImageView6.Height = 1%y";
mostCurrent._imageview6.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 220;BA.debugLine="textpin6.Top = 110%y";
mostCurrent._textpin6.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (110),mostCurrent.activityBA));
 //BA.debugLineNum = 221;BA.debugLine="textpin6.Left = 25%x";
mostCurrent._textpin6.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 222;BA.debugLine="textpin6.Width = 70%x";
mostCurrent._textpin6.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 223;BA.debugLine="textpin6.Height = 14%y";
mostCurrent._textpin6.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 227;BA.debugLine="pin7.Top = 130%y";
mostCurrent._pin7.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (130),mostCurrent.activityBA));
 //BA.debugLineNum = 228;BA.debugLine="pin7.Left = 0%x";
mostCurrent._pin7.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 229;BA.debugLine="pin7.Width = 20%x";
mostCurrent._pin7.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 230;BA.debugLine="pin7.Height = 14%y";
mostCurrent._pin7.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 231;BA.debugLine="ImageView7.Top = 146%y";
mostCurrent._imageview7.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (146),mostCurrent.activityBA));
 //BA.debugLineNum = 232;BA.debugLine="ImageView7.Left = 0%x";
mostCurrent._imageview7.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 233;BA.debugLine="ImageView7.Width = 100%x";
mostCurrent._imageview7.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 234;BA.debugLine="ImageView7.Height = 1%y";
mostCurrent._imageview7.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 237;BA.debugLine="textpin7.Top = 130%y";
mostCurrent._textpin7.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (130),mostCurrent.activityBA));
 //BA.debugLineNum = 238;BA.debugLine="textpin7.Left = 25%x";
mostCurrent._textpin7.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 239;BA.debugLine="textpin7.Width = 70%x";
mostCurrent._textpin7.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 240;BA.debugLine="textpin7.Height = 14%y";
mostCurrent._textpin7.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 242;BA.debugLine="pin9.Top = 150%y";
mostCurrent._pin9.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (150),mostCurrent.activityBA));
 //BA.debugLineNum = 243;BA.debugLine="pin9.Left = 0%x";
mostCurrent._pin9.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 244;BA.debugLine="pin9.Width = 20%x";
mostCurrent._pin9.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 245;BA.debugLine="pin9.Height = 14%y";
mostCurrent._pin9.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 246;BA.debugLine="ImageView9.Top = 166%y";
mostCurrent._imageview9.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (166),mostCurrent.activityBA));
 //BA.debugLineNum = 247;BA.debugLine="ImageView9.Left = 0%x";
mostCurrent._imageview9.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 248;BA.debugLine="ImageView9.Width = 100%x";
mostCurrent._imageview9.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 249;BA.debugLine="ImageView9.Height = 1%y";
mostCurrent._imageview9.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 252;BA.debugLine="textpin9.Top = 150%y";
mostCurrent._textpin9.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (150),mostCurrent.activityBA));
 //BA.debugLineNum = 253;BA.debugLine="textpin9.Left = 25%x";
mostCurrent._textpin9.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 254;BA.debugLine="textpin9.Width = 70%x";
mostCurrent._textpin9.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 255;BA.debugLine="textpin9.Height = 14%y";
mostCurrent._textpin9.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 259;BA.debugLine="pin8.Top = 170%y";
mostCurrent._pin8.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (170),mostCurrent.activityBA));
 //BA.debugLineNum = 260;BA.debugLine="pin8.Left = 0%x";
mostCurrent._pin8.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 261;BA.debugLine="pin8.Width = 20%x";
mostCurrent._pin8.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA));
 //BA.debugLineNum = 262;BA.debugLine="pin8.Height = 14%y";
mostCurrent._pin8.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 263;BA.debugLine="ImageView8.Top = 186%y";
mostCurrent._imageview8.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (186),mostCurrent.activityBA));
 //BA.debugLineNum = 264;BA.debugLine="ImageView8.Left = 0%x";
mostCurrent._imageview8.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 //BA.debugLineNum = 265;BA.debugLine="ImageView8.Width = 100%x";
mostCurrent._imageview8.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 266;BA.debugLine="ImageView8.Height = 1%y";
mostCurrent._imageview8.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 //BA.debugLineNum = 269;BA.debugLine="textpin8.Top = 170%y";
mostCurrent._textpin8.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (170),mostCurrent.activityBA));
 //BA.debugLineNum = 270;BA.debugLine="textpin8.Left = 25%x";
mostCurrent._textpin8.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
 //BA.debugLineNum = 271;BA.debugLine="textpin8.Width = 70%x";
mostCurrent._textpin8.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 272;BA.debugLine="textpin8.Height = 14%y";
mostCurrent._textpin8.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
 //BA.debugLineNum = 283;BA.debugLine="simanseislabel.Top = 3%y";
mostCurrent._simanseislabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 284;BA.debugLine="simanseislabel.left = 3.5%x";
mostCurrent._simanseislabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3.5),mostCurrent.activityBA));
 //BA.debugLineNum = 285;BA.debugLine="simanseislabel.height = 27.5%y";
mostCurrent._simanseislabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (27.5),mostCurrent.activityBA));
 //BA.debugLineNum = 286;BA.debugLine="simanseislabel.Width  = 45%x";
mostCurrent._simanseislabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 287;BA.debugLine="simansi.Top = 3%y";
mostCurrent._simansi.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 288;BA.debugLine="simansi.left = 3%x";
mostCurrent._simansi.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 289;BA.debugLine="simansi.height = 28%y";
mostCurrent._simansi.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (28),mostCurrent.activityBA));
 //BA.debugLineNum = 290;BA.debugLine="simansi.Width  = 45%x";
mostCurrent._simansi.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 295;BA.debugLine="lista.Top = 3%y";
mostCurrent._lista.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 296;BA.debugLine="lista.left = 51.5%x";
mostCurrent._lista.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.5),mostCurrent.activityBA));
 //BA.debugLineNum = 297;BA.debugLine="lista.height = 13%y";
mostCurrent._lista.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 298;BA.debugLine="lista.Width  = 21.25%x";
mostCurrent._lista.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 300;BA.debugLine="listabel.Top = 3%y";
mostCurrent._listabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 301;BA.debugLine="listabel.left = 51.75%x";
mostCurrent._listabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 302;BA.debugLine="listabel.height = 13%y";
mostCurrent._listabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 303;BA.debugLine="listabel.Width  = 21.25%x";
mostCurrent._listabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 307;BA.debugLine="katigor.Top = 18%y";
mostCurrent._katigor.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 308;BA.debugLine="katigor.left = 51.50%x";
mostCurrent._katigor.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.50),mostCurrent.activityBA));
 //BA.debugLineNum = 309;BA.debugLine="katigor.height = 13%y";
mostCurrent._katigor.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 310;BA.debugLine="katigor.Width  = 21.25%x";
mostCurrent._katigor.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 312;BA.debugLine="katigorlabel.Top = 18%y";
mostCurrent._katigorlabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 313;BA.debugLine="katigorlabel.left = 51.75%x";
mostCurrent._katigorlabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 314;BA.debugLine="katigorlabel.height = 13%y";
mostCurrent._katigorlabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 315;BA.debugLine="katigorlabel.Width  = 21.25%x";
mostCurrent._katigorlabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 317;BA.debugLine="ousia.Top = 3%y";
mostCurrent._ousia.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 318;BA.debugLine="ousia.left = 75.75%x";
mostCurrent._ousia.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75.75),mostCurrent.activityBA));
 //BA.debugLineNum = 319;BA.debugLine="ousia.height = 13%y";
mostCurrent._ousia.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 320;BA.debugLine="ousia.Width  = 21.25%x";
mostCurrent._ousia.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 321;BA.debugLine="ousialabel.Top = 3%y";
mostCurrent._ousialabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 322;BA.debugLine="ousialabel.left = 76%x";
mostCurrent._ousialabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 323;BA.debugLine="ousialabel.height = 13%y";
mostCurrent._ousialabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 324;BA.debugLine="ousialabel.Width  = 21.25%x";
mostCurrent._ousialabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 326;BA.debugLine="ili.Top = 18%y";
mostCurrent._ili.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 327;BA.debugLine="ili.left = 75.75%x";
mostCurrent._ili.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (75.75),mostCurrent.activityBA));
 //BA.debugLineNum = 328;BA.debugLine="ili.height = 13%y";
mostCurrent._ili.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 329;BA.debugLine="ili.Width  = 21.25%x";
mostCurrent._ili.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 330;BA.debugLine="ililabel.Top = 18%y";
mostCurrent._ililabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
 //BA.debugLineNum = 331;BA.debugLine="ililabel.left = 76%x";
mostCurrent._ililabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 332;BA.debugLine="ililabel.height = 13%y";
mostCurrent._ililabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 333;BA.debugLine="ililabel.Width  = 21.25%x";
mostCurrent._ililabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 336;BA.debugLine="mple.top = 93%y";
mostCurrent._mple.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (93),mostCurrent.activityBA));
 //BA.debugLineNum = 337;BA.debugLine="mple.left = 3%x";
mostCurrent._mple.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 338;BA.debugLine="mple.width = 94%x";
mostCurrent._mple.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 339;BA.debugLine="mple.height = 7%y";
mostCurrent._mple.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (7),mostCurrent.activityBA));
 //BA.debugLineNum = 341;BA.debugLine="simanseislabel.BringToFront";
mostCurrent._simanseislabel.BringToFront();
 //BA.debugLineNum = 342;BA.debugLine="listabel.BringToFront";
mostCurrent._listabel.BringToFront();
 //BA.debugLineNum = 343;BA.debugLine="katigorlabel.BringToFront";
mostCurrent._katigorlabel.BringToFront();
 //BA.debugLineNum = 344;BA.debugLine="ousialabel.BringToFront";
mostCurrent._ousialabel.BringToFront();
 //BA.debugLineNum = 345;BA.debugLine="ililabel.BringToFront";
mostCurrent._ililabel.BringToFront();
 //BA.debugLineNum = 347;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 467;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 468;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 470;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 472;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 353;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 355;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 349;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 15;BA.debugLine="Dim ili As Button";
mostCurrent._ili = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Dim ousia As Button";
mostCurrent._ousia = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim simansi As Button";
mostCurrent._simansi = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Dim pixi As Button";
mostCurrent._pixi = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Dim lista As Button";
mostCurrent._lista = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private katigor As Button";
mostCurrent._katigor = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Dim fakos As Label";
mostCurrent._fakos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private mple As ImageView";
mostCurrent._mple = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private simanseislabel As Label";
mostCurrent._simanseislabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private listabel As Label";
mostCurrent._listabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private katigorlabel As Label";
mostCurrent._katigorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private ousialabel As Label";
mostCurrent._ousialabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private ililabel As Label";
mostCurrent._ililabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Dim textpin1 As Label";
mostCurrent._textpin1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Dim textpin2 As Label";
mostCurrent._textpin2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Dim textpin3 As Label";
mostCurrent._textpin3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Dim textpin4 As Label";
mostCurrent._textpin4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Dim textpin5 As Label";
mostCurrent._textpin5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Dim textpin6 As Label";
mostCurrent._textpin6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Dim textpin7 As Label";
mostCurrent._textpin7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Dim textpin8 As Label";
mostCurrent._textpin8 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Dim textpin9 As Label";
mostCurrent._textpin9 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Dim pin1 As ImageView";
mostCurrent._pin1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Dim pin2 As ImageView";
mostCurrent._pin2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim pin3 As ImageView";
mostCurrent._pin3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Dim pin4 As ImageView";
mostCurrent._pin4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Dim pin5 As ImageView";
mostCurrent._pin5 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Dim pin6 As ImageView";
mostCurrent._pin6 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Dim pin7 As ImageView";
mostCurrent._pin7 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Dim pin8 As ImageView";
mostCurrent._pin8 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Dim pin9 As ImageView";
mostCurrent._pin9 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private ImageView0 As ImageView";
mostCurrent._imageview0 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private ImageView2 As ImageView";
mostCurrent._imageview2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private ImageView3 As ImageView";
mostCurrent._imageview3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private ImageView4 As ImageView";
mostCurrent._imageview4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private ImageView5 As ImageView";
mostCurrent._imageview5 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private ImageView6 As ImageView";
mostCurrent._imageview6 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private ImageView7 As ImageView";
mostCurrent._imageview7 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private ImageView8 As ImageView";
mostCurrent._imageview8 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private ImageView9 As ImageView";
mostCurrent._imageview9 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public static String  _ili_click() throws Exception{
 //BA.debugLineNum = 418;BA.debugLine="Sub ili_Click";
 //BA.debugLineNum = 419;BA.debugLine="StartActivity(\"camera\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("camera"));
 //BA.debugLineNum = 420;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 421;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
 //BA.debugLineNum = 458;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 459;BA.debugLine="StartActivity(\"camera\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("camera"));
 //BA.debugLineNum = 460;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 461;BA.debugLine="End Sub";
return "";
}
public static String  _katigor_click() throws Exception{
 //BA.debugLineNum = 436;BA.debugLine="Sub katigor_Click";
 //BA.debugLineNum = 437;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 438;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 450;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 451;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 452;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 453;BA.debugLine="End Sub";
return "";
}
public static String  _lista_click() throws Exception{
 //BA.debugLineNum = 431;BA.debugLine="Sub lista_Click";
 //BA.debugLineNum = 432;BA.debugLine="StartActivity(\"thlefona\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("thlefona"));
 //BA.debugLineNum = 433;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 446;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 447;BA.debugLine="StartActivity(\"thlefona\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("thlefona"));
 //BA.debugLineNum = 448;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 449;BA.debugLine="End Sub";
return "";
}
public static String  _ousia_click() throws Exception{
 //BA.debugLineNum = 422;BA.debugLine="Sub ousia_Click";
 //BA.debugLineNum = 423;BA.debugLine="StartActivity(\"gpssignal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssignal"));
 //BA.debugLineNum = 424;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 425;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 454;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 455;BA.debugLine="StartActivity(\"gpssignal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssignal"));
 //BA.debugLineNum = 456;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 457;BA.debugLine="End Sub";
return "";
}
public static String  _pin1_click() throws Exception{
 //BA.debugLineNum = 411;BA.debugLine="Sub pin1_Click";
 //BA.debugLineNum = 412;BA.debugLine="StartActivity(\"aimoragia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("aimoragia"));
 //BA.debugLineNum = 413;BA.debugLine="End Sub";
return "";
}
public static String  _pin2_click() throws Exception{
 //BA.debugLineNum = 408;BA.debugLine="Sub pin2_Click";
 //BA.debugLineNum = 409;BA.debugLine="StartActivity(\"katagma\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("katagma"));
 //BA.debugLineNum = 410;BA.debugLine="End Sub";
return "";
}
public static String  _pin3_click() throws Exception{
 //BA.debugLineNum = 405;BA.debugLine="Sub pin3_Click";
 //BA.debugLineNum = 406;BA.debugLine="StartActivity(\"pnigmos\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pnigmos"));
 //BA.debugLineNum = 407;BA.debugLine="End Sub";
return "";
}
public static String  _pin4_click() throws Exception{
 //BA.debugLineNum = 402;BA.debugLine="Sub pin4_Click";
 //BA.debugLineNum = 403;BA.debugLine="StartActivity(\"lypothimia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("lypothimia"));
 //BA.debugLineNum = 404;BA.debugLine="End Sub";
return "";
}
public static String  _pin5_click() throws Exception{
 //BA.debugLineNum = 399;BA.debugLine="Sub pin5_Click";
 //BA.debugLineNum = 400;BA.debugLine="StartActivity(\"ypothermia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ypothermia"));
 //BA.debugLineNum = 401;BA.debugLine="End Sub";
return "";
}
public static String  _pin6_click() throws Exception{
 //BA.debugLineNum = 396;BA.debugLine="Sub pin6_Click";
 //BA.debugLineNum = 397;BA.debugLine="StartActivity(\"thermoplixia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("thermoplixia"));
 //BA.debugLineNum = 398;BA.debugLine="End Sub";
return "";
}
public static String  _pin7_click() throws Exception{
 //BA.debugLineNum = 393;BA.debugLine="Sub pin7_Click";
 //BA.debugLineNum = 394;BA.debugLine="StartActivity(\"egavma\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("egavma"));
 //BA.debugLineNum = 395;BA.debugLine="End Sub";
return "";
}
public static String  _pin8_click() throws Exception{
 //BA.debugLineNum = 388;BA.debugLine="Sub pin8_Click";
 //BA.debugLineNum = 390;BA.debugLine="StartActivity(\"egkefaliko\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("egkefaliko"));
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return "";
}
public static String  _pin9_click() throws Exception{
 //BA.debugLineNum = 383;BA.debugLine="Sub pin9_Click";
 //BA.debugLineNum = 385;BA.debugLine="StartActivity(\"efragma\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("efragma"));
 //BA.debugLineNum = 387;BA.debugLine="End Sub";
return "";
}
public static String  _pixi_click() throws Exception{
 //BA.debugLineNum = 426;BA.debugLine="Sub pixi_Click";
 //BA.debugLineNum = 427;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 428;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 429;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 442;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 443;BA.debugLine="StartActivity(\"karpa\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("karpa"));
 //BA.debugLineNum = 444;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 445;BA.debugLine="End Sub";
return "";
}
public static String  _simansi_click() throws Exception{
 //BA.debugLineNum = 462;BA.debugLine="Sub simansi_Click";
 //BA.debugLineNum = 463;BA.debugLine="StartActivity(\"karpa\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("karpa"));
 //BA.debugLineNum = 464;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return "";
}
public static String  _textpin1_click() throws Exception{
 //BA.debugLineNum = 380;BA.debugLine="Sub textpin1_Click";
 //BA.debugLineNum = 381;BA.debugLine="StartActivity(\"aimoragia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("aimoragia"));
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return "";
}
public static String  _textpin2_click() throws Exception{
 //BA.debugLineNum = 377;BA.debugLine="Sub textpin2_Click";
 //BA.debugLineNum = 378;BA.debugLine="StartActivity(\"katagma\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("katagma"));
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
return "";
}
public static String  _textpin3_click() throws Exception{
 //BA.debugLineNum = 374;BA.debugLine="Sub textpin3_Click";
 //BA.debugLineNum = 375;BA.debugLine="StartActivity(\"pnigmos\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pnigmos"));
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return "";
}
public static String  _textpin4_click() throws Exception{
 //BA.debugLineNum = 371;BA.debugLine="Sub textpin4_Click";
 //BA.debugLineNum = 372;BA.debugLine="StartActivity(\"lypothimia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("lypothimia"));
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return "";
}
public static String  _textpin5_click() throws Exception{
 //BA.debugLineNum = 368;BA.debugLine="Sub textpin5_Click";
 //BA.debugLineNum = 369;BA.debugLine="StartActivity(\"ypothermia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ypothermia"));
 //BA.debugLineNum = 370;BA.debugLine="End Sub";
return "";
}
public static String  _textpin6_click() throws Exception{
 //BA.debugLineNum = 365;BA.debugLine="Sub textpin6_Click";
 //BA.debugLineNum = 366;BA.debugLine="StartActivity(\"thermoplixia\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("thermoplixia"));
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return "";
}
public static String  _textpin7_click() throws Exception{
 //BA.debugLineNum = 362;BA.debugLine="Sub textpin7_Click";
 //BA.debugLineNum = 363;BA.debugLine="StartActivity(\"egavma\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("egavma"));
 //BA.debugLineNum = 364;BA.debugLine="End Sub";
return "";
}
public static String  _textpin8_click() throws Exception{
 //BA.debugLineNum = 359;BA.debugLine="Sub textpin8_Click";
 //BA.debugLineNum = 360;BA.debugLine="StartActivity(\"egkefaliko\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("egkefaliko"));
 //BA.debugLineNum = 361;BA.debugLine="End Sub";
return "";
}
public static String  _textpin9_click() throws Exception{
 //BA.debugLineNum = 356;BA.debugLine="Sub textpin9_Click";
 //BA.debugLineNum = 357;BA.debugLine="StartActivity(\"efragma\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("efragma"));
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return "";
}
}
