package firefighter.companion;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class searchview extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "firefighter.companion.searchview");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", firefighter.companion.searchview.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.collections.Map _prefixlist = null;
public anywheresoftware.b4a.objects.collections.Map _substringlist = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lv = null;
public int _min_limit = 0;
public int _max_limit = 0;
public Object _mcallback = null;
public String _meventname = "";
public anywheresoftware.b4a.objects.ListViewWrapper _listaprin = null;
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
public firefighter.companion.restartgpsapp _restartgpsapp = null;
public firefighter.companion.httputils2service _httputils2service = null;
public String  _additemstolist(anywheresoftware.b4a.objects.collections.List _li,String _full) throws Exception{
int _i = 0;
String _item = "";
 //BA.debugLineNum = 123;BA.debugLine="Private Sub AddItemsToList(li As List, full As Str";
 //BA.debugLineNum = 124;BA.debugLine="If li.IsInitialized = False Then Return";
if (_li.IsInitialized()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 125;BA.debugLine="For i = 0 To li.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_li.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 126;BA.debugLine="Dim item As String";
_item = "";
 //BA.debugLineNum = 127;BA.debugLine="item = li.Get(i)";
_item = BA.ObjectToString(_li.Get(_i));
 //BA.debugLineNum = 128;BA.debugLine="If full.Length > MAX_LIMIT And item.ToLowerCase.";
if (_full.length()>_max_limit && _item.toLowerCase().contains(_full)==__c.False) { 
 //BA.debugLineNum = 129;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 131;BA.debugLine="lv.AddSingleLine(li.Get(i))";
_lv.AddSingleLine(BA.ObjectToCharSequence(_li.Get(_i)));
 }
};
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _addtoparent(anywheresoftware.b4a.objects.PanelWrapper _parent,int _left,int _top,int _width,int _height) throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Public Sub AddToParent(Parent As Panel, Left As In";
 //BA.debugLineNum = 36;BA.debugLine="Parent.AddView(et, Left, Top, Width - 5%x , 60dip";
_parent.AddView((android.view.View)(_et.getObject()),_left,_top,(int) (_width-__c.PerXToCurrent((float) (5),ba)),__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 37;BA.debugLine="Parent.AddView(lv, Left, Top + et.Height, Width,";
_parent.AddView((android.view.View)(_lv.getObject()),_left,(int) (_top+_et.getHeight()),_width,(int) (_height-_et.getHeight()));
 //BA.debugLineNum = 39;BA.debugLine="listaPrin.Initialize(\"listaPrin\")";
_listaprin.Initialize(ba,"listaPrin");
 //BA.debugLineNum = 40;BA.debugLine="listaPrin.Color = Colors.DarkGray";
_listaprin.setColor(__c.Colors.DarkGray);
 //BA.debugLineNum = 42;BA.debugLine="listaPrin.AddSingleLine(\"0004-Κατηγορια 1.1D Πικρ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0004-Κατηγορια 1.1D Πικρικο αμμωνιο , ξηρος η νωπος με λιγοτερο απο Κατηγορια 10 τοις εκατο νερο, κατα βαρος  "));
 //BA.debugLineNum = 43;BA.debugLine="listaPrin.AddSingleLine(\"0005-Κατηγορια 1.1E Φυσι";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0005-Κατηγορια 1.1E Φυσιγγια για οπλα, με εκρηκτικη γομωση  "));
 //BA.debugLineNum = 44;BA.debugLine="listaPrin.AddSingleLine(\"0009-Κατηγορια 1 Πυρομαχ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0009-Κατηγορια 1 Πυρομαχικα , εμπρηστικα με η χωρις ρηγμα, διαρροη γομωσης η προωθητικης γομωσης  "));
 //BA.debugLineNum = 45;BA.debugLine="listaPrin.AddSingleLine(\"0012-Κατηγορια 1 Φυσιγγι";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0012-Κατηγορια 1 Φυσιγγια για οπλα, αδρανους βληματος η Φυσιγγια, μικρων οπλων  "));
 //BA.debugLineNum = 46;BA.debugLine="listaPrin.AddSingleLine(\"0014-Κατηγορια 1 Φυσιγγι";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0014-Κατηγορια 1 Φυσιγγια για οπλα, κενο η Φυσιγγια, μικρων οπλων, κενο  "));
 //BA.debugLineNum = 47;BA.debugLine="listaPrin.AddSingleLine(\"0015-Κατηγορια 1 Πυρομαχ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0015-Κατηγορια 1 Πυρομαχικα, καπνο, με η χωρις ρηγμα, διαρροη γομωσης η προωθητικης γομωσης"));
 //BA.debugLineNum = 48;BA.debugLine="listaPrin.AddSingleLine(\"0018-Κατηγορια 1 Πυρομαχ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0018-Κατηγορια 1 Πυρομαχικα, δακρυ-παραγωγη με ρηγμα, διαρροη γομωσης η προωθητικης γομωσης "));
 //BA.debugLineNum = 49;BA.debugLine="listaPrin.AddSingleLine(\"0020-Κατηγορια 1 Πυρομαχ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0020-Κατηγορια 1 Πυρομαχικα, τοξικα με ρηγμα, διαρροη γομωσης η προωθητικης γομωσης  "));
 //BA.debugLineNum = 50;BA.debugLine="listaPrin.AddSingleLine(\"0027-Κατηγορια 1 Μαυρη σ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0027-Κατηγορια 1 Μαυρη σκονη η Μπαρουτι, κοκκωδης η ως ενα γευμα  "));
 //BA.debugLineNum = 51;BA.debugLine="listaPrin.AddSingleLine(\"0028-Κατηγορια 1 Μαυρη σ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0028-Κατηγορια 1 Μαυρη σκονη, συμπιεσμενα η Μπαρουτι, συμπιεσμενα η Μαυρη σκονη, σε σφαιριδια η Μπαρουτι, σε σφαιριδια  "));
 //BA.debugLineNum = 52;BA.debugLine="listaPrin.AddSingleLine(\"0029-Κατηγορια 1 Πυροκρο";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0029-Κατηγορια 1 Πυροκροτητες , ηλεκτρικα ειδη, μη ηλεκτρικα, για ανατιναξεις  "));
 //BA.debugLineNum = 53;BA.debugLine="listaPrin.AddSingleLine(\"0033-Κατηγορια 1 Βομβες";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0033-Κατηγορια 1 Βομβες , με εκρηκτικη γομωση  "));
 //BA.debugLineNum = 54;BA.debugLine="listaPrin.AddSingleLine(\"0037-Κατηγορια 1 ΒΟΜΒΕΣ,";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0037-Κατηγορια 1 ΒΟΜΒΕΣ, φλας  "));
 //BA.debugLineNum = 55;BA.debugLine="listaPrin.AddSingleLine(\"0042-Κατηγορια 1 Ενισχυτ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0042-Κατηγορια 1 Ενισχυτες , χωρις πυροκροτητη"));
 //BA.debugLineNum = 56;BA.debugLine="listaPrin.AddSingleLine(\"0043-Κατηγορια 1 Γαμα ,";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0043-Κατηγορια 1 Γαμα , εκρηκτικα  "));
 //BA.debugLineNum = 57;BA.debugLine="listaPrin.AddSingleLine(\"0044-Κατηγορια 1 Ασταρια";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0044-Κατηγορια 1 Ασταρια , τυπος καπακι"));
 //BA.debugLineNum = 58;BA.debugLine="listaPrin.AddSingleLine(\"0048-Κατηγορια 1 Χρεωσει";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0048-Κατηγορια 1 Χρεωσεις , κατεδαφιση  "));
 //BA.debugLineNum = 59;BA.debugLine="listaPrin.AddSingleLine(\"0049-Κατηγορια 1 Φυσιγγι";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0049-Κατηγορια 1 Φυσιγγια, φλας  "));
 //BA.debugLineNum = 60;BA.debugLine="listaPrin.AddSingleLine(\"0054-Κατηγορια 1 Φυσιγγι";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0054-Κατηγορια 1 Φυσιγγια, σημα  "));
 //BA.debugLineNum = 61;BA.debugLine="listaPrin.AddSingleLine(\"0055-Κατηγορια 1 Θηκες,";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0055-Κατηγορια 1 Θηκες, φυσιγγιων, αδειο, με ασταρι  "));
 //BA.debugLineNum = 62;BA.debugLine="listaPrin.AddSingleLine(\"0056-Κατηγορια 1 Χρεωσει";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0056-Κατηγορια 1 Χρεωσεις, το βαθος  "));
 //BA.debugLineNum = 63;BA.debugLine="listaPrin.AddSingleLine(\"0059-Κατηγορια 1 Χρεωσει";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0059-Κατηγορια 1 Χρεωσεις, σχημα, χωρις πυροκροτητη  "));
 //BA.debugLineNum = 64;BA.debugLine="listaPrin.AddSingleLine(\"0060-Κατηγορια 1 Χρεωσει";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0060-Κατηγορια 1 Χρεωσεις, συμπληρωματικη εκρηκτικα  "));
 //BA.debugLineNum = 65;BA.debugLine="listaPrin.AddSingleLine(\"0065-Κατηγορια 1 Καλωδιο";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0065-Κατηγορια 1 Καλωδιο , εκρηκτικων, ευελικτη  "));
 //BA.debugLineNum = 66;BA.debugLine="listaPrin.AddSingleLine(\"0066-Κατηγορια 1 Καλωδιο";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0066-Κατηγορια 1 Καλωδιο, αναφλεξη    "));
 //BA.debugLineNum = 67;BA.debugLine="listaPrin.AddSingleLine(\"0070-Κατηγορια 1 Κοφτες,";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0070-Κατηγορια 1 Κοφτες, καλωδιο, εκρηκτικα  "));
 //BA.debugLineNum = 68;BA.debugLine="listaPrin.AddSingleLine(\"0072-Κατηγορια 1 Κυκλοτρ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0072-Κατηγορια 1 Κυκλοτριμεθυλενοτρινιτραμινη   "));
 //BA.debugLineNum = 69;BA.debugLine="listaPrin.AddSingleLine(\"0073-Κατηγορια 1 Πυροκρο";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0073-Κατηγορια 1 Πυροκροτητες για τα πυρομαχικα  "));
 //BA.debugLineNum = 70;BA.debugLine="listaPrin.AddSingleLine(\"0074-Κατηγορια 1 Diazodi";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0074-Κατηγορια 1 Diazodinitrophenol , βρεγμενο με οχι λιγοτερο απο 40 τοις εκατο νερο η μιγμα αλκοολης και νερου, κατα βαρος  "));
 //BA.debugLineNum = 71;BA.debugLine="listaPrin.AddSingleLine(\"0075-Κατηγορια 1 Διαιθυλ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0075-Κατηγορια 1 Διαιθυλενογλυκολη δινιτρικο  "));
 //BA.debugLineNum = 72;BA.debugLine="listaPrin.AddSingleLine(\"0076-Κατηγορια 1 Δινιτρο";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0076-Κατηγορια 1 Δινιτροφαινολης , ξηρος η νωπος με λιγοτερο απο Κατηγορια 15 τοις εκατο νερο κατα μαζα  "));
 //BA.debugLineNum = 73;BA.debugLine="listaPrin.AddSingleLine(\"0077-Κατηγορια 1 Dinitro";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0077-Κατηγορια 1 Dinitrophenolates αλκαλικα μεταλλα , ξηρος η νωπος με λιγοτερο απο Κατηγορια 15 τοις εκατο νερο κατα μαζα  "));
 //BA.debugLineNum = 74;BA.debugLine="listaPrin.AddSingleLine(\"0078-Κατηγορια 1 Dinitro";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0078-Κατηγορια 1 Dinitroresorcinol , ξηρος η νωπος με λιγοτερο απο Κατηγορια 15 τοις εκατο νερο κατα μαζα  "));
 //BA.debugLineNum = 75;BA.debugLine="listaPrin.AddSingleLine(\"0079-Κατηγορια 1 Hexanit";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0079-Κατηγορια 1 Hexanitrodiphenylamine η Dipicrylamine η Hexyl  "));
 //BA.debugLineNum = 76;BA.debugLine="listaPrin.AddSingleLine(\"0081-Κατηγορια 1 Εκρηκτι";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0081-Κατηγορια 1 Εκρηκτικο , ανατιναξεις, τυπου Α  "));
 //BA.debugLineNum = 77;BA.debugLine="listaPrin.AddSingleLine(\"0082-Κατηγορια 1 Εκρηκτι";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0082-Κατηγορια 1 Εκρηκτικο, ανατιναξεις, τυπου Β  "));
 //BA.debugLineNum = 78;BA.debugLine="listaPrin.AddSingleLine(\"0083-Κατηγορια 1 Εκρηκτι";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0083-Κατηγορια 1 Εκρηκτικο, ανατιναξεις, τυπου C  "));
 //BA.debugLineNum = 79;BA.debugLine="listaPrin.AddSingleLine(\"0084-Κατηγορια 1 Εκρηκτι";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0084-Κατηγορια 1 Εκρηκτικο, ανατιναξεις, τυπου D  "));
 //BA.debugLineNum = 80;BA.debugLine="listaPrin.AddSingleLine(\"0092-Κατηγορια 1 Φωτοβολ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0092-Κατηγορια 1 Φωτοβολιδες , επιφανεια  "));
 //BA.debugLineNum = 81;BA.debugLine="listaPrin.AddSingleLine(\"0093-Κατηγορια 1 Φωτοβολ";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0093-Κατηγορια 1 Φωτοβολιδες, εναερια  "));
 //BA.debugLineNum = 82;BA.debugLine="listaPrin.AddSingleLine(\"0094-Κατηγορια 1 Blitzli";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0094-Κατηγορια 1 Blitzlichtpulver (Flash σκονη, π.χ. για μια ντεμοντε φλας της φωτογραφικης μηχανης"));
 //BA.debugLineNum = 83;BA.debugLine="listaPrin.AddSingleLine(\"0099-Κατηγορια 1 Συσκευε";
_listaprin.AddSingleLine(BA.ObjectToCharSequence("0099-Κατηγορια 1 Συσκευες, εκρηκτικα, θραυση χωρις πυροκροτητες για πετρελαιοπηγες   "));
 //BA.debugLineNum = 87;BA.debugLine="Parent.AddView(listaPrin, 3%x, 33%y + 60dip,94%x";
_parent.AddView((android.view.View)(_listaprin.getObject()),__c.PerXToCurrent((float) (3),ba),(int) (__c.PerYToCurrent((float) (33),ba)+__c.DipToCurrent((int) (60))),__c.PerXToCurrent((float) (94),ba),(int) (__c.PerYToCurrent((float) (57.5),ba)-__c.DipToCurrent((int) (60))));
 //BA.debugLineNum = 88;BA.debugLine="listaPrin.SingleLineLayout.Label.TextSize = 14";
_listaprin.getSingleLineLayout().Label.setTextSize((float) (14));
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private prefixList As Map";
_prefixlist = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 5;BA.debugLine="Private substringList As Map";
_substringlist = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 6;BA.debugLine="Private et As EditText";
_et = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private lv As ListView";
_lv = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Private MIN_LIMIT, MAX_LIMIT As Int";
_min_limit = 0;
_max_limit = 0;
 //BA.debugLineNum = 9;BA.debugLine="MIN_LIMIT = 1";
_min_limit = (int) (1);
 //BA.debugLineNum = 10;BA.debugLine="MAX_LIMIT = 4 'doesn't limit the words length. On";
_max_limit = (int) (4);
 //BA.debugLineNum = 11;BA.debugLine="Private mCallback As Object";
_mcallback = new Object();
 //BA.debugLineNum = 12;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 13;BA.debugLine="Private listaPrin As ListView";
_listaprin = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public String  _clearsearchbox() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 177;BA.debugLine="Public Sub ClearSearchBox";
 //BA.debugLineNum = 178;BA.debugLine="Dim IME As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 179;BA.debugLine="et.Text=\"\"";
_et.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 180;BA.debugLine="IME.ShowKeyboard(et)";
_ime.ShowKeyboard((android.view.View)(_et.getObject()));
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return "";
}
public String  _et_textchanged(String _old,String _new) throws Exception{
String _str1 = "";
String _str2 = "";
 //BA.debugLineNum = 106;BA.debugLine="Private Sub et_TextChanged (Old As String, New As";
 //BA.debugLineNum = 107;BA.debugLine="lv.Clear";
_lv.Clear();
 //BA.debugLineNum = 108;BA.debugLine="listaPrin.Clear";
_listaprin.Clear();
 //BA.debugLineNum = 109;BA.debugLine="listaPrin.Visible = False";
_listaprin.setVisible(__c.False);
 //BA.debugLineNum = 110;BA.debugLine="If lv.Visible = False Then lv.Visible = True";
if (_lv.getVisible()==__c.False) { 
_lv.setVisible(__c.True);};
 //BA.debugLineNum = 111;BA.debugLine="If New.Length < MIN_LIMIT Then Return";
if (_new.length()<_min_limit) { 
if (true) return "";};
 //BA.debugLineNum = 112;BA.debugLine="Dim str1, str2 As String";
_str1 = "";
_str2 = "";
 //BA.debugLineNum = 113;BA.debugLine="str1 = New.ToLowerCase";
_str1 = _new.toLowerCase();
 //BA.debugLineNum = 114;BA.debugLine="If str1.Length > MAX_LIMIT Then";
if (_str1.length()>_max_limit) { 
 //BA.debugLineNum = 115;BA.debugLine="str2 = str1.SubString2(0, MAX_LIMIT)";
_str2 = _str1.substring((int) (0),_max_limit);
 }else {
 //BA.debugLineNum = 117;BA.debugLine="str2 = str1";
_str2 = _str1;
 };
 //BA.debugLineNum = 119;BA.debugLine="AddItemsToList(prefixList.Get(str2), str1)";
_additemstolist((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_prefixlist.Get((Object)(_str2)))),_str1);
 //BA.debugLineNum = 120;BA.debugLine="AddItemsToList(substringList.Get(str2), str1)";
_additemstolist((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_substringlist.Get((Object)(_str2)))),_str1);
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 19;BA.debugLine="et.Initialize(\"et\")";
_et.Initialize(ba,"et");
 //BA.debugLineNum = 21;BA.debugLine="et.InputType = Bit.Or(et.INPUT_TYPE_TEXT, 0x00080";
_et.setInputType(__c.Bit.Or(_et.INPUT_TYPE_TEXT,(int) (0x00080000)));
 //BA.debugLineNum = 23;BA.debugLine="lv.Initialize(\"lv\")";
_lv.Initialize(ba,"lv");
 //BA.debugLineNum = 24;BA.debugLine="lv.SingleLineLayout.ItemHeight = 50dip";
_lv.getSingleLineLayout().setItemHeight(__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 25;BA.debugLine="lv.SingleLineLayout.Label.TextSize = 14";
_lv.getSingleLineLayout().Label.setTextSize((float) (14));
 //BA.debugLineNum = 26;BA.debugLine="lv.Visible = False";
_lv.setVisible(__c.False);
 //BA.debugLineNum = 27;BA.debugLine="lv.Color = Colors.DarkGray";
_lv.setColor(__c.Colors.DarkGray);
 //BA.debugLineNum = 28;BA.debugLine="prefixList.Initialize";
_prefixlist.Initialize();
 //BA.debugLineNum = 29;BA.debugLine="substringList.Initialize";
_substringlist.Initialize();
 //BA.debugLineNum = 30;BA.debugLine="mCallback = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 31;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public String  _listaprin_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Sub listaPrin_ItemClick (Position As Int, Value As";
 //BA.debugLineNum = 92;BA.debugLine="ToastMessageShow(Value, True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_value),__c.True);
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public String  _lv_itemclick(int _position,Object _value) throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 94;BA.debugLine="Private Sub lv_ItemClick (Position As Int, Value A";
 //BA.debugLineNum = 95;BA.debugLine="et.Text = Value";
_et.setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 97;BA.debugLine="et.SelectionStart = et.Text.Length";
_et.setSelectionStart(_et.getText().length());
 //BA.debugLineNum = 98;BA.debugLine="Dim IME As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 99;BA.debugLine="IME.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 100;BA.debugLine="lv.Visible = False";
_lv.setVisible(__c.False);
 //BA.debugLineNum = 101;BA.debugLine="If SubExists(mCallback, mEventName & \"_ItemClick\"";
if (__c.SubExists(ba,_mcallback,_meventname+"_ItemClick")) { 
 //BA.debugLineNum = 102;BA.debugLine="CallSub2(mCallback, mEventName & \"_ItemClick\", V";
__c.CallSubNew2(ba,_mcallback,_meventname+"_ItemClick",_value);
 };
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public String  _setindex(Object _index) throws Exception{
Object[] _obj = null;
 //BA.debugLineNum = 189;BA.debugLine="Public Sub SetIndex(Index As Object)";
 //BA.debugLineNum = 190;BA.debugLine="Dim obj() As Object";
_obj = new Object[(int) (0)];
{
int d0 = _obj.length;
for (int i0 = 0;i0 < d0;i0++) {
_obj[i0] = new Object();
}
}
;
 //BA.debugLineNum = 191;BA.debugLine="obj = Index";
_obj = (Object[])(_index);
 //BA.debugLineNum = 192;BA.debugLine="prefixList = obj(0)";
_prefixlist.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_obj[(int) (0)]));
 //BA.debugLineNum = 193;BA.debugLine="substringList = obj(1)";
_substringlist.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_obj[(int) (1)]));
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public Object  _setitems(anywheresoftware.b4a.objects.collections.List _items) throws Exception{
long _starttime = 0L;
anywheresoftware.b4a.objects.collections.Map _noduplicates = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
anywheresoftware.b4a.objects.collections.List _li = null;
int _i = 0;
String _item = "";
int _start = 0;
int _count = 0;
String _str = "";
 //BA.debugLineNum = 137;BA.debugLine="Public Sub SetItems(Items As List) As Object";
 //BA.debugLineNum = 138;BA.debugLine="Dim startTime As Long";
_starttime = 0L;
 //BA.debugLineNum = 139;BA.debugLine="startTime = DateTime.Now";
_starttime = __c.DateTime.getNow();
 //BA.debugLineNum = 140;BA.debugLine="ProgressDialogShow2(\" \", False)";
__c.ProgressDialogShow2(ba,BA.ObjectToCharSequence(" "),__c.False);
 //BA.debugLineNum = 141;BA.debugLine="Dim noDuplicates As Map";
_noduplicates = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 142;BA.debugLine="noDuplicates.Initialize";
_noduplicates.Initialize();
 //BA.debugLineNum = 143;BA.debugLine="prefixList.Clear";
_prefixlist.Clear();
 //BA.debugLineNum = 144;BA.debugLine="substringList.Clear";
_substringlist.Clear();
 //BA.debugLineNum = 145;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 146;BA.debugLine="Dim li As List";
_li = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 147;BA.debugLine="For i = 0 To Items.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_items.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 148;BA.debugLine="If i Mod 100 = 0 Then DoEvents";
if (_i%100==0) { 
__c.DoEvents();};
 //BA.debugLineNum = 149;BA.debugLine="Dim item As String";
_item = "";
 //BA.debugLineNum = 150;BA.debugLine="item = Items.Get(i)";
_item = BA.ObjectToString(_items.Get(_i));
 //BA.debugLineNum = 151;BA.debugLine="item = item.ToLowerCase";
_item = _item.toLowerCase();
 //BA.debugLineNum = 152;BA.debugLine="noDuplicates.Clear";
_noduplicates.Clear();
 //BA.debugLineNum = 153;BA.debugLine="For start = 0 To item.Length";
{
final int step16 = 1;
final int limit16 = _item.length();
_start = (int) (0) ;
for (;_start <= limit16 ;_start = _start + step16 ) {
 //BA.debugLineNum = 154;BA.debugLine="Dim count As Int";
_count = 0;
 //BA.debugLineNum = 155;BA.debugLine="count = MIN_LIMIT";
_count = _min_limit;
 //BA.debugLineNum = 156;BA.debugLine="Do While count <= MAX_LIMIT And start + count <";
while (_count<=_max_limit && _start+_count<=_item.length()) {
 //BA.debugLineNum = 157;BA.debugLine="Dim str As String";
_str = "";
 //BA.debugLineNum = 158;BA.debugLine="str = item.SubString2(start, start + count)";
_str = _item.substring(_start,(int) (_start+_count));
 //BA.debugLineNum = 159;BA.debugLine="If noDuplicates.ContainsKey(str) = False Then";
if (_noduplicates.ContainsKey((Object)(_str))==__c.False) { 
 //BA.debugLineNum = 160;BA.debugLine="noDuplicates.Put(str, \"\")";
_noduplicates.Put((Object)(_str),(Object)(""));
 //BA.debugLineNum = 161;BA.debugLine="If start = 0 Then m = prefixList Else m = sub";
if (_start==0) { 
_m = _prefixlist;}
else {
_m = _substringlist;};
 //BA.debugLineNum = 162;BA.debugLine="li = m.Get(str)";
_li.setObject((java.util.List)(_m.Get((Object)(_str))));
 //BA.debugLineNum = 163;BA.debugLine="If li.IsInitialized = False Then";
if (_li.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 164;BA.debugLine="li.Initialize";
_li.Initialize();
 //BA.debugLineNum = 165;BA.debugLine="m.Put(str, li)";
_m.Put((Object)(_str),(Object)(_li.getObject()));
 };
 //BA.debugLineNum = 167;BA.debugLine="li.Add(Items.Get(i)) 'Preserve the original c";
_li.Add(_items.Get(_i));
 };
 //BA.debugLineNum = 169;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 }
;
 }
};
 }
};
 //BA.debugLineNum = 173;BA.debugLine="ProgressDialogHide";
__c.ProgressDialogHide();
 //BA.debugLineNum = 174;BA.debugLine="Log(\"Index time: \" & (DateTime.Now - startTime) &";
__c.LogImpl("76750245","Index time: "+BA.NumberToString((__c.DateTime.getNow()-_starttime))+" ms ("+BA.NumberToString(_items.getSize())+" Items)",0);
 //BA.debugLineNum = 175;BA.debugLine="Return Array As Object(prefixList, substringList)";
if (true) return (Object)(new Object[]{(Object)(_prefixlist.getObject()),(Object)(_substringlist.getObject())});
 //BA.debugLineNum = 176;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
