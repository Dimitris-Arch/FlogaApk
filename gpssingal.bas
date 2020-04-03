Type=Activity
Version=3.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
    Dim GPS1 As GPS
	
End Sub

Sub Globals
Dim sc As ScrollView
Dim Panel As Panel
Dim Panel1 As Panel
    Dim pw As PhoneWakeState
    Dim lblLon As Label
    Dim lblLat As Label
	  Dim lblLon1 As Label
    Dim lblLat1 As Label
   ' Dim lblSpeed As Label
    Dim lblSatellites As Label
	'Dim lblHEIGTH As Label
	Private Button1 As Button
	Dim xi As ImageView

	Dim AnimatedAndroid As AnimationDrawable
	Dim AnimationView As ImageView
'	Dim Transition As TransitionDrawable
	'Private Label1 As Label
	
	Dim bt As Button
Dim txt As EditText
Dim txtall As EditText
	Dim now As Long
	Dim t As String
	Dim s As String
	Dim buttonsave As Button
   Dim txtgooglon As EditText
   Dim txtgooglan As EditText
	Private Button3 As Button
	Private Button2 As Button
	Private Button4 As Button
	
	Private Button0 As Button
 Private txt0 As  EditText
 Dim buttons As Button
 
Dim labeltest As Label
Dim labeltestmi As Label
Dim labeltestse As Label

Dim exodos As Button
Dim googlan As EditText
Dim googlon As EditText
Dim Adview1 As AdView
Dim ili As Button
Dim ousia As Button
Dim simansi As Button
Dim pixi As Button

Dim lista As Button

	Private katigor As Button
	
	Dim fakos As Label
	
	Private mple As ImageView
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
   
		Activity.LoadLayout("gpssignal")
		 sc.initialize(1000dip)
 Activity.AddView(sc,3%x,33%y,94%x,57.5%y)
 
 sc.Panel.Width = 96%x
 sc.Panel.height = 130%y

   Panel1.RemoveView
  sc.Panel.AddView( Panel1,0%x,-50%y,94%x,130%y)
		
		
		Adview1.Initialize("Ad", "ca-app-pub-6889311870331566/2287503739")
 
 Dim height As Int
    
    height = 50dip
    
 
	 Activity.AddView(Adview1, 0dip, 100%y - height, 100%x, height)
   Adview1.LoadAd

		
		
		
		
		
		
		
		
		
		If FirstTime Then
        GPS1.Initialize("GPS")
    End If
	'Label1.Visible = False
	pw.KeepAlive(True)
	
		exodos.Visible = False
	'test.Visible = False
	lblLon1.Visible = False
    lblLat1.Visible = False
	
	lblLat.Top = 10%y
	lblLat.Width = 90%x
	lblLat.Left = 5%x
	lblLat.height = 12%y
	
	lblLon.Top = 24%y
	lblLon.Width = 90%x
	lblLon.Left = 5%x
	lblLon.height = 12%y
	
	'lblHEIGTH.Top = 36%y
	'lblHEIGTH.Width = 100%x
	'lblHEIGTH.Left = 0%x
	'lblHEIGTH.Height = 12%y
	
	lblLat.visible = False
	lblLon.visible = False
	'lblHEIGTH.visible = False
	
	
	
	Button0.Top = 71%y
	Button0.Width = 100%x
	Button0.Left = 0%x
	Button0.height = 8%y
	
	xi.Top = 71%y	
	xi.Width = 10%x
	xi.Left = 85%x
	xi.height = 8%y
	
	
	Button1.Top = 61%y
	Button1.Width = 100%x
	Button1.Left = 0%x
	Button1.height = 8%y
	
    Button2.Top = 51%y
	Button2.Width = 100%x
	Button2.Left = 0%x
	Button2.height = 8%y 
	
	buttons.Top = 51%y
	buttons.Width = 100%x
	buttons.Left = 0%x
	buttons.height = 8%y 
	
	buttonsave.Top = 51%y
	buttonsave.Width = 100%x
	buttonsave.Left = 0%x
	buttonsave.height = 8%y 
	
	
	
	
	
	
	Button3.Top = 81%y
	Button3.Width = 100%x
	Button3.Left = 0%x
	Button3.height = 8%y
	
	Button4.Top = 91%y
	Button4.Width = 100%x
	Button4.Left = 0%x
	Button4.height = 8%y
	simanseislabel.Top = 3%y
simanseislabel.left = 3.5%x
simanseislabel.height = 27.5%y
simanseislabel.Width  = 45%x
   simansi.Top = 3%y
simansi.left = 3%x
simansi.height = 28%y
simansi.Width  = 45%x



''PANW DEXIA MESH
lista.Top = 3%y
lista.left = 51.5%x
lista.height = 13%y
lista.Width  = 21.25%x

listabel.Top = 3%y
listabel.left = 51.75%x
listabel.height = 13%y
listabel.Width  = 21.25%x



katigor.Top = 18%y
katigor.left = 51.50%x
katigor.height = 13%y
katigor.Width  = 21.25%x

katigorlabel.Top = 18%y
katigorlabel.left = 51.75%x
katigorlabel.height = 13%y
katigorlabel.Width  = 21.25%x
'PANW DEXIA AKRH
ousia.Top = 3%y
ousia.left = 75.75%x
ousia.height = 13%y
ousia.Width  = 21.25%x
ousialabel.Top = 3%y
ousialabel.left = 76%x
ousialabel.height = 13%y
ousialabel.Width  = 21.25%x

ili.Top = 18%y
ili.left = 75.75%x
ili.height = 13%y
ili.Width  = 21.25%x
ililabel.Top = 18%y
ililabel.left = 76%x
ililabel.height = 13%y
ililabel.Width  = 21.25%x
   

mple.top = 93%y
mple.left = 3%x
mple.width = 94%x
mple.height = 7%y


	If File.Exists(File.DirRootExternal, "gpsfire.txt") = False Then
    File.WriteString(File.DirRootExternal, "gpsfire.txt", txtall.Text)
End If
If File.Exists(File.DirRootExternal, "gpsfireall.txt") = False Then
    File.WriteString(File.DirRootExternal, "gpsfireall.txt", txtall.Text)
End If
If File.Exists(File.DirRootExternal, "txtgooglon.txt") = False Then
    File.WriteString(File.DirRootExternal, "txtgooglon.txt", txtall.Text)
	End If
	If File.Exists(File.DirRootExternal, "txtgooglan.txt") = False Then
    File.WriteString(File.DirRootExternal, "txtgooglan.txt", txtall.Text)
	
	

End If
End Sub

Sub Activity_Resume
    If GPS1.GPSEnabled = False Then
        ToastMessageShow("Παρακαλω ενεργοποιήστε το GPS", True)
        StartActivity(GPS1.LocationSettingsIntent) 'Will open the relevant settings screen.
    Else
        GPS1.Start(0, 0) 'Listen to GPS with no filters.
    End If
	
	
   


End Sub

Sub Activity_Pause (UserClosed As Boolean)
'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
    Activity.Finish

End Sub

Sub GPS_LocationChanged (Location1 As Location)

  DateTime.DateFormat = "dd/MM/yy HH:mm"
now = DateTime.now                              
t = DateTime.Time(now)     
s = DateTime.Date(now)
    lblLat.Text = "Γεωγραφικό πλάτος/Latitude " & Location1.ConvertToSeconds(Location1.Latitude) & "N"
    lblLon.Text = "Γεωγραφικό μήκος/Longitude " & Location1.ConvertToSeconds(Location1.Longitude)& "E"
'    lblHEIGTH.Text = "Υψόμετρο  " & Location1.Altitude
	
	lblLat1.Text = Location1.ConvertToseconds(Location1.Latitude) 
    lblLon1.Text = Location1.ConvertToseconds(Location1.Longitude)
	
	googlan.Text = Location1.ConvertToseconds(Location1.Latitude) 
    googlon.Text = Location1.ConvertToseconds(Location1.Longitude)
	File.WriteString(File.DirRootExternal, "txtgooglon.txt", googlon.Text)
	 File.WriteString(File.DirRootExternal, "txtgooglan.txt", googlan.Text)
   lblSatellites.visible = False
 '  AnimatedAndroid.Stop
  ' Label1.Visible = False
   
   AnimationView.Visible = False

	lblLat.visible = True
	lblLon.visible = True
'	lblHEIGTH.visible = True
   
  


buttons.visible = False
buttonsave.visible = True
	'Dim save1 As String = File.ReadString(File.DirRootExternal, "lat.txt")
	'Dim save2 As String = File.ReadString(File.DirRootExternal, "lon.txt")
'	test.Visible= True
'	test.Top = 90%y
'	test.Height = 8%y
'	test.Left = 40%x
'	test.Width = 20%x
End Sub

Sub GPS_UserEnabled (Enabled As Boolean)
   ' ToastMessageShow("Ενεργοποίηση GPS = " & Enabled, True)
End Sub

Sub GPS_GpsStatus (Satellites As List)
    lblSatellites.Text = "Δορυφόροι σε εμβέλεια:" & CRLF
    For i = 0 To Satellites.Size - 1
        Dim Satellite As GPSSatellite
        Satellite = Satellites.Get(i)
        lblSatellites.Text = lblSatellites.Text & CRLF & Satellite.Prn & _
            " " & Satellite.Snr & " " & Satellite.UsedInFix & " " & Satellite.Azimuth _ 
            & " " & Satellite.Elevation
    Next
	
End Sub



Sub Label2_Click
	Msgbox("Για την μεταφορά τον συντεταγμένων στον χάρτη πιθανόν να χρειαστεί να αντικατασταθεί το κόμμα στα δευτερόλεπτα με τελεία ","Αλλαγή απο xx,xxx σε xx.xxx")


End Sub







Sub Button3_Click
Msgbox("Η εφαρμογή αποθηκεύει την τελευταία τοποθεσία gps και δημιουργεί ιστορικό","Συντεταγμένες DMS")
Msgbox("Την πρώτη φορά ενδέχεται να καθυστερήσει η εύρεση δορυφόρων ανάλογα με τον δέκτη κάθε κινητού τηλεφώνου.Βεβαιωθείτε οτι έχετε ενεργοποιημένες στις ρυθμίσεις των δορυφόρων gps ","")
Msgbox("Ο αριθμός που εμφανίζεται είναι κατα σειρά Μοίρες(Degrees):Λεπτά(Minutes):Δευτερόλεπτα(Seconds) (xx:xx:xx.xxx)","")
Msgbox("Στην ιστοσελίδα google maps και στην αναζήτηση τοποθεσίας,αντικαθιστούμε την άνω κάτω τελεία(:) σε κενό και το κόμμα σε τελεία.Bάζουμε πρώτα το γεωγραφικό πλάτος,έπειτα με κενό βάζουμε το γεωγραφικό μήκος και πατάμε αναζήτηση","Μεταφορά στο Google maps")
Msgbox("πχ 41:08:29,0N και 24:53:19,5E  αλλαγή σε 41 08 29.0N 24 53 19.5E ","")
	Msgbox("Στο πρόγραμμα χάρτες της google,κάντε εστίαση σε μία περιοχή και γράψτε okay maps,με αυτό τον τρόπο αποθηκέυεται στο κινητό σας δωρεάν και μπορείτε να τον χρησιμοποιήσετε offline","TIP!!")


 
End Sub
Sub Button2_Click

	 
    
	
	AnimatedAndroid.Initialize
	For i = 0 To 7
		AnimatedAndroid.AddFrame(LoadBitmap(File.DirAssets, "frame" & i & ".png"), 80)
	Next
	AnimatedAndroid.OneShot = False

	AnimationView.Initialize("")
	AnimationView.Gravity = Gravity.NO_GRAVITY
	AnimationView.Background = AnimatedAndroid
	Panel1.AddView(AnimationView, 30%x, 10%y, 40%x, 30%y )
	AnimatedAndroid.Start
	Button2.Enabled = False
		Button2.Visible= False
		buttons.visible = True
		
		
		
		googlon.text = File.ReadString(File.DirRootExternal, "txtgooglon.txt")
googlan.text = File.ReadString(File.DirRootExternal, "txtgooglan.txt")

googlon.text = googlon.text.Replace (":"," ")
	googlon.text = googlon.text.Replace (",",".")
	
	googlan.text = googlan.text.Replace (":"," ")
	googlan.text = googlan.text.Replace (",",".")
End Sub
Sub Button1_Click


googlon.text = File.ReadString(File.DirRootExternal, "txtgooglon.txt")
googlan.text = File.ReadString(File.DirRootExternal, "txtgooglan.txt")

googlon.text = googlon.text.Replace (":"," ")
	googlon.text = googlon.text.Replace (",",".")
	
	googlan.text = googlan.text.Replace (":"," ")
	googlan.text = googlan.text.Replace (",",".")


	Msgbox(File.ReadString(File.DirRootExternal, "gpsfire.txt"), s)
	'Msgbox(File.ReadString(File.DirRootExternal, "gpsfireall.txt")," " )
	
	
	
	Dim result As Int
result = Msgbox2("Προβολή στον χάρτη;", "", "Ναί", "       ", "Όχι", LoadBitmap(File.DirAssets, "Google.png"))
If result = DialogResponse.Positive Then 
	
	
googlon.text = googlon.text.Replace (":"," ")
	googlon.text = googlon.text.Replace (",",".")
	
	googlan.text = googlan.text.Replace (":"," ")
	googlan.text = googlan.text.Replace (",",".")

	Dim intent1 As Intent
	URI = "geo:" & googlan.Text & "," & googlon.text & "?q=" & googlan.Text & "," & googlon.Text 
	intent1.Initialize(intent1.ACTION_VIEW, URI)
	intent1.SetComponent("googlemaps")
	StartActivity(intent1)
	
	
	
	
	
	
	End If
End Sub
Sub Button4_Click
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


Sub buttonsave_Click
	
	 txt.text = lblLat.Text & CRLF & lblLon.Text & CRLF  & s & CRLF 
	 
  File.WriteString(File.DirRootExternal, "gpsfire.txt", txt.Text)
  
  txtall.text = txtall.Text & CRLF & txt.text & CRLF
  File.WriteString(File.DirRootExternal, "gpsfireall.txt", txtall.Text)
	
	 File.WriteString(File.DirRootExternal, "txtgooglon.txt", googlon.Text)
	 File.WriteString(File.DirRootExternal, "txtgooglan.txt", googlan.Text)
	
	
	
	
	
	
	
Msgbox("Η τοποθεσία αποθηκεύτηκε","")
	
End Sub
Sub Button0_Click
	
	Msgbox(File.ReadString(File.DirRootExternal, "gpsfireall.txt")," " )
	


	'lblLon.Text = File.ReadString(File.DirRootExternal, "gpsfireall.txt")
	
	
	
	
	
	
	
	
End Sub
Sub xi_Click
	Dim result As Int
result = Msgbox2("Διαγραφή ιστορικού", "", "Ναί", " ", "Όχι", LoadBitmap(File.DirAssets, "Delete.png"))
If result = DialogResponse.Positive Then 
	Msgbox("Ιστορικο διαγράφηκε","")
	txt0.Text = txt.Text
	 File.WriteString(File.DirRootExternal, "gpsfireall.txt", txt0.Text)
	End If
	
End Sub
Sub Ad_FailedToReceiveAd (ErrorCode As String)
   Log("failed: " & ErrorCode)
End Sub
Sub Ad_ReceiveAd
    Log("received")
End Sub
Sub Ad_AdScreenDismissed
   Log("screen dismissed")
End Sub



Sub simansi_Click
	StartActivity("simanseis")
End Sub


Sub ili_Click
	StartActivity("ilika")
End Sub
Sub ousia_Click
	StartActivity("ousies")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("listaousies")
End Sub

Sub katigor_Click
	StartActivity("katigoriess")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("simanseis")
End Sub
Sub listabel_Click
	StartActivity("listaousies")
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
End Sub
Sub ililabel_Click
	StartActivity("ilika")
End Sub




