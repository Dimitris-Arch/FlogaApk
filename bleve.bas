Type=Activity
Version=3.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	Dim sc As ScrollView
Dim Panel As Panel
Dim Panel1 As Panel
Dim pin1 As ImageView
Dim pin2 As ImageView
Dim pin3 As ImageView
Dim pin4 As ImageView
Dim pin5 As ImageView
Dim pin6 As ImageView



Dim textpin1 As Label
Dim textpin2 As Label
Dim textpin3 As Label
Dim textpin4 As Label
Dim textpin5 As Label
Dim textpin6 As Label



Private ImageView0 As ImageView
	Private ImageView1 As ImageView
	Private ImageView2 As ImageView
	Private ImageView3 As ImageView
	Private ImageView4 As ImageView
	Private ImageView5 As ImageView
	Private ImageView6 As ImageView

	
	Private back1 As ImageView
Dim ili As Button
Dim ousia As Button
Dim simansi As Button


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
	Activity.LoadLayout("bleve.bal")
     sc.initialize(1000dip)
 Activity.AddView(sc,3%x,33%y,94%x,57.5%y)
 
 sc.Panel.Width = 100%x
 sc.Panel.Height = 127%y

   Panel1.RemoveView
  sc.Panel.AddView( Panel1,0%x,-9%y,100%x,118%y)
	
	
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

	ImageView0.Top = 9%y
	ImageView0.Left = 0%x
	ImageView0.Width = 100%x
	ImageView0.Height = 1%y
	
	pin1.Top = 10%y
	pin1.Left = 0%x
	pin1.Width = 20%x
	pin1.Height = 14%y
	
	textpin1.Top = 10%y
	textpin1.Left = 25%x
	textpin1.Width = 75%x
	textpin1.Height = 14%y
	
	
	ImageView1.Top = 26%y
	ImageView1.Left = 0%x
	ImageView1.Width = 100%x
	ImageView1.Height = 1%y
	
	back1.Top = 9%y
	back1.Left = 0%x
	back1.Width = 100%x
	back1.Height = 404%y
	
	
	pin2.Top = 30%y
	pin2.Left = 0%x
	pin2.Width = 20%x
	pin2.Height = 14%y
	ImageView2.Top = 46%y
	ImageView2.Left = 0%x
	ImageView2.Width = 100%x
	ImageView2.Height = 1%y
	
	textpin2.Top = 30%y
	textpin2.Left = 25%x
	textpin2.Width = 75%x
	textpin2.Height = 14%y
	
	
	
	pin3.Top = 50%y
	pin3.Left = 0%x
	pin3.Width = 20%x
	pin3.Height = 14%y
	ImageView3.Top = 66%y
	ImageView3.Left = 0%x
	ImageView3.Width = 100%x
	ImageView3.Height = 1%y
	
	textpin3.Top = 50%y
	textpin3.Left = 25%x
	textpin3.Width = 75%x
	textpin3.Height = 14%y
	
	
	
	pin4.Top = 70%y
	pin4.Left = 0%x
	pin4.Width = 20%x
	pin4.Height = 14%y
	ImageView4.Top = 86%y
	ImageView4.Left = 0%x
	ImageView4.Width = 100%x
	ImageView4.Height = 1%y
	
	textpin4.Top = 70%y
	textpin4.Left = 25%x
	textpin4.Width = 75%x
	textpin4.Height = 14%y
	
	
	
	pin5.Top = 90%y
	pin5.Left = 0%x
	pin5.Width = 20%x
	pin5.Height = 14%y
	ImageView5.Top = 106%y
	ImageView5.Left = 0%x
	ImageView5.Width = 100%x
	ImageView5.Height = 1%y
	
	textpin5.Top = 90%y
	textpin5.Left = 25%x
	textpin5.Width = 75%x
	textpin5.Height = 14%y
	
	
	
	
		'back2.Top = 86%y
	'back2.Left = 0%x
	'back2.Width = 100%x
	'back2.Height = 100%y
	
	
	pin6.Top = 110%y
	pin6.Left = 0%x
	pin6.Width = 20%x
	pin6.Height = 14%y
	ImageView6.Top = 126%y
	ImageView6.Left = 0%x
	ImageView6.Width = 100%x
	ImageView6.Height = 1%y
	
	textpin6.Top = 110%y
	textpin6.Left = 25%x
	textpin6.Width = 75%x
	textpin6.Height = 14%y
	
	
	

	
	
   
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Sub pin9_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1072.png"))
If result = DialogResponse.Positive Then
	StartActivity("oxygono")
	End If
End Sub
Sub pin8_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1789.png"))
If result = DialogResponse.Positive Then
	StartActivity("ydroxlorikooxi")
	End If
End Sub
Sub pin7_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1050.png"))
If result = DialogResponse.Positive Then
	StartActivity("ydroxlorio")
	End If
End Sub
Sub pin6_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1824.png"))
If result = DialogResponse.Positive Then
	StartActivity("ydroxidiodialima")
	End If
End Sub
Sub pin5_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1823.png"))
If result = DialogResponse.Positive Then
	StartActivity("ydroxidio")
	End If
End Sub
Sub pin4_Click
Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1972.png"))
If result = DialogResponse.Positive Then
	StartActivity("methanio")
	End If
End Sub
Sub pin3_Click
Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1971.png"))
If result = DialogResponse.Positive Then
	StartActivity("fisiko")
	End If
End Sub
Sub pin2_Click
Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1005.png"))
If result = DialogResponse.Positive Then
	StartActivity("amonia")
	End If
End Sub
Sub pin1_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1001.png"))
If result = DialogResponse.Positive Then
StartActivity("asetilini")
End If
End Sub

Sub pin20_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1978.png"))
If result = DialogResponse.Positive Then
	StartActivity("propanio")
	End If
End Sub
Sub pin19_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1965.png"))
If result = DialogResponse.Positive Then
	StartActivity("meigmaaeriwn")
	End If
End Sub
Sub pin18_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1075.png"))
If result = DialogResponse.Positive Then
	StartActivity("aeriapetrelaiou")
	End If
End Sub
Sub pin17_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1011.png"))
If result = DialogResponse.Positive Then
	StartActivity("ygraerio")
	End If
End Sub
Sub pin16_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "    ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1049.png"))
If result = DialogResponse.Positive Then
	StartActivity("ydrogono")
	End If
End Sub
Sub pin15_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1017.png"))
If result = DialogResponse.Positive Then
	StartActivity("xlorio")
	End If
End Sub
Sub pin14_Click
			Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1203.png"))
If result = DialogResponse.Positive Then
	StartActivity("venzini")
	End If
End Sub
Sub pin13_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1202.png"))
If result = DialogResponse.Positive Then
	StartActivity("petrelaio")
	End If
End Sub
Sub pin12_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1831.png"))
If result = DialogResponse.Positive Then
	StartActivity("thiikoatmizon")
	End If
End Sub
Sub pin11_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1830.png"))
If result = DialogResponse.Positive Then
	StartActivity("thiiko")
	End If
End Sub
Sub pin10_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1073.png"))
If result = DialogResponse.Positive Then
	StartActivity("ygrooxygono")
	End If
End Sub
''''''''''''''''''''''''''''''''''''''''
Sub textpin9_Click
	StartActivity("oxygono")
End Sub
Sub textpin8_Click
	StartActivity("ydroxlorikooxi")
End Sub
Sub textpin7_Click
	StartActivity("ydroxlorio")
End Sub
Sub textpin6_Click
	StartActivity("ydroxidiodialima")
End Sub
Sub textpin5_Click
	StartActivity("ydroxidio")
End Sub
Sub textpin4_Click
	StartActivity("methanio")
End Sub
Sub textpin3_Click
	StartActivity("fisiko")
End Sub

Sub textpin20_Click
	StartActivity("propanio")
End Sub
Sub textpin2_Click
	StartActivity("amonia")
End Sub
Sub textpin19_Click
	StartActivity("meigmaaeriwn")
End Sub
Sub textpin18_Click
	StartActivity("aeriapetrelaiou")
End Sub
Sub textpin17_Click
	StartActivity("ygraerio")
End Sub
Sub textpin16_Click
	StartActivity("ydrogono")
End Sub
Sub textpin15_Click
	StartActivity("xlorio")
End Sub
Sub textpin14_Click
	StartActivity("venzini")
End Sub
Sub textpin13_Click
	StartActivity("petrelaio")
End Sub
Sub textpin12_Click
	StartActivity("thiikoatmizon")
End Sub
Sub textpin11_Click
	StartActivity("thiiko")
End Sub
Sub textpin10_Click
	StartActivity("ygrooxygono")
End Sub
Sub textpin1_Click
	StartActivity("asetilini")
End Sub

Sub ili_Click
	StartActivity("ilika")
End Sub
Sub ousia_Click
	StartActivity("simanseis")
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


Sub listabel_Click
	StartActivity("listaousies")
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
End Sub
Sub ousialabel_Click
	StartActivity("simanseis")
End Sub
Sub ililabel_Click
	StartActivity("ilika")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
End Sub
Sub simansi_Click
	StartActivity("Main")
End Sub