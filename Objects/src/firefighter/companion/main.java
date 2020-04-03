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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "firefighter.companion", "firefighter.companion.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "firefighter.companion", "firefighter.companion.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "firefighter.companion.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _vardia = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _mple = null;
public anywheresoftware.b4a.objects.LabelWrapper _simanseislabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _listabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _katigorlabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ousialabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _ililabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _callabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _searchlabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _infolabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _cameraaofflabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _gpsslabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _pixilabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _thllabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _fakoss = null;
public anywheresoftware.b4a.objects.LabelWrapper _firstaids = null;
public anywheresoftware.b4a.objects.LabelWrapper _genika = null;
public anywheresoftware.b4a.objects.LabelWrapper _update = null;
public com.gvoulg.egsa87.egsa87 _egsa87 = null;
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
public firefighter.companion.restartgpsapp _restartgpsapp = null;
public firefighter.companion.httputils2service _httputils2service = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (rss.mostCurrent != null);
vis = vis | (rssdyo.mostCurrent != null);
vis = vis | (deiktes.mostCurrent != null);
vis = vis | (avrio.mostCurrent != null);
vis = vis | (gpssignal.mostCurrent != null);
vis = vis | (gpsapp.mostCurrent != null);
vis = vis | (searchun.mostCurrent != null);
vis = vis | (searchundell.mostCurrent != null);
vis = vis | (firstaid.mostCurrent != null);
vis = vis | (ilika.mostCurrent != null);
vis = vis | (epta.mostCurrent != null);
vis = vis | (epta2.mostCurrent != null);
vis = vis | (epta3.mostCurrent != null);
vis = vis | (kriti.mostCurrent != null);
vis = vis | (attiki.mostCurrent != null);
vis = vis | (pelloponiso.mostCurrent != null);
vis = vis | (thessalia.mostCurrent != null);
vis = vis | (sterea.mostCurrent != null);
vis = vis | (anthraki.mostCurrent != null);
vis = vis | (ena.mostCurrent != null);
vis = vis | (dyo.mostCurrent != null);
vis = vis | (tesera.mostCurrent != null);
vis = vis | (pente.mostCurrent != null);
vis = vis | (exi.mostCurrent != null);
vis = vis | (okto.mostCurrent != null);
vis = vis | (ennia.mostCurrent != null);
vis = vis | (camera.mostCurrent != null);
vis = vis | (pixida.mostCurrent != null);
vis = vis | (miden100.mostCurrent != null);
vis = vis | (dyoxil400.mostCurrent != null);
vis = vis | (thlefona.mostCurrent != null);
vis = vis | (dytellada.mostCurrent != null);
vis = vis | (hpeiros.mostCurrent != null);
vis = vis | (adr.mostCurrent != null);
vis = vis | (katigoriess.mostCurrent != null);
vis = vis | (dyoxil200.mostCurrent != null);
vis = vis | (dyoxil300.mostCurrent != null);
vis = vis | (egkefaliko.mostCurrent != null);
vis = vis | (venzini.mostCurrent != null);
vis = vis | (ydroxidio.mostCurrent != null);
vis = vis | (ydroxlorio.mostCurrent != null);
vis = vis | (xilia500.mostCurrent != null);
vis = vis | (xilia1000.mostCurrent != null);
vis = vis | (xilia100.mostCurrent != null);
vis = vis | (xilia200.mostCurrent != null);
vis = vis | (xilia300.mostCurrent != null);
vis = vis | (xilia400.mostCurrent != null);
vis = vis | (xilia600.mostCurrent != null);
vis = vis | (xilia700.mostCurrent != null);
vis = vis | (ydroxidiodialima.mostCurrent != null);
vis = vis | (ydroxlorikooxi.mostCurrent != null);
vis = vis | (ygraerio.mostCurrent != null);
vis = vis | (voreioaig.mostCurrent != null);
vis = vis | (aeriapetrelaiou.mostCurrent != null);
vis = vis | (aimoragia.mostCurrent != null);
vis = vis | (amonia.mostCurrent != null);
vis = vis | (asetilini.mostCurrent != null);
vis = vis | (dyo2.mostCurrent != null);
vis = vis | (dyo3.mostCurrent != null);
vis = vis | (dyoxil100.mostCurrent != null);
vis = vis | (dyoxil1000.mostCurrent != null);
vis = vis | (dyoxil500.mostCurrent != null);
vis = vis | (dyoxil600.mostCurrent != null);
vis = vis | (dyoxil700.mostCurrent != null);
vis = vis | (dyoxil800.mostCurrent != null);
vis = vis | (dyoxil900.mostCurrent != null);
vis = vis | (dytmak.mostCurrent != null);
vis = vis | (efragma.mostCurrent != null);
vis = vis | (egavma.mostCurrent != null);
vis = vis | (ena6.mostCurrent != null);
vis = vis | (enapente.mostCurrent != null);
vis = vis | (enatessera.mostCurrent != null);
vis = vis | (epta4.mostCurrent != null);
vis = vis | (exi2.mostCurrent != null);
vis = vis | (fisiko.mostCurrent != null);
vis = vis | (ioniopel.mostCurrent != null);
vis = vis | (karpa.mostCurrent != null);
vis = vis | (katagma.mostCurrent != null);
vis = vis | (kentrikimak.mostCurrent != null);
vis = vis | (listaousies.mostCurrent != null);
vis = vis | (lypothimia.mostCurrent != null);
vis = vis | (meigmaaeriwn.mostCurrent != null);
vis = vis | (methanio.mostCurrent != null);
vis = vis | (miden200.mostCurrent != null);
vis = vis | (miden300.mostCurrent != null);
vis = vis | (miden400.mostCurrent != null);
vis = vis | (miden500.mostCurrent != null);
vis = vis | (miden600.mostCurrent != null);
vis = vis | (notioaig.mostCurrent != null);
vis = vis | (ousies.mostCurrent != null);
vis = vis | (oxigonopiesi.mostCurrent != null);
vis = vis | (oxygono.mostCurrent != null);
vis = vis | (pente2.mostCurrent != null);
vis = vis | (petrelaio.mostCurrent != null);
vis = vis | (pnigmos.mostCurrent != null);
vis = vis | (propanio.mostCurrent != null);
vis = vis | (simanseis.mostCurrent != null);
vis = vis | (tessera2.mostCurrent != null);
vis = vis | (tessera3.mostCurrent != null);
vis = vis | (thermoplixia.mostCurrent != null);
vis = vis | (thiiko.mostCurrent != null);
vis = vis | (thiikoatmizon.mostCurrent != null);
vis = vis | (tria.mostCurrent != null);
vis = vis | (triaxil100.mostCurrent != null);
vis = vis | (triaxil200.mostCurrent != null);
vis = vis | (triaxil300.mostCurrent != null);
vis = vis | (triaxil400.mostCurrent != null);
vis = vis | (triaxil500.mostCurrent != null);
vis = vis | (triaxil600.mostCurrent != null);
vis = vis | (xilia800.mostCurrent != null);
vis = vis | (xilia900.mostCurrent != null);
vis = vis | (xlorio.mostCurrent != null);
vis = vis | (ydrogono.mostCurrent != null);
vis = vis | (ygrooxygono.mostCurrent != null);
vis = vis | (ygropimeno.mostCurrent != null);
vis = vis | (ypothermia.mostCurrent != null);
vis = vis | (restartgpsapp.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _result = 0;
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
 //BA.debugLineNum = 56;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 59;BA.debugLine="Activity.LoadLayout(\"main\")";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
 //BA.debugLineNum = 60;BA.debugLine="Activity.AddMenuItem(\"ΠΛΗΡΟΦΟΡΙΕΣ\",\"mnuinfo\")";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("ΠΛΗΡΟΦΟΡΙΕΣ"),"mnuinfo");
 //BA.debugLineNum = 61;BA.debugLine="Activity.AddMenuItem(\"Ομάδα φλόγα στο facebook\",\"";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("Ομάδα φλόγα στο facebook"),"mnfb");
 //BA.debugLineNum = 62;BA.debugLine="Activity.AddMenuItem(\"ΈΞΟΔΟΣ\",\"mnuexit\")";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("ΈΞΟΔΟΣ"),"mnuexit");
 //BA.debugLineNum = 91;BA.debugLine="searchlabel.Top = 3%y";
mostCurrent._searchlabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 92;BA.debugLine="searchlabel.left = 3.5%x";
mostCurrent._searchlabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3.5),mostCurrent.activityBA));
 //BA.debugLineNum = 93;BA.debugLine="searchlabel.height = 27.5%y";
mostCurrent._searchlabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (27.5),mostCurrent.activityBA));
 //BA.debugLineNum = 94;BA.debugLine="searchlabel.Width  = 45%x";
mostCurrent._searchlabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 99;BA.debugLine="listabel.Top = 3%y";
mostCurrent._listabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 100;BA.debugLine="listabel.left = 51.75%x";
mostCurrent._listabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 101;BA.debugLine="listabel.height = 13%y";
mostCurrent._listabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 102;BA.debugLine="listabel.Width  = 21.25%x";
mostCurrent._listabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 108;BA.debugLine="katigorlabel.Top = 17.5%y";
mostCurrent._katigorlabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (17.5),mostCurrent.activityBA));
 //BA.debugLineNum = 109;BA.debugLine="katigorlabel.left = 51.75%x";
mostCurrent._katigorlabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 110;BA.debugLine="katigorlabel.height = 13%y";
mostCurrent._katigorlabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 111;BA.debugLine="katigorlabel.Width  = 21.25%x";
mostCurrent._katigorlabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 114;BA.debugLine="ousialabel.Top = 3%y";
mostCurrent._ousialabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 115;BA.debugLine="ousialabel.left = 76%x";
mostCurrent._ousialabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 116;BA.debugLine="ousialabel.height = 13%y";
mostCurrent._ousialabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 117;BA.debugLine="ousialabel.Width  = 21.25%x";
mostCurrent._ousialabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 119;BA.debugLine="ililabel.Top = 17.5%y";
mostCurrent._ililabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (17.5),mostCurrent.activityBA));
 //BA.debugLineNum = 120;BA.debugLine="ililabel.left = 76%x";
mostCurrent._ililabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 121;BA.debugLine="ililabel.height = 13%y";
mostCurrent._ililabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 122;BA.debugLine="ililabel.Width  = 21.25%x";
mostCurrent._ililabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 125;BA.debugLine="cameraaofflabel.Top = 33%y";
mostCurrent._cameraaofflabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA));
 //BA.debugLineNum = 126;BA.debugLine="cameraaofflabel.left = 3%x";
mostCurrent._cameraaofflabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 127;BA.debugLine="cameraaofflabel.height = 27.5%y";
mostCurrent._cameraaofflabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (27.5),mostCurrent.activityBA));
 //BA.debugLineNum = 128;BA.debugLine="cameraaofflabel.Width  = 45%x";
mostCurrent._cameraaofflabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 132;BA.debugLine="thllabel.Top = 33%y";
mostCurrent._thllabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA));
 //BA.debugLineNum = 133;BA.debugLine="thllabel.left = 51.75%x";
mostCurrent._thllabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 134;BA.debugLine="thllabel.height = 13%y";
mostCurrent._thllabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 135;BA.debugLine="thllabel.Width  = 21.25%x";
mostCurrent._thllabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 137;BA.debugLine="fakoss.Top = 33%y";
mostCurrent._fakoss.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (33),mostCurrent.activityBA));
 //BA.debugLineNum = 138;BA.debugLine="fakoss.left = 76%x";
mostCurrent._fakoss.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 139;BA.debugLine="fakoss.height = 13%y";
mostCurrent._fakoss.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 140;BA.debugLine="fakoss.Width  = 21.25%x";
mostCurrent._fakoss.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 142;BA.debugLine="firstaids.Top = 47.5%y";
mostCurrent._firstaids.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (47.5),mostCurrent.activityBA));
 //BA.debugLineNum = 143;BA.debugLine="firstaids.left = 51.75%x";
mostCurrent._firstaids.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 144;BA.debugLine="firstaids.height = 13%y";
mostCurrent._firstaids.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 145;BA.debugLine="firstaids.Width  = 21.25%x";
mostCurrent._firstaids.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 147;BA.debugLine="genika.Top = 47.5%y";
mostCurrent._genika.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (47.5),mostCurrent.activityBA));
 //BA.debugLineNum = 148;BA.debugLine="genika.left = 76%x";
mostCurrent._genika.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 149;BA.debugLine="genika.height = 13%y";
mostCurrent._genika.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 150;BA.debugLine="genika.Width  = 21.25%x";
mostCurrent._genika.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.25),mostCurrent.activityBA));
 //BA.debugLineNum = 153;BA.debugLine="gpsslabel.Top = 63%y";
mostCurrent._gpsslabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (63),mostCurrent.activityBA));
 //BA.debugLineNum = 154;BA.debugLine="gpsslabel.left = 3%x";
mostCurrent._gpsslabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 155;BA.debugLine="gpsslabel.height = 27.5%y";
mostCurrent._gpsslabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (27.5),mostCurrent.activityBA));
 //BA.debugLineNum = 156;BA.debugLine="gpsslabel.Width  = 45%x";
mostCurrent._gpsslabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 160;BA.debugLine="callabel.Top = 63%y";
mostCurrent._callabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (63),mostCurrent.activityBA));
 //BA.debugLineNum = 161;BA.debugLine="callabel.left = 51.75%x";
mostCurrent._callabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 162;BA.debugLine="callabel.height = 13%y";
mostCurrent._callabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 163;BA.debugLine="callabel.Width  = 21.5%x";
mostCurrent._callabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.5),mostCurrent.activityBA));
 //BA.debugLineNum = 165;BA.debugLine="pixilabel.Top = 63%y";
mostCurrent._pixilabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (63),mostCurrent.activityBA));
 //BA.debugLineNum = 166;BA.debugLine="pixilabel.left = 76%x";
mostCurrent._pixilabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 167;BA.debugLine="pixilabel.height = 13%y";
mostCurrent._pixilabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 168;BA.debugLine="pixilabel.Width  = 21.5%x";
mostCurrent._pixilabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.5),mostCurrent.activityBA));
 //BA.debugLineNum = 170;BA.debugLine="simanseislabel.Top = 77.5%y";
mostCurrent._simanseislabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (77.5),mostCurrent.activityBA));
 //BA.debugLineNum = 171;BA.debugLine="simanseislabel.left = 51.75%x";
mostCurrent._simanseislabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (51.75),mostCurrent.activityBA));
 //BA.debugLineNum = 172;BA.debugLine="simanseislabel.height = 13%y";
mostCurrent._simanseislabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 173;BA.debugLine="simanseislabel.Width  = 21.5%x";
mostCurrent._simanseislabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.5),mostCurrent.activityBA));
 //BA.debugLineNum = 175;BA.debugLine="infolabel.Top = 77.5%y";
mostCurrent._infolabel.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (77.5),mostCurrent.activityBA));
 //BA.debugLineNum = 176;BA.debugLine="infolabel.left = 76%x";
mostCurrent._infolabel.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (76),mostCurrent.activityBA));
 //BA.debugLineNum = 177;BA.debugLine="infolabel.height = 13%y";
mostCurrent._infolabel.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (13),mostCurrent.activityBA));
 //BA.debugLineNum = 178;BA.debugLine="infolabel.Width  = 21.5%x";
mostCurrent._infolabel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (21.5),mostCurrent.activityBA));
 //BA.debugLineNum = 182;BA.debugLine="mple.top = 93%y";
mostCurrent._mple.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (93),mostCurrent.activityBA));
 //BA.debugLineNum = 183;BA.debugLine="mple.left = 3%x";
mostCurrent._mple.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA));
 //BA.debugLineNum = 184;BA.debugLine="mple.width = 94%x";
mostCurrent._mple.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (94),mostCurrent.activityBA));
 //BA.debugLineNum = 185;BA.debugLine="mple.height = 7%y";
mostCurrent._mple.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (7),mostCurrent.activityBA));
 //BA.debugLineNum = 188;BA.debugLine="simanseislabel.BringToFront";
mostCurrent._simanseislabel.BringToFront();
 //BA.debugLineNum = 189;BA.debugLine="listabel.BringToFront";
mostCurrent._listabel.BringToFront();
 //BA.debugLineNum = 190;BA.debugLine="katigorlabel.BringToFront";
mostCurrent._katigorlabel.BringToFront();
 //BA.debugLineNum = 191;BA.debugLine="ousialabel.BringToFront";
mostCurrent._ousialabel.BringToFront();
 //BA.debugLineNum = 192;BA.debugLine="ililabel.BringToFront";
mostCurrent._ililabel.BringToFront();
 //BA.debugLineNum = 194;BA.debugLine="cameraaofflabel.BringToFront";
mostCurrent._cameraaofflabel.BringToFront();
 //BA.debugLineNum = 195;BA.debugLine="gpsslabel.BringToFront";
mostCurrent._gpsslabel.BringToFront();
 //BA.debugLineNum = 196;BA.debugLine="thllabel.BringToFront";
mostCurrent._thllabel.BringToFront();
 //BA.debugLineNum = 197;BA.debugLine="pixilabel.BringToFront";
mostCurrent._pixilabel.BringToFront();
 //BA.debugLineNum = 204;BA.debugLine="If File.Exists(File.DirInternal, \"msg.txt\") = Fal";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"msg.txt")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 206;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 207;BA.debugLine="result = Msgbox2(\"Εχω δημιουργήσει ομάδα στο fac";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Εχω δημιουργήσει ομάδα στο facebook για την εφαρμογή 'ΦΛΟΓΑ' για να προσπαθήσω να την βελτιώσω,να λαβω σχόλια, παρατηρήσεις για τυχόν σφαλματα και γνώμες για βελτίωση της εφαρμογής.Θα χαρώ να γίνετε μέλη.Ευχαριστω."),BA.ObjectToCharSequence("  "),"Ναι","Αργότερα","Οχι",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"facebook.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 208;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 209;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 210;BA.debugLine="StartActivity(p.OpenBrowser(\"https://www.faceb";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_p.OpenBrowser("https://www.facebook.com/groups/256720274824210/")));
 };
 //BA.debugLineNum = 212;BA.debugLine="If File.Exists(File.DirInternal, \"msg.txt\") = Fa";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"msg.txt")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 213;BA.debugLine="File.WriteString(File.DirInternal, \"msg.txt\", u";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"msg.txt",mostCurrent._update.getText());
 };
 //BA.debugLineNum = 215;BA.debugLine="If result = DialogResponse.negative Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
 //BA.debugLineNum = 217;BA.debugLine="If File.Exists(File.DirInternal, \"msg.txt\") = F";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"msg.txt")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 218;BA.debugLine="File.WriteString(File.DirInternal, \"msg.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"msg.txt",mostCurrent._update.getText());
 };
 };
 };
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 338;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 340;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 341;BA.debugLine="If Msgbox2(\"ΕΞΟΔΟΣ;\", \"\", \"ΝΑΙ\", \"\", \"ΟΧΙ\"";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("ΕΞΟΔΟΣ;"),BA.ObjectToCharSequence(""),"ΝΑΙ","","ΟΧΙ",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 343;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 }else {
 };
 };
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 233;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 227;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
return "";
}
public static String  _callabel_click() throws Exception{
 //BA.debugLineNum = 354;BA.debugLine="Sub callabel_Click";
 //BA.debugLineNum = 355;BA.debugLine="StartActivity(gpsApp)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gpsapp.getObject()));
 //BA.debugLineNum = 357;BA.debugLine="End Sub";
return "";
}
public static String  _cameraaofflabel_click() throws Exception{
 //BA.debugLineNum = 333;BA.debugLine="Sub cameraaofflabel_Click";
 //BA.debugLineNum = 334;BA.debugLine="StartActivity(\"simanseis\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("simanseis"));
 //BA.debugLineNum = 336;BA.debugLine="End Sub";
return "";
}
public static String  _fakoss_click() throws Exception{
 //BA.debugLineNum = 317;BA.debugLine="Sub fakoss_Click";
 //BA.debugLineNum = 318;BA.debugLine="StartActivity(\"camera\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("camera"));
 //BA.debugLineNum = 319;BA.debugLine="End Sub";
return "";
}
public static String  _firstaids_click() throws Exception{
 //BA.debugLineNum = 321;BA.debugLine="Sub firstaids_Click";
 //BA.debugLineNum = 322;BA.debugLine="StartActivity(\"firstaid\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("firstaid"));
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return "";
}
public static String  _genika_click() throws Exception{
 //BA.debugLineNum = 325;BA.debugLine="Sub genika_Click";
 //BA.debugLineNum = 326;BA.debugLine="StartActivity(\"gpssignal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("gpssignal"));
 //BA.debugLineNum = 328;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 29;BA.debugLine="Dim vardia As Label";
mostCurrent._vardia = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private mple As ImageView";
mostCurrent._mple = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private simanseislabel As Label";
mostCurrent._simanseislabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private listabel As Label";
mostCurrent._listabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private katigorlabel As Label";
mostCurrent._katigorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private ousialabel As Label";
mostCurrent._ousialabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private ililabel As Label";
mostCurrent._ililabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private callabel As Label";
mostCurrent._callabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private searchlabel As Label";
mostCurrent._searchlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private infolabel As Label";
mostCurrent._infolabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private cameraaofflabel As Label";
mostCurrent._cameraaofflabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private gpsslabel As Label";
mostCurrent._gpsslabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private pixilabel As Label";
mostCurrent._pixilabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private thllabel As Label";
mostCurrent._thllabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private fakoss As Label";
mostCurrent._fakoss = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private firstaids As Label";
mostCurrent._firstaids = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private genika As Label";
mostCurrent._genika = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private update As Label";
mostCurrent._update = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static String  _gpsslabel_click() throws Exception{
 //BA.debugLineNum = 272;BA.debugLine="Sub gpsslabel_Click";
 //BA.debugLineNum = 273;BA.debugLine="StartActivity(\"deiktes\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("deiktes"));
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return "";
}
public static String  _ililabel_click() throws Exception{
 //BA.debugLineNum = 267;BA.debugLine="Sub ililabel_Click";
 //BA.debugLineNum = 268;BA.debugLine="StartActivity(\"ilika\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ilika"));
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public static String  _infolabel_click() throws Exception{
 //BA.debugLineNum = 363;BA.debugLine="Sub infolabel_Click";
 //BA.debugLineNum = 364;BA.debugLine="Activity.OpenMenu";
mostCurrent._activity.OpenMenu();
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public static String  _katigorlabel_click() throws Exception{
 //BA.debugLineNum = 261;BA.debugLine="Sub katigorlabel_Click";
 //BA.debugLineNum = 262;BA.debugLine="StartActivity(\"katigoriess\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("katigoriess"));
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return "";
}
public static String  _listabel_click() throws Exception{
 //BA.debugLineNum = 258;BA.debugLine="Sub listabel_Click";
 //BA.debugLineNum = 259;BA.debugLine="StartActivity(\"listaousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("listaousies"));
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
return "";
}
public static String  _mnfb_click() throws Exception{
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
 //BA.debugLineNum = 309;BA.debugLine="Sub mnfb_Click";
 //BA.debugLineNum = 310;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 311;BA.debugLine="StartActivity(p.OpenBrowser(\"https://www.facebook";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_p.OpenBrowser("https://www.facebook.com/groups/256720274824210/")));
 //BA.debugLineNum = 314;BA.debugLine="End Sub";
return "";
}
public static String  _mnuexit_click() throws Exception{
 //BA.debugLineNum = 294;BA.debugLine="Sub mnuexit_Click";
 //BA.debugLineNum = 298;BA.debugLine="If Msgbox2(\"ΕΞΟΔΟΣ;\", \"\", \"ΝΑΙ\", \"\", \"ΟΧΙ\", Null)";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("ΕΞΟΔΟΣ;"),BA.ObjectToCharSequence(""),"ΝΑΙ","","ΟΧΙ",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 300;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 }else {
 };
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
return "";
}
public static String  _mnuinfo_click() throws Exception{
 //BA.debugLineNum = 284;BA.debugLine="Sub mnuinfo_Click";
 //BA.debugLineNum = 285;BA.debugLine="Msgbox(\"Η εφαρμογή είναι το αλφαβητάρι της μεταφο";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Η εφαρμογή είναι το αλφαβητάρι της μεταφοράς επικύνδινων υλικών και ουσιών.Περιέχει όλες τις ουσίες (UN NUMBERS) ονομαστικά και τις κατηγορίες (ΚΑΤΗΓΟΡΙΕΣ ADR) που ανήκει η κάθε μια.Αναλύει τις κατηγορίες ,τις επικυνδινότητες της κάθε μιας και τον τρόπο αντιμετώπισης.Περιέχει τις σημάνσεις(Κατηγορίες HIN)που συνοδεύουν τις πινακίδες των ουσιών(το πάνω μέρος δίχνει την κατηγορία HIN και το κάτω την ουσία UN) και αναλύει τις 20 πιο διαδεδομένες."),BA.ObjectToCharSequence("Πληροφορίες Εφαρμογής"),mostCurrent.activityBA);
 //BA.debugLineNum = 286;BA.debugLine="Msgbox(\"Περιέχει όλα τα τηλέφωνα των σταθμών και";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Περιέχει όλα τα τηλέφωνα των σταθμών και κλιμακίων του πυροσβεστικού σώματος με δυνατότητα απευθείας κλήσης"),BA.ObjectToCharSequence("Πληροφορίες Εφαρμογής"),mostCurrent.activityBA);
 //BA.debugLineNum = 287;BA.debugLine="Msgbox(\"Εμφανίζει τους χάρτες επικινδυνότητας(Απα";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Εμφανίζει τους χάρτες επικινδυνότητας(Απαιτείται σύνδεση στο ίντερνετ)"),BA.ObjectToCharSequence("Πληροφορίες Εφαρμογής"),mostCurrent.activityBA);
 //BA.debugLineNum = 288;BA.debugLine="Msgbox(\"Παρέχει την δυνατότητα χρήσης της κάμερας";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Παρέχει την δυνατότητα χρήσης της κάμερας της συσκευής σαν φακό."),BA.ObjectToCharSequence("Πληροφορίες Εφαρμογής"),mostCurrent.activityBA);
 //BA.debugLineNum = 289;BA.debugLine="Msgbox(\"Εχει οδηγίες πρώτων βοηθειών.Περιέχει τις";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Εχει οδηγίες πρώτων βοηθειών.Περιέχει τις βασικότερες καταστάσεις που ενδέχεται να χρειαστεί η παροχή αυτή."),BA.ObjectToCharSequence("Πληροφορίες Εφαρμογής"),mostCurrent.activityBA);
 //BA.debugLineNum = 290;BA.debugLine="Msgbox(\"Μετατρέπει την συσκεύη σε δέκτη GPS αποθη";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Μετατρέπει την συσκεύη σε δέκτη GPS αποθηκέυοντας το στίγμα και δίνει την δυνατότητα εμφάνισης του σημείου στον χάρτη με την χρήση των χαρτών της google.."),BA.ObjectToCharSequence("Πληροφορίες Εφαρμογής"),mostCurrent.activityBA);
 //BA.debugLineNum = 291;BA.debugLine="Msgbox(\"Χρησιμοποιει την συσκευή σαν πιξίδα.Η ακρ";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Χρησιμοποιει την συσκευή σαν πιξίδα.Η ακρίβεια εξαρτάται απο την συσκευή.."),BA.ObjectToCharSequence("Πληροφορίες Εφαρμογής"),mostCurrent.activityBA);
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return "";
}
public static String  _ousialabel_click() throws Exception{
 //BA.debugLineNum = 264;BA.debugLine="Sub ousialabel_Click";
 //BA.debugLineNum = 265;BA.debugLine="StartActivity(\"ousies\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ousies"));
 //BA.debugLineNum = 266;BA.debugLine="End Sub";
return "";
}
public static String  _pixilabel_click() throws Exception{
 //BA.debugLineNum = 279;BA.debugLine="Sub pixilabel_Click";
 //BA.debugLineNum = 280;BA.debugLine="StartActivity(\"rss\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("rss"));
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        com.gvoulg.egsa87.egsa87._process_globals();
main._process_globals();
rss._process_globals();
rssdyo._process_globals();
deiktes._process_globals();
avrio._process_globals();
gpssignal._process_globals();
gpsapp._process_globals();
searchun._process_globals();
searchundell._process_globals();
firstaid._process_globals();
ilika._process_globals();
epta._process_globals();
epta2._process_globals();
epta3._process_globals();
kriti._process_globals();
attiki._process_globals();
pelloponiso._process_globals();
thessalia._process_globals();
sterea._process_globals();
anthraki._process_globals();
ena._process_globals();
dyo._process_globals();
tesera._process_globals();
pente._process_globals();
exi._process_globals();
okto._process_globals();
ennia._process_globals();
camera._process_globals();
pixida._process_globals();
miden100._process_globals();
dyoxil400._process_globals();
thlefona._process_globals();
dytellada._process_globals();
hpeiros._process_globals();
adr._process_globals();
katigoriess._process_globals();
dyoxil200._process_globals();
dyoxil300._process_globals();
egkefaliko._process_globals();
venzini._process_globals();
ydroxidio._process_globals();
ydroxlorio._process_globals();
xilia500._process_globals();
xilia1000._process_globals();
xilia100._process_globals();
xilia200._process_globals();
xilia300._process_globals();
xilia400._process_globals();
xilia600._process_globals();
xilia700._process_globals();
ydroxidiodialima._process_globals();
ydroxlorikooxi._process_globals();
ygraerio._process_globals();
voreioaig._process_globals();
aeriapetrelaiou._process_globals();
aimoragia._process_globals();
amonia._process_globals();
asetilini._process_globals();
dyo2._process_globals();
dyo3._process_globals();
dyoxil100._process_globals();
dyoxil1000._process_globals();
dyoxil500._process_globals();
dyoxil600._process_globals();
dyoxil700._process_globals();
dyoxil800._process_globals();
dyoxil900._process_globals();
dytmak._process_globals();
efragma._process_globals();
egavma._process_globals();
ena6._process_globals();
enapente._process_globals();
enatessera._process_globals();
epta4._process_globals();
exi2._process_globals();
fisiko._process_globals();
ioniopel._process_globals();
karpa._process_globals();
katagma._process_globals();
kentrikimak._process_globals();
listaousies._process_globals();
lypothimia._process_globals();
meigmaaeriwn._process_globals();
methanio._process_globals();
miden200._process_globals();
miden300._process_globals();
miden400._process_globals();
miden500._process_globals();
miden600._process_globals();
notioaig._process_globals();
ousies._process_globals();
oxigonopiesi._process_globals();
oxygono._process_globals();
pente2._process_globals();
petrelaio._process_globals();
pnigmos._process_globals();
propanio._process_globals();
simanseis._process_globals();
tessera2._process_globals();
tessera3._process_globals();
thermoplixia._process_globals();
thiiko._process_globals();
thiikoatmizon._process_globals();
tria._process_globals();
triaxil100._process_globals();
triaxil200._process_globals();
triaxil300._process_globals();
triaxil400._process_globals();
triaxil500._process_globals();
triaxil600._process_globals();
xilia800._process_globals();
xilia900._process_globals();
xlorio._process_globals();
ydrogono._process_globals();
ygrooxygono._process_globals();
ygropimeno._process_globals();
ypothermia._process_globals();
restartgpsapp._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 21;BA.debugLine="Public rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _searchlabel_click() throws Exception{
 //BA.debugLineNum = 359;BA.debugLine="Sub searchlabel_Click";
 //BA.debugLineNum = 360;BA.debugLine="StartActivity(searchUn)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._searchun.getObject()));
 //BA.debugLineNum = 361;BA.debugLine="End Sub";
return "";
}
public static String  _simanseislabel_click() throws Exception{
 //BA.debugLineNum = 255;BA.debugLine="Sub simanseislabel_Click";
 //BA.debugLineNum = 256;BA.debugLine="StartActivity(\"thlefona\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("thlefona"));
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return "";
}
public static String  _thllabel_click() throws Exception{
 //BA.debugLineNum = 276;BA.debugLine="Sub thllabel_Click";
 //BA.debugLineNum = 277;BA.debugLine="StartActivity(\"pixida\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("pixida"));
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return "";
}
}
