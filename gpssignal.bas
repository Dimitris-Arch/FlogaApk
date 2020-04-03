B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
    
	Public rp As RuntimePermissions
Dim GPS1 As GPS
Dim timer1 As Timer
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

'Dim AdView1 As AdView	

	
	Private mple As Label
	Private simanseislabel As Label
	Private simanseislabel2 As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label
	Dim sv2d As ScrollView2D
	
	
		Dim Id As InputDialog
	Dim k As Int
	'''''''''''''''''''''''''''''''''''
Dim res As List
Dim egsaLat As Label
Dim egsaLon As Label
   Dim bmp As Bitmap
   Dim pw As PhoneWakeState
   ' Dim lblLon As Label
  '  Dim lblLat As Label
	  Dim lblLon1 As Label
    Dim lblLat1 As Label
   ' Dim lblSpeed As Label
    Dim lblSatellites As Label
	'Dim lblHEIGTH As Label
   Dim txt As Label
Dim txtall As Label
	Dim now As Long
	Dim t As String
	Dim s As String
'	Dim buttonsave As Button
   Dim txtgooglon As Label
   Dim txtgooglan As Label
'	Private Button3 As Button
'	Private Button2 As Button
'	Private Button4 As Button
'	Private back1 As ImageView
'	Private Button0 As Button
' Private txt0 As  EditText
' Dim buttons As Button
 



Dim googlan As Label
Dim googlon As Label
   
   
		Dim ps As PhoneSensors
		Dim panel1 As Panel
	
   
   Dim sc As ScrollView
  
'	Private kato As Button
	
	
	Private lat As Label
	Private lot As Label
	Private lotl As Label
	Private latl As Label
	Private ipsos As Label
	
	Dim txt0 As Label
	
	'Dim AnimatedAndroid As AnimationDrawable
	'Dim AnimationView As ImageView

	
	Private sima1 As Label
	Private sima2 As Label
	Private simaok As Label
	Private sima As Label
	
	Private panelola As Panel
	
	Private ipsosl As Label
	Private Panelab As Panel
	
	
	
	Dim a As Button
	Dim a1 As Button
    Dim b As Button
	Dim g As Button
	Dim d As Button
	Dim e As Button
	Dim z As Button
	Dim h As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("gpss")
	pw.KeepAlive(True)
	k = 0
	timer1.Initialize("timer1",500)
	timer1.Enabled = True
	bmp.InitializeSample(File.DirAssets, "titlos.png",48,48)
	
        GPS1.Initialize("GPS")
    
	
	'If GPS1.GPSEnabled = False Then
    '    ToastMessageShow("Παρακαλω ενεργοποιήστε το GPS", True)
    '    StartActivity(GPS1.LocationSettingsIntent) 'Will open the relevant settings screen.
    'Else
    '    GPS1.Start(0, 0) 'Listen to GPS with no filters.
    'End If
	'''''''''''''''''''
	If GPS1.GPSEnabled = False Then
		ToastMessageShow("Παρακαλω ενεργοποιήστε το GPS", True)
		StartActivity(GPS1.LocationSettingsIntent) 'Will open the relevant settings screen.
	Else
		rp.CheckAndRequest(rp.PERMISSION_ACCESS_FINE_LOCATION) 
		Wait For Activity_PermissionResult (Permission As String, Result As Boolean)
		If Result Then GPS1.Start(0, 0)
		If Result = False Then
			ToastMessageShow("Η εφαρμογή χρειάζεται δικαιωματα στο gps της συσκευης", True)
		End If
	End If
	''''''''''''''''
	If File.Exists(File.DirInternal, "gpsfire.txt") = False Then
		File.WriteString(File.DirInternal, "gpsfire.txt", txtall.Text)
End If
	If File.Exists(File.DirInternal, "gpsfireall.txt") = False Then
		File.WriteString(File.DirInternal, "gpsfireall.txt", txtall.Text)
End If
	If File.Exists(File.DirInternal, "txtgooglon.txt") = False Then
		File.WriteString(File.DirInternal, "txtgooglon.txt", txtall.Text)
	End If
	If File.Exists(File.DirInternal, "txtgooglan.txt") = False Then
		File.WriteString(File.DirInternal, "txtgooglan.txt", txtall.Text)
End If
	txtall.Text = File.ReadString(File.DirInternal, "gpsfireall.txt")
	googlon.text = File.ReadString(File.DirInternal, "txtgooglon.txt")
	googlan.text = File.ReadString(File.DirInternal, "txtgooglan.txt")

googlon.text = googlon.text.Replace (":"," ")
	googlon.text = googlon.text.Replace (",",".")
	
	googlan.text = googlan.text.Replace (":"," ")
	googlan.text = googlan.text.Replace (",",".")



sv2d.Initialize(240%x, 10%y, "sv2d")
Panelab.AddView(sv2d, 0%x, 0%y, 100%x, 10%y)
	
	
	a.Initialize("a")
	a1.Initialize("a1")
	b.Initialize("b")
	g.Initialize("g")
	d.Initialize("d")
	e.Initialize("e")
	z.Initialize("z")
	h.Initialize("h")
	a.Text = "Αποθήκευση Συντεταγμένων"
	a.TextSize = 14
	sv2d.Panel.AddView(a, 0%x, 0%y, 40%x, 10%y)
	a.SetBackgroundImage(LoadBitmap(File.DirAssets, "alla.png"))
	a.TextColor = Colors.White
	a.Gravity = Gravity.CENTER_VERTICAL
	a.Gravity = Gravity.CENTER_HORIZONTAL
	
		a1.Text = "Αποθήκευση Συντεταγμένων"
	a1.TextSize = 14
	sv2d.Panel.AddView(a1, 0%x, 0%y, 40%x, 10%y)
	a1.SetBackgroundImage(LoadBitmap(File.DirAssets, "alla.png"))
	a1.TextColor = Colors.White
	a1.Gravity = Gravity.CENTER_VERTICAL
	a1.Gravity = Gravity.CENTER_HORIZONTAL
	a1.Visible = False
	
	
	b.Text = "Αποστολή συντεταγμένων"
	b.TextSize = 14
	sv2d.Panel.AddView(b, 40%x, 0%y, 40%x, 10%y)
	b.SetBackgroundImage(LoadBitmap(File.DirAssets, "alla.png"))
	b.TextColor = Colors.White
	b.Gravity = Gravity.CENTER_VERTICAL
	b.Gravity = Gravity.CENTER_HORIZONTAL
	
	
	g.Text = "Τελευταία τοποθεσία"
	g.TextSize = 14
	sv2d.Panel.AddView(g, 80%x, 0%y, 40%x, 10%y)
	g.SetBackgroundImage(LoadBitmap(File.DirAssets, "alla.png"))
	g.TextColor = Colors.White
	g.Gravity = Gravity.CENTER_VERTICAL
	g.Gravity = Gravity.CENTER_HORIZONTAL
	
	
	d.Text = "Ιστορικό"
	d.TextSize = 14
	sv2d.Panel.AddView(d, 120%x, 0%y, 40%x, 10%y)
	d.SetBackgroundImage(LoadBitmap(File.DirAssets, "alla.png"))
	d.TextColor = Colors.White
	d.Gravity = Gravity.CENTER_VERTICAL
	d.Gravity = Gravity.CENTER_HORIZONTAL
	
	
	e.Text = "Διαγραφή ιστορικού"
	e.TextSize = 14
	sv2d.Panel.AddView(e, 160%x, 0%y, 40%x, 10%y)
	e.SetBackgroundImage(LoadBitmap(File.DirAssets, "alla.png"))
	e.TextColor = Colors.White
	e.Gravity = Gravity.CENTER_VERTICAL
	e.Gravity = Gravity.CENTER_HORIZONTAL
	
	
	z.Text = "Προβολή στον χάρτη"
	z.TextSize = 14
	sv2d.Panel.AddView(z, 200%x, 0%y, 40%x, 10%y)
	z.SetBackgroundImage(LoadBitmap(File.DirAssets, "alla.png"))
	z.TextColor = Colors.White
	z.Gravity = Gravity.CENTER_VERTICAL
	z.Gravity = Gravity.CENTER_HORIZONTAL
	
	
	h.Text = "Οδηγίες"
	h.TextSize = 14
	sv2d.Panel.AddView(h, 240%x, 0%y, 40%x, 10%y)
	h.SetBackgroundImage(LoadBitmap(File.DirAssets, "alla.png"))
	h.TextColor = Colors.White
	h.Gravity = Gravity.CENTER_VERTICAL
	h.Gravity = Gravity.CENTER_HORIZONTAL
		a.Enabled = False
		b.Enabled = False
		z.Enabled = False
		egsaLon.Visible = False
        egsaLat.Visible = False
		ipsosl.Visible = False
ipsos.Visible = False
lat.Visible = False
lot.Visible = False
lotl.Visible = False
latl.Visible = False
simaok.Visible = False
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	GPS1.Stop
Activity.Finish
End Sub
Sub GPS_LocationChanged (Location1 As Location)
	
	
	If simanseislabel.Visible = True Then
ipsosl.Visible = True
ipsos.Visible = True
lat.Visible = True
lot.Visible = True
lotl.Visible = True
latl.Visible = True
simaok.Visible = True
 End If

If simanseislabel.Visible = False Then
ipsosl.Visible = True
ipsos.Visible = True
lat.Visible = True
lot.Visible = True
egsaLat.Visible = True
egsaLon.Visible = True
simaok.Visible = True
 End If


  DateTime.DateFormat = "dd/MM/yy HH:mm"
now = DateTime.now                              
t = DateTime.Time(now)     
s = DateTime.Date(now)
    lotl.Text =  Location1.ConvertToSeconds(Location1.Latitude) & "N"
    latl.Text = Location1.ConvertToSeconds(Location1.Longitude)& "E"
    ipsosl.Text = Location1.Altitude
	
	lblLat1.Text = Location1.ConvertToseconds(Location1.Latitude) 
    lblLon1.Text = Location1.ConvertToseconds(Location1.Longitude)
	
	googlan.Text = Location1.ConvertToseconds(Location1.Latitude) 
    googlon.Text = Location1.ConvertToseconds(Location1.Longitude)
	File.WriteString(File.DirInternal, "txtgooglon.txt", googlon.Text)
	File.WriteString(File.DirInternal, "txtgooglan.txt", googlan.Text)
	Log(Location1)
  
   'Label1.Visible = False
   
   

	'lotl.visible = False
	'latl.visible = False
   
	txt.text = Id.Input  & CRLF & latl.Text & CRLF & lotl.Text & CRLF  & s & CRLF
	File.WriteString(File.DirInternal, "gpsfire.txt", txt.Text)

'''''''''''''''''''''''''''''''''''''''egsa''''''''''''''''''''''''
res = Egsa87.FLWGS84_TO_XYEGSA87(Location1.Latitude,Location1.Longitude)

egsaLon.text ="X: " & Round2(res.Get(0),3)
egsaLat.text ="Y: " & Round2(res.Get(1),3)
	
	Log(Location1)
	Log(Location1.Latitude)
	Log(Location1.Longitude)


'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

timer1.Enabled = False
   simaok.visible = True
   
   sima.Visible = False
		sima1.Visible = False
		sima2.Visible = False
		a.Enabled = True
		b.Enabled = True
		z.Enabled = True
End Sub

Sub GPS_UserEnabled (Enabled As Boolean)
   ' ToastMessageShow("Ενεργοποίηση GPS = " & Enabled, True)
End Sub

Sub GPS1_GpsStatus (Satellites As List)
	Dim i As Int
	
	Dim txt1, txt2, txt3, txt4, txt5 As String
	
	txt1 = "Index"
	txt2 = "Azimuth"
	txt3 = "Elevation"
	txt4 = "Used"
	txt5 = "S / N ratio"
	'lblSatellitesNb.Text = "Nb. of satellites: " & Satellites.Size
	Activity.Title = "Sats " & Satellites.Size
	For i = 0 To Satellites.Size -1
		Dim GPSSat As GPSSatellite
		GPSSat = Satellites.Get(i)
		txt1 = txt1 & CRLF & (i + 1) 
		txt2 = txt2 & CRLF & GPSSat.Azimuth
		txt3 = txt3 & CRLF & GPSSat.Elevation
		txt4 = txt4 & CRLF & GPSSat.UsedInFix
		txt5 = txt5 & CRLF & Round2(GPSSat.Snr, 2)
		Activity.Title = "Set " & i
	
	Next
	'lblSatellites.Text = Satellites.Size
'	lblSatellitesIndex.Text = txt1
'	lblSatellitesAzimuth.Text = txt2
'	lblSatellitesElevation.Text = txt3
	
'	lblSatellitesS_N.Text = txt5
End Sub
Sub simanseislabel_Click
	latl.Visible = False
	lotl.Visible = False
	
   egsaLon.Visible = True
   egsaLat.Visible = True
   a.Visible = False
   a1.Visible = True
	
	
	simanseislabel.Visible = False
	simanseislabel2.Visible = True
End Sub
Sub simanseislabel2_Click
	latl.Visible = True
	lotl.Visible = True
    egsaLon.Visible = False
    egsaLat.Visible = False
    a.Visible = True
    a1.Visible = False
	
	simanseislabel2.Visible = False
	simanseislabel.Visible = True
End Sub
Sub listabel_Click
	StartActivity("thlefona")
End Sub
Sub katigorlabel_Click
	StartActivity("pixida")
End Sub
Sub ousialabel_Click
	StartActivity("gpssignal")
End Sub
Sub ililabel_Click
	StartActivity("firstaid")
End Sub
Sub save_click
				
		Dim r As List 
   r.Initialize 
   r.AddAll(Array As String("Αποθηκεύση στην επιλεγμένη μορφή","Αποθηκεύση σε ΕΓΣΑ87 και WGS84"))
   
   
   Dim x As id 
   m = x.InputList1(r,"Επιλογή μορφής για αποθηκεύση")
   
    If m = 0 Then
   mono
	End If
	If m = 1 Then
	mazi
	End If
End Sub


Sub mono


 Id.InputType = Id.INPUT_TYPE_TEXT
Id.Input = ""
	Id.Hint = "Πληκτρολογίστε εδώ τίτλο"
	Id.HintColor = Colors.ARGB(196, 255, 140, 0)
	ret = DialogResponse.CANCEL
	ret = Id.Show("", "", "OK", "", "", bmp)
	Msgbox(Id.Input,"")
	meta
	
End Sub
Sub monoegsa


 Id.InputType = Id.INPUT_TYPE_TEXT
Id.Input = ""
	Id.Hint = "Πληκτρολογίστε εδώ τίτλο"
	Id.HintColor = Colors.ARGB(196, 255, 140, 0)
	ret = DialogResponse.CANCEL
	ret = Id.Show("", "", "OK", "", "", bmp)
	Msgbox(Id.Input,"")
	metaegsa
	
End Sub

Sub mazi
	Id.InputType = Id.INPUT_TYPE_TEXT
Id.Input = ""
	Id.Hint = "Πληκτρολογίστε εδώ τίτλο"
	Id.HintColor = Colors.ARGB(196, 255, 140, 0)
	ret = DialogResponse.CANCEL
	ret = Id.Show("", "", "OK", "", "", bmp)
	Msgbox(Id.Input,"")
	mazimeta
	
End Sub

Sub mazimeta
	
	txt.text = Id.Input & CRLF & "WGS84"  & CRLF & latl.Text & CRLF & lotl.Text & CRLF  & s & CRLF & CRLF & "ΕΓΣΑ87"  & CRLF &egsaLon.text & CRLF & egsaLat.text & CRLF  & s 
	File.WriteString(File.DirInternal, "gpsfire.txt", txt.Text)
  txtall.text = txtall.Text & CRLF & txt.text & CRLF
	File.WriteString(File.DirInternal, "gpsfireall.txt", txtall.Text)
	File.WriteString(File.DirInternal, "txtgooglon.txt", googlon.Text)
	File.WriteString(File.DirInternal, "txtgooglan.txt", googlan.Text)
	GPS1.Stop
Msgbox("Η τοποθεσία αποθηκεύτηκε","")
	
End Sub
Sub meta
	txt.text = Id.Input  & CRLF & latl.Text & CRLF & lotl.Text & CRLF  & s & CRLF 
	File.WriteString(File.DirInternal, "gpsfire.txt", txt.Text)
  txtall.text = txtall.Text & CRLF & txt.text & CRLF
	File.WriteString(File.DirInternal, "gpsfireall.txt", txtall.Text)
	File.WriteString(File.DirInternal, "txtgooglon.txt", googlon.Text)
	File.WriteString(File.DirInternal, "txtgooglan.txt", googlan.Text)
	GPS1.Stop
Msgbox("Η τοποθεσία αποθηκεύτηκε","")
End Sub

Sub metaegsa
	txt.text = Id.Input  & CRLF  & egsaLon.text & CRLF & egsaLat.text & CRLF  & s & CRLF 
	File.WriteString(File.DirInternal, "gpsfire.txt", txt.Text)

  txtall.text = txtall.Text & CRLF & txt.text & CRLF
	File.WriteString(File.DirInternal, "gpsfireall.txt", txtall.Text)
	GPS1.Stop
Msgbox("Η τοποθεσία αποθηκεύτηκε","")
End Sub
Sub meny_Click
	Activity.OpenMenu
End Sub

Sub mnagain_Click
	
	Activity.Finish
StartActivity(Me)
	
End Sub

Sub mnlast_Click
	Dim result As Int
result = Msgbox2("Ιστορικό", "", "Αποστολή", " ", "Προβολή", LoadBitmap(File.DirAssets, "Delete.png"))
If result = DialogResponse.Positive Then 
	Dim share As Intent
share.Initialize(share.ACTION_SEND,"")
share.SetType("text/plain")
		share.PutExtra("android.intent.extra.TEXT", File.ReadString(File.DirInternal, "gpsfire.txt"))
share.WrapAsIntentChooser("Share text via")
StartActivity(share)
	 Else
		Msgbox(File.ReadString(File.DirInternal, "gpsfire.txt")," " )
	End If
End Sub
Sub mnhistory_Click
	
	Msgbox(File.ReadString(File.DirInternal, "gpsfireall.txt")," " )
	
End Sub
Sub mninfo_Click
Msgbox("Η εφαρμογή αποθηκεύει την τελευταία τοποθεσία gps και δημιουργεί ιστορικό","Συντεταγμένες DMS")
Msgbox("Την πρώτη φορά ενδέχεται να καθυστερήσει η εύρεση δορυφόρων ανάλογα με τον δέκτη κάθε κινητού τηλεφώνου.Βεβαιωθείτε οτι έχετε ενεργοποιημένες στις ρυθμίσεις των δορυφόρων gps ","")
Msgbox("Ο αριθμός που εμφανίζεται είναι κατα σειρά Μοίρες(Degrees):Λεπτά(Minutes):Δευτερόλεπτα(Seconds) (xx:xx:xx.xxx)","")
Msgbox("Στην ιστοσελίδα google maps και στην αναζήτηση τοποθεσίας,αντικαθιστούμε την άνω κάτω τελεία(:) σε κενό και το κόμμα σε τελεία.Bάζουμε πρώτα το γεωγραφικό πλάτος,έπειτα με κενό βάζουμε το γεωγραφικό μήκος και πατάμε αναζήτηση","Μεταφορά στο Google maps")
Msgbox("πχ 41:08:29,0N και 24:53:19,5E  αλλαγή σε 41 08 29.0N 24 53 19.5E ","")
End Sub

Sub mndel_Click
Dim result As Int
result = Msgbox2("Διαγραφή ιστορικού", "", "Ναί", " ", "Όχι", LoadBitmap(File.DirAssets, "Delete.png"))
If result = DialogResponse.Positive Then 
	Msgbox("Ιστορικο διαγράφηκε","")
	txt0.Text = txt.Text
		File.WriteString(File.DirInternal, "gpsfireall.txt", txt0.Text)
	End If
	End Sub
	
Sub mnmap_Click
	lblLat1.text = lblLat1.text.Replace (":"," ")
	lblLat1.text = lblLat1.text.Replace (",",".")
	
	lblLon1.text = lblLon1.text.Replace (":"," ")
	lblLon1.text = lblLon1.text.Replace (",",".")

	Dim intent1 As Intent
	URI = "geo:" & lblLat1.Text & "," & lblLon1.text & "?q=" & lblLat1.Text & "," & lblLon1.Text 
	intent1.Initialize(intent1.ACTION_VIEW, URI)
	intent1.SetComponent("googlemaps")
	StartActivity(intent1)
	


End Sub


Sub mnasend_Click

	Dim share As Intent
	
share.Initialize(share.ACTION_SEND,"")
share.SetType("text/plain")
	share.PutExtra("android.intent.extra.TEXT", File.ReadString(File.DirInternal, "gpsfire.txt"))
share.WrapAsIntentChooser("Share text via")
StartActivity(share)

End Sub
 Sub timer1_Tick
 	
	k = k + 1
	
	If k = 1.0 Then 
		sima.Visible = True
		sima1.Visible = False
		sima2.Visible = False
	End If
	
	If k = 2.0 Then 
		sima.Visible = False
		sima1.Visible = True
		sima2.Visible = False
	End If
	
	If k > 2.0 Then 
		sima.Visible = False
		sima1.Visible = False
		sima2.Visible = True
	End If
	
	
	If k = 3.0 Then
		k = 0
		
	End If
	
End Sub
Sub a_click
	save_click
End Sub
Sub b_click
	mnasend_Click
End Sub
Sub g_click
	mnlast_Click
End Sub
Sub d_click
	mnhistory_Click
End Sub
Sub e_click
	mndel_Click
End Sub
Sub z_click
	mnmap_Click
End Sub
Sub h_click
	mninfo_Click
End Sub
Sub a1_click
	
		
		Dim r As List 
   r.Initialize 
   r.AddAll(Array As String("Αποθηκεύση στην επιλεγμένη μορφή","Αποθηκεύση σε ΕΓΣΑ87 και WGS84"))
   
   
   Dim x As id 
   m = x.InputList1(r,"Επιλογή μορφής για αποθηκεύση")
   
    If m = 0 Then
   monoegsa
	End If
	If m = 1 Then
	mazi
	End If
End Sub



Sub simaok_Click
	mnagain_Click
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
      
		Activity.Finish
	End If
End Sub