B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals

	
	Dim GPS1 As GPS
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	'Dim AdView1 As AdView

	Dim res As List
	Private mple As Label
	Private simanseislabel As Label
	
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label



	Dim res As List



	Dim txt0 As Label
	Private panelola As Panel

	'''''''''''''''''''''''''''
	Private MoiresDek As Panel    'ΜΟΙΡΕΣ ΣΕ ΔΕΚΑΔΙΚΑ
	

	Private lotl As EditText

	Private lot As EditText
	Private lotLEPTA As EditText
	Private lotDEYT As EditText
	Private lat As EditText
	Private latLEPTA As EditText
	Private latDEYT As EditText
	
	Private DekLot As EditText
	Private DekLat As EditText
	
	Private egsaLon As EditText
	Private egsaLAt As EditText

	Private okEgsa As Button
	Private okDekadika As Button
'	Private AllagiDeytera As Button
'	Private AllagiLepta As Button
	Private okMoires As Button
	
	Private lotMono As EditText
	Private latMono As EditText
	Dim egsaLatB As Boolean
	Dim egsaLonB As Boolean
	Dim deklotB As Boolean
	Dim deklatB As Boolean

	Dim latB As Boolean
	Dim lotB As Boolean
	Dim lotLEPTAB As Boolean
	Dim latLEPTAB As Boolean
	Dim latDEYTB As Boolean
	Dim lotDEYTB As Boolean
	Private okDel As Button
	Private lotLEPTAtel As Label
	Private latLEPTAtel As Label
	Private lottel As Label
	Private lattel As Label
	Private LabelEGSA As ImageView
	Private LabelDD As ImageView
	Private LabelDMS As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("gpssApp")

	
	GPS1.Initialize("GPS")

	
	
End Sub

Sub Activity_Resume

	
'	AllagiLepta.Visible = False
'	okMoiresLepta.Visible = False
	MoiresDek.Visible = True
	lat.Color = Colors.blue
	lot.Color = Colors.blue
	latMono.Color = Colors.blue
	lotMono.Color = Colors.blue
	lotDEYT.Color = Colors.blue
	lotLEPTA.Color = Colors.blue
	latDEYT.Color = Colors.blue
	latLEPTA.Color = Colors.blue
	DekLot.Color = Colors.blue
	DekLat.Color = Colors.blue
	egsaLon.Color = Colors.blue
	egsaLAt.Color = Colors.blue
	lotLEPTAtel.BringToFront
	latLEPTAtel.BringToFront
	lottel.BringToFront
	lattel.BringToFront

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub simanseislabel_Click


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


Sub mnagain_Click
	
	Activity.Finish
	StartActivity(Me)
	
End Sub




Sub mnasend_Click

	Dim share As Intent
	
	share.Initialize(share.ACTION_SEND,"")
	share.SetType("text/plain")
	share.PutExtra("android.intent.extra.TEXT", File.ReadString(File.DirInternal, "gpsfire.txt"))
	share.WrapAsIntentChooser("Share text via")
	StartActivity(share)

End Sub

Sub a_click

End Sub
Sub b_click
	
End Sub
Sub g_click

End Sub
Sub d_click
	
End Sub
Sub e_click
	
End Sub

Sub GPS_LocationChanged (Location1 As Location)
	
	'ΑΠΟ ΔΕΚΑΔΙΚΑ ΣΕ ΜΟΙΡΕΣ ΘΕΛΕΙ Location1.ConvertToseconds(Location1.Latitude) ΚΑΙ Location1.ConvertToseconds(Location1.Longitude)
	

	Dim egsaN As Location
	Dim egsaE As Location
	egsaE.Initialize
	egsaN.Initialize
	
	Dim convertMOires As Location
'	Dim moiresLat As Location
'	Dim moiresLOn As Location
	
	
	Log("latitude")
	Log(Location1.Latitude) '41.13848163
	Log("longitude")
	Log(Location1.Longitude) '24.89279149
	
	
	'latitude (N) longitude (E) 
	
	Log("convert latitude to seconds")
	Log(Location1.ConvertToseconds(Location1.Latitude)) ' 41:8:18,53387 = (N)
	Log("convert longitude to seconds")
	Log(Location1.ConvertToseconds(Location1.Longitude)) '24:53:34,04936 = (E)
	Log("-------------------------------")
	Log("convert latitude to minutes")
	Log(Location1.ConvertTominutes(Location1.Latitude)) '41:8,3089
	Log("convert longitude to minutes")
	Log(Location1.ConvertTominutes(Location1.Longitude)) '24:53,56749
	
	res = Egsa87.FLWGS84_TO_XYEGSA87(Location1.Latitude,Location1.Longitude) '574779.9187386103, 4554228.682533219

	egsaLon.text ="X: " & Round2(res.Get(0),3) 'X: 574779.919
	egsaLAt.text ="Y: " & Round2(res.Get(1),3) 'Y: 4554228.683
	
	
	Log("-------------------------------")
	Log("res   και εγσα")
	Log(res)
	Log(egsaLon.text)
	Log(egsaLAt.text)
	Log("-------------------------------")
	
	
	Log("Μετατροπη απο ΕΓΣΑ σε seconds")
	Log(egsaN.ConvertToseconds(Location1.Latitude))
	Log(egsaE.ConvertToseconds(Location1.Longitude))
	Log("-------------------------------")
	
	
	Log("Μετατροπη απο ΕΓΣΑ σε minutes")
	Log(egsaN.ConvertTominutes(Location1.Latitude))
	Log(egsaE.ConvertTominutes(Location1.Longitude))
	Log("-------------------------------")
	
	
	
	
	Log("-------------------------------")
	Log("-------------------------------")
'				latitude
'				41.13834801
'				longitude
'				24.89248764
'				convert latitude To seconds
'				41:8:18,05284
'				convert longitude To seconds
'				24:53:32,9555
'				-------------------------------
'				convert latitude To minutes
'				41:8,30088
'				convert longitude To minutes
'				24:53,54926
'				-------------------------------
'				res   και εγσα
'				(ArrayList) [574754.5694545831, 4554213.58735019]
'				X: 574754.569
'				Y: 4554213.587
'				-------------------------------
'				Μετατροπη απο ΕΓΣΑ σε seconds
'				41:8:18,05284
'				24:53:32,9555 
'				-------------------------------
'				Μετατροπη απο ΕΓΣΑ σε minutes
'				41:8,30088
'				24:53,54926
'				-------------------------------
'				-------------------------------
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

End Sub







'Sub AllagiDeytera_Click
'	AllagiLepta.Visible = True
'	AllagiDeytera.Visible = False
'	okMoiresLepta.Visible = True
'	lotDEYT.Visible = False
''	latDEYT.Visible = False
'	
'	lat.Top = 3.75%y
'	lat.left = 6.75%x
'	lat.height = 7%y
''	lat.Width  = 35.25%x
'	
'	latLEPTA.Top = 3.75%y
'	latLEPTA.left = 43%x
'	latLEPTA.height = 7%y
'	latLEPTA.Width  = 35.25%x
'
'	latDEYT.Top = 3.75%y
'	latDEYT.left = 100%x
''	latDEYT.height = 7%y
'	latDEYT.width  = 25%x
'
'	lot.Top = 12.75%y
'	lot.left = 6.75%x
'	lot.height = 7%y
'	lot.width  = 35.25%x
'
'	lotLEPTA.Top = 12.75%y
''	lotLEPTA.left = 43%x
'	lotLEPTA.height = 7%y
'	lotLEPTA.Width  = 35.25%x
'
'	lotDEYT.Top = 12.75%y
'	lotDEYT.left = 100%x
'	lotDEYT.height = 7%y
'	lotDEYT.width  = 25%x
'End Sub
'Sub AllagiLepta_Click
'	AllagiDeytera.Visible = True
'	AllagiLepta.Visible = False
'	okMoiresLepta.Visible = False
'	lotDEYT.Visible = True
'	latDEYT.Visible = True
'	
''	lat.Top = 3.75%y
'	lat.left = 2%x
'	lat.height = 7%y
'	lat.Width  = 25%x
'	
'	latLEPTA.Top = 3.75%y
'	latLEPTA.left = 29%x
'	latLEPTA.height = 7%y
''	latLEPTA.Width  = 25%x
'
'	latDEYT.Top = 3.75%y
'	latDEYT.left = 56%x
'	latDEYT.height = 7%y
'	latDEYT.width  = 25%x
''
'	lot.Top = 12.75%y
'	lot.left = 2%x
'	lot.height = 7%y
'	lot.width  = 25%x
'
'	lotLEPTA.Top = 12.75%y
'	lotLEPTA.left = 29%x
''	lotLEPTA.height = 7%y
'	lotLEPTA.Width  = 25%x
'
'	lotDEYT.Top = 12.75%y
'	lotDEYT.left = 56%x
'	lotDEYT.height = 7%y
'	lotDEYT.width  = 25%x
'End Sub
Sub okMoires_Click
	'spiti 		 lat  = 24:53:33.834 lon 41:8:18.87
	'σπιτι		 lat = 24.892252     lon = 41.138468 
	'σπιτι εγσα  Υ = 4554234.671 Χ = 574767.981
	'Dim latB As Boolean
	'Dim lotB As Boolean
	'Dim lotLEPTAB As Boolean
	'Dim latLEPTAB As Boolean
	'Dim lotDEYTB As Boolean
	'Dim lotDEYTB As Boolean
	latDEYT.text = latDEYT.text.Replace ("-","")
	lotDEYT.text = lotDEYT.text.Replace ("-","")
	Dim dklatMin As Double
	Dim dklotMin As Double
	Dim dklatSec As Double
	Dim dklotSec As Double
	If latB = True Then
		If lotB = True Then
			If lotLEPTAB = True Then
				If latLEPTAB = True Then
					If lotDEYTB = True Then
						If lotDEYTB = True Then
							
	
	

							dklatMin = latLEPTA.text/ "60"
							dklotMin = lotLEPTA.text/ "60"
							dklatSec = (latDEYT.text / "60") * ("1" /"60")
							dklotSec = (lotDEYT.text / "60") * ("1" /"60")
							DekLat.text = Round2(lat.text + dklatMin + dklatSec , 5)
							DekLot.text = Round2(lot.text + dklotMin  + dklotSec , 5)
	
	
	
	
							res = Egsa87.FLWGS84_TO_XYEGSA87(DekLot.text,DekLat.text)

							egsaLon.text =Round2(res.Get(0),3)
							egsaLAt.text =Round2(res.Get(1),3)
	

							okMoires.Visible = False
							okDekadika.Visible = False
							okEgsa.Visible = False
							DekLot.Enabled = False
							DekLat.Enabled = False
							egsaLAt.Enabled = False
							egsaLon.Enabled = False
							lat.Enabled = False
							lot.Enabled = False
							latMono.Enabled = False
							lotMono.Enabled = False
							latLEPTA.Enabled = False
							latDEYT.Enabled = False
							lotLEPTA.Enabled = False
							lotDEYT.Enabled = False
							latMono.Enabled = False
							lotMono.Enabled = False
						'	lottel.visible = False
						'	lattel.visible = False
						'	lotLEPTAtel.visible = False
						'	latLEPTAtel.visible = False
						End If
					End If
				End If
			End If
		End If
		Else
		ToastMessageShow("Συμπληρώστε ολα τα πεδία", True)
	End If
	
End Sub

Sub okDekadika_Click
	DekLot.text = DekLot.text.Replace ("-","")
	DekLat.text = DekLat.text.Replace ("-","")
	Dim location1 As Location
	Dim location2 As Location

	If deklotB = True Then
		If deklatB = True Then
	latMono.Text = location1.ConvertToseconds(DekLat.text)
			lotMono.Text = location2.ConvertToseconds(DekLot.text)
			latMono.Visible = True
			lotMono.Visible = True
			lotMono.BringToFront
			lotMono.BringToFront
			latMono.Text = location1.ConvertToseconds(DekLat.text)
			lotMono.Text = location2.ConvertToseconds(DekLot.text)
	res = Egsa87.FLWGS84_TO_XYEGSA87(DekLot.text,DekLat.text)

	egsaLon.text =Round2(res.Get(0),3)
	egsaLAt.text =Round2(res.Get(1),3)
	okEgsa.Visible = False
	okMoires.Visible = False
	okDekadika.Visible = False
	lat.Visible = False
	latLEPTA.Visible = False
	latDEYT.Visible = False
	lot.Visible = False
	lotLEPTA.Visible = False
			lotDEYT.Visible = False
			DekLot.Enabled = False
			DekLat.Enabled = False
			egsaLAt.Enabled = False
			egsaLon.Enabled = False
			lat.Enabled = False
			lot.Enabled = False
			latLEPTA.Enabled = False
			latDEYT.Enabled = False
			lotLEPTA.Enabled = False
			lotDEYT.Enabled = False
			latMono.Enabled = False
			lotMono.Enabled = False
			lottel.visible = False
			lattel.visible = False
			lotLEPTAtel.visible = False
			latLEPTAtel.visible = False
		End If
	Else
		ToastMessageShow("Συμπληρώστε ολα τα πεδία", True)
	End If
End Sub

Sub okEgsa_Click
	egsaLon.text = egsaLon.text.Replace ("-","")
	egsaLAt.text = egsaLAt.text.Replace ("-","")
	Dim location1 As Location
	Dim location2 As Location
	'spiti lat  = 24:53:33.834 lon 41:8:18.87
	'σπιτι lat = 41.138468 lon = 24.892252
'σπιτι εγσα Υ = 4554234.671 Χ = 574767.981

	If egsaLatB = True Then
		If egsaLonB = True Then
			res = Egsa87.XYEGSA_TO_FLWGS84(egsaLon.text,egsaLAt.text)
			DekLot.text =Round2(res.Get(0),5)
			DekLat.text =Round2(res.Get(1),5)

			okMoires.Visible = False
			okDekadika.Visible = False
			lat.Visible = False
			latLEPTA.Visible = False
			latDEYT.Visible = False
			lot.Visible = False
			lotLEPTA.Visible = False
			lotDEYT.Visible = False
			okEgsa.Visible = False
			latMono.Visible = True
			lotMono.Visible = True
			lotMono.BringToFront
			lotMono.BringToFront
			latMono.Text = location1.ConvertToseconds(DekLat.text)
			lotMono.Text = location2.ConvertToseconds(DekLot.text)
			DekLot.Enabled = False
			DekLat.Enabled = False
			egsaLAt.Enabled = False
			egsaLon.Enabled = False
			lat.Enabled = False
			lot.Enabled = False
			latLEPTA.Enabled = False
			latDEYT.Enabled = False
			lotLEPTA.Enabled = False
			lotDEYT.Enabled = False
			latMono.Enabled = False
			lotMono.Enabled = False
			lottel.visible = False
			lattel.visible = False
			lotLEPTAtel.visible = False
			latLEPTAtel.visible = False
		End If
	Else
		ToastMessageShow("Συμπληρώστε ολα τα πεδία", True)
	End If
	
End Sub



Sub DekLat_TextChanged (Old As String, New As String)
	If DekLat.Text.Length > 0 Then
		deklatB = True
	Else
		deklatB = False
	End If
End Sub

Sub DekLot_TextChanged (Old As String, New As String)
	If DekLot.Text.Length > 0 Then
		deklotB = True
	Else
		deklotB	= False
	End If
End Sub


Sub egsaLat_TextChanged (Old As String, New As String)
	If egsaLAt.Text.Length > 0 Then
		egsaLatB = True
	Else
		egsaLatB = False
	End If
End Sub

Sub egsaLon_TextChanged (Old As String, New As String)
	If egsaLon.Text.Length > 0 Then
		egsaLonB = True
	Else
		egsaLonB	= False
	End If
End Sub


Sub lat_TextChanged (Old As String, New As String)
	If lat.Text.Length > 0 Then
		latB = True
	Else
		latB = False
	End If
End Sub
Sub lot_TextChanged (Old As String, New As String)
	If lot.Text.Length > 0 Then
		lotB = True
	Else
		lotB= False
	End If
End Sub
Sub lotLEPTA_TextChanged (Old As String, New As String)
	If lotLEPTA.Text.Length > 0 Then
		lotLEPTAB = True
	Else
		lotLEPTAB= False

	End If
End Sub
Sub latLEPTA_TextChanged (Old As String, New As String)
	If latLEPTA.Text.Length > 0 Then
		latLEPTAB = True
	Else
		latLEPTAB = False
	End If
End Sub
Sub latDEYT_TextChanged (Old As String, New As String)
	If latDEYT.Text.Length > 0 Then
		latDEYTB = True
	Else
		latDEYTB = False
	End If
End Sub
Sub lotDEYT_TextChanged (Old As String, New As String)
	If lotDEYT.Text.Length > 0 Then
		lotDEYTB = True
	Else
		lotDEYTB = False
	End If
End Sub

Sub okDel_Click

	StartActivity(restartGpsApp)
	Activity.Finish
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
      
		Activity.Finish
	End If
End Sub