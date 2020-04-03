B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.3
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
Dim pin7 As ImageView
Dim pin8 As ImageView
Dim pin9 As ImageView
Dim pin10 As ImageView
Dim pin11 As ImageView
Dim pin12 As ImageView
Dim pin13 As ImageView
Dim pin14 As ImageView
Dim pin15 As ImageView
Dim pin16 As ImageView
Dim pin17 As ImageView
Dim pin18 As ImageView
Dim pin19 As ImageView
Dim pin20 As ImageView
Dim pin21 As ImageView

'Dim AdView1 As AdView
Dim textpin1 As Label
Dim textpin2 As Label
Dim textpin3 As Label
Dim textpin4 As Label
Dim textpin5 As Label
Dim textpin6 As Label
Dim textpin7 As Label
Dim textpin8 As Label
Dim textpin9 As Label
Dim textpin10 As Label
Dim textpin11 As Label
Dim textpin12 As Label
Dim textpin13 As Label
Dim textpin14 As Label
Dim textpin15 As Label
Dim textpin16 As Label
Dim textpin17 As Label
Dim textpin18 As Label
Dim textpin19 As Label
Dim textpin20 As Label
Dim textpin21 As Label

Private ImageView0 As ImageView
	Private ImageView1 As ImageView
	Private ImageView2 As ImageView
	Private ImageView3 As ImageView
	Private ImageView4 As ImageView
	Private ImageView5 As ImageView
	Private ImageView6 As ImageView
	Private ImageView7 As ImageView
	Private ImageView8 As ImageView
	Private ImageView9 As ImageView
	Private ImageView10 As ImageView
Private ImageView11 As ImageView
Private ImageView12 As ImageView
Private ImageView13 As ImageView
Private ImageView14 As ImageView
Private ImageView15 As ImageView
Private ImageView16 As ImageView
Private ImageView17 As ImageView
Private ImageView18 As ImageView
Private ImageView19 As ImageView
Private ImageView20 As ImageView
	Private ImageView21 As ImageView
	
	Private back1 As ImageView
	Private back2 As ImageView
	Private back3 As ImageView
	Private back4 As ImageView
	Private back5 As ImageView
	Private back6 As ImageView

Private back7 As ImageView

	
	Private mple As ImageView
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("ilikaa.bal")
     sc.initialize(1000dip)
 Activity.AddView(sc,3%x,33%y,94%x,57.5%y)
 
 sc.Panel.Width = 96%x
 sc.Panel.Height = 425%y

	
   Panel1.RemoveView
  sc.Panel.AddView( Panel1,0%x,-9%y,99%x,434%y)
	
	textpin1.Typeface = Typeface.DEFAULT_BOLD
 textpin2.Typeface = Typeface.DEFAULT_BOLD
 textpin3.Typeface = Typeface.DEFAULT_BOLD
 textpin4.Typeface = Typeface.DEFAULT_BOLD
 textpin5.Typeface = Typeface.DEFAULT_BOLD
 textpin6.Typeface = Typeface.DEFAULT_BOLD
 textpin7.Typeface = Typeface.DEFAULT_BOLD
 textpin8.Typeface = Typeface.DEFAULT_BOLD
 textpin9.Typeface = Typeface.DEFAULT_BOLD
 textpin10.Typeface = Typeface.DEFAULT_BOLD
 textpin11.Typeface = Typeface.DEFAULT_BOLD
 textpin12.Typeface = Typeface.DEFAULT_BOLD
 textpin13.Typeface = Typeface.DEFAULT_BOLD
 textpin14.Typeface = Typeface.DEFAULT_BOLD
 textpin15.Typeface = Typeface.DEFAULT_BOLD
 textpin16.Typeface = Typeface.DEFAULT_BOLD
 textpin17.Typeface = Typeface.DEFAULT_BOLD
 textpin18.Typeface = Typeface.DEFAULT_BOLD
 textpin19.Typeface = Typeface.DEFAULT_BOLD
 textpin20.Typeface = Typeface.DEFAULT_BOLD
 textpin21.Typeface = Typeface.DEFAULT_BOLD
	
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
	
	back1.Top = 9.5%y
	back1.Left = 0%x
	back1.Width = 100%x
	back1.Height = 77%y
	
	
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
	
	
	
	
		back2.Top = 77.5%y
	back2.Left = 0%x
	back2.Width = 100%x
	back2.Height = 69%y
	
	
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
	
	
	
	pin7.Top = 130%y
	pin7.Left = 0%x
	pin7.Width = 20%x
	pin7.Height = 14%y
	ImageView7.Top = 146%y
	ImageView7.Left = 0%x
	ImageView7.Width = 100%x
	ImageView7.Height = 1%y
	
		
	textpin7.Top = 130%y
	textpin7.Left = 25%x
	textpin7.Width = 75%x
	textpin7.Height = 14%y
	
	
	pin8.Top = 150%y
	pin8.Left = 0%x
	pin8.Width = 20%x
	pin8.Height = 14%y
	ImageView8.Top = 166%y
	ImageView8.Left = 0%x
	ImageView8.Width = 100%x
	ImageView8.Height = 1%y
	back3.Top = 146.5%y
	back3.Left = 0%x
	back3.Width = 100%x
	back3.Height = 20%y
	
		
	textpin8.Top = 150%y
	textpin8.Left = 25%x
	textpin8.Width = 75%x
	textpin8.Height = 14%y
	
	
	
	pin9.Top = 170%y
	pin9.Left = 0%x
	pin9.Width = 20%x
	pin9.Height = 14%y
	ImageView9.Top = 186%y
	ImageView9.Left = 0%x
	ImageView9.Width = 100%x
	ImageView9.Height = 1%y
	
		
	textpin9.Top = 170%y
	textpin9.Left = 25%x
	textpin9.Width = 75%x
	textpin9.Height = 14%y
	
	
	
	
	
	pin10.Top = 190%y
	pin10.Left = 0%x
	pin10.Width = 20%x
	pin10.Height = 14%y
	ImageView10.Top = 206%y
	ImageView10.Left = 0%x
	ImageView10.Width = 100%x
	ImageView10.Height = 1%y
	
	textpin10.Top = 190%y
	textpin10.Left = 25%x
	textpin10.Width = 75%x
	textpin10.Height = 14%y
	
	
	
	pin11.Top = 210%y
	pin11.Left = 0%x
	pin11.Width = 20%x
	pin11.Height = 14%y
	ImageView11.Top = 226%y
	ImageView11.Left = 0%x
	ImageView11.Width = 100%x
	ImageView11.Height = 1%y
	
	textpin11.Top = 210%y
	textpin11.Left = 25%x
	textpin11.Width = 75%x
	textpin11.Height = 14%y
	
	
	back4.Top = 166.5%y
	back4.Left = 0%x
	back4.Width = 100%x
	back4.Height = 79.5%y
	
	
	pin12.Top = 230%y
	pin12.Left = 0%x
	pin12.Width = 20%x
	pin12.Height = 14%y
	ImageView12.Top = 246%y
	ImageView12.Left = 0%x
	ImageView12.Width = 100%x
	ImageView12.Height = 1%y
	
	textpin12.Top = 230%y
	textpin12.Left = 25%x
	textpin12.Width = 75%x
	textpin12.Height = 14%y
	
	
	back5.Top = 226.5%y
	back5.Left = 0%x
	back5.Width = 100%x
	back5.Height = 39.5%y
	
	
	pin13.Top = 250%y
	pin13.Left = 0%x
	pin13.Width = 20%x
	pin13.Height = 14%y
	ImageView13.Top = 266%y
	ImageView13.Left = 0%x
	ImageView13.Width = 100%x
	ImageView13.Height = 1%y
	
	textpin13.Top = 250%y
	textpin13.Left = 25%x
	textpin13.Width = 75%x
	textpin13.Height = 14%y
	
	
	
	
	
	pin14.Top = 270%y
	pin14.Left = 0%x
	pin14.Width = 20%x
	pin14.Height = 14%y
	ImageView14.Top = 286%y
	ImageView14.Left = 0%x
	ImageView14.Width = 100%x
	ImageView14.Height = 1%y
	
	textpin14.Top = 270%y
	textpin14.Left = 25%x
	textpin14.Width = 75%x
	textpin14.Height = 14%y
	
	pin15.Top = 290%y
	pin15.Left = 0%x
	pin15.Width = 20%x
	pin15.Height = 14%y
	ImageView15.Top = 306%y
	ImageView15.Left = 0%x
	ImageView15.Width = 100%x
	ImageView15.Height = 1%y
	
	textpin15.Top = 290%y
	textpin15.Left = 25%x
	textpin15.Width = 75%x
	textpin15.Height = 14%y
	
	pin16.Top = 310%y
	pin16.Left = 0%x
	pin16.Width = 20%x
	pin16.Height = 14%y
	ImageView16.Top = 326%y
	ImageView16.Left = 0%x
	ImageView16.Width = 100%x
	ImageView16.Height = 1%y
	
	back6.Top = 266.5%y
	back6.Left = 0%x
	back6.Height = 40%y
	back6.Width = 100%x
	
	textpin16.Top = 310%y
	textpin16.Left = 25%x
	textpin16.Width = 75%x
	textpin16.Height = 14%y

	
	pin17.Top = 330%y
	pin17.Left = 0%x
	pin17.Width = 20%x
	pin17.Height = 14%y
	ImageView17.Top = 346%y
	ImageView17.Left = 0%x
	ImageView17.Width = 100%x
	ImageView17.Height = 1%y
	
	textpin17.Top = 330%y
	textpin17.Left = 25%x
	textpin17.Width = 75%x
	textpin17.Height = 14%y
	
	
	pin18.Top = 350%y
	pin18.Left = 0%x
	pin18.Width = 20%x
	pin18.Height = 14%y
	ImageView18.Top = 366%y
	ImageView18.Left = 0%x
	ImageView18.Width = 100%x
	ImageView18.Height = 1%y
	
	textpin18.Top = 350%y
	textpin18.Left = 25%x
	textpin18.Width = 75%x
	textpin18.Height = 14%y
	
	pin19.Top = 370%y
	pin19.Left = 0%x
	pin19.Width = 20%x
	pin19.Height = 14%y
	ImageView19.Top = 386%y
	ImageView19.Left = 0%x
	ImageView19.Width = 100%x
	ImageView19.Height = 1%y
	
	textpin19.Top = 370%y
	textpin19.Left = 25%x
	textpin19.Width = 75%x
	textpin19.Height = 14%y
	
	
	
	pin20.Top = 390%y
	pin20.Left = 0%x
	pin20.Width = 20%x
	pin20.Height = 14%y
	ImageView20.Top = 406%y
	ImageView20.Left = 0%x
	ImageView20.Width = 100%x
	ImageView20.Height = 1%y
	
	textpin20.Top = 390%y
	textpin20.Left = 25%x
	textpin20.Width = 75%x
	textpin20.Height = 14%y
	
	pin21.Top = 409%y
	pin21.Left = 0%x
	pin21.Width = 20%x
	pin21.Height = 14%y
	ImageView21.Top = 424%y
	ImageView21.Left = 0%x
	ImageView21.Width = 100%x
	ImageView21.Height = 1%y
	
	back7.Top = 406%y
	back7.Left = 0%x
	back7.Height = 18%y
	back7.Width = 101%x
	
	
	textpin21.Top = 411%y
	textpin21.Left = 25%x
	textpin21.Width = 75%x
	textpin21.Height = 14%y
   
   
   
   
   
   
   
   
   '''''''''''''
   simanseislabel.Top = 3%y
simanseislabel.left = 3.5%x
simanseislabel.height = 27.5%y
simanseislabel.Width  = 45%x
   



''PANW DEXIA MESH


listabel.Top = 3%y
listabel.left = 51.75%x
listabel.height = 13%y
listabel.Width  = 21.25%x





katigorlabel.Top = 18%y
katigorlabel.left = 51.75%x
katigorlabel.height = 13%y
katigorlabel.Width  = 21.25%x
'PANW DEXIA AKRH

ousialabel.Top = 3%y
ousialabel.left = 76%x
ousialabel.height = 13%y
ousialabel.Width  = 21.25%x


ililabel.Top = 18%y
ililabel.left = 76%x
ililabel.height = 13%y
ililabel.Width  = 21.25%x
   

mple.top = 93%y
mple.left = 3%x
mple.width = 94%x
mple.height = 7%y
 simanseislabel.BringToFront
	 listabel.BringToFront
	 katigorlabel.BringToFront
	 ousialabel.BringToFront
	 ililabel.BringToFront
	

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Sub pin9_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "4.1.png"))
If result = DialogResponse.Positive Then
	StartActivity("tesera")
	End If
End Sub
Sub pin8_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "3.png"))
If result = DialogResponse.Positive Then
	StartActivity("tria")
	End If
End Sub
Sub pin7_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "2.3.png"))
If result = DialogResponse.Positive Then
	StartActivity("dyo3")
	End If
End Sub
Sub pin6_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "   ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "2.2.png"))
If result = DialogResponse.Positive Then
	StartActivity("dyo2")
	End If
End Sub
Sub pin5_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "2.1.png"))
If result = DialogResponse.Positive Then
	StartActivity("dyo")
	End If
End Sub
Sub pin4_Click
Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1.6.png"))
If result = DialogResponse.Positive Then
	StartActivity("ena6")
	End If
End Sub
Sub pin3_Click
Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1.5.png"))
If result = DialogResponse.Positive Then
	StartActivity("enapente")
	End If
End Sub
Sub pin2_Click
Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1.4.png"))
If result = DialogResponse.Positive Then
	StartActivity("enatessera")
	End If
End Sub
Sub pin1_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "1.png"))
If result = DialogResponse.Positive Then
StartActivity("ena")
End If
End Sub
Sub pin21_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "9.png"))
If result = DialogResponse.Positive Then
	StartActivity("ennia")
	End If
End Sub
Sub pin20_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "8.png"))
If result = DialogResponse.Positive Then
	StartActivity("okto")
	End If
End Sub
Sub pin19_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "7d.png"))
If result = DialogResponse.Positive Then
	StartActivity("epta4")
	End If
End Sub
Sub pin18_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "7c.png"))
If result = DialogResponse.Positive Then
	StartActivity("epta3")
	End If
End Sub
Sub pin17_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "7b.png"))
If result = DialogResponse.Positive Then
	StartActivity("epta2")
	End If
End Sub
Sub pin16_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "7a.png"))
If result = DialogResponse.Positive Then
	StartActivity("epta")
	End If
End Sub
Sub pin15_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "6.2.png"))
If result = DialogResponse.Positive Then
	StartActivity("exi2")
	End If
End Sub
Sub pin14_Click
			Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "6.1.png"))
If result = DialogResponse.Positive Then
	StartActivity("exi")
	End If
End Sub
Sub pin13_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "5.2.png"))
If result = DialogResponse.Positive Then
	StartActivity("pente2")
	End If
End Sub
Sub pin12_Click
		Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "5.1.png"))
If result = DialogResponse.Positive Then
	StartActivity("pente")
	End If
End Sub
Sub pin11_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "4.3.png"))
If result = DialogResponse.Positive Then
	StartActivity("tessera3")
	End If
End Sub
Sub pin10_Click
	Dim result As Int
result = Msgbox2("Μετάβαση στην κατηγορία;", "  ", "Ναι", "", "Οχι", LoadBitmap (File.DirAssets, "4.2.png"))
If result = DialogResponse.Positive Then
	StartActivity("tessera2")
	End If
End Sub
''''''''''''''''''''''''''''''''''''''''
Sub textpin9_Click
	StartActivity("tesera")
End Sub
Sub textpin8_Click
	StartActivity("tria")
End Sub
Sub textpin7_Click
	StartActivity("dyo3")
End Sub
Sub textpin6_Click
	StartActivity("dyo2")
End Sub
Sub textpin5_Click
	StartActivity("dyo")
End Sub
Sub textpin4_Click
	StartActivity("ena6")
End Sub
Sub textpin3_Click
	StartActivity("enapente")
End Sub
Sub textpin21_Click
	StartActivity("ennia")
End Sub
Sub textpin20_Click
	StartActivity("okto")
End Sub
Sub textpin2_Click
	StartActivity("enatessera")
End Sub
Sub textpin19_Click
	StartActivity("epta4")
End Sub
Sub textpin18_Click
	StartActivity("epta3")
End Sub
Sub textpin17_Click
	StartActivity("epta2")
End Sub
Sub textpin16_Click
	StartActivity("epta")
End Sub
Sub textpin15_Click
	StartActivity("exi2")
End Sub
Sub textpin14_Click
	StartActivity("exi")
End Sub
Sub textpin13_Click
	StartActivity("pente2")
End Sub
Sub textpin12_Click
	StartActivity("pente")
End Sub
Sub textpin11_Click
	StartActivity("tessera3")
End Sub
Sub textpin10_Click
	StartActivity("tessera2")
End Sub
Sub textpin1_Click
	StartActivity("ena")
End Sub
Sub simansi_Click
	StartActivity("Main")
	Activity.Finish
End Sub


Sub ili_Click
	StartActivity("simanseis")
	Activity.Finish
End Sub
Sub ousia_Click
	StartActivity("ousies")
	Activity.Finish
End Sub
Sub pixi_Click
	StartActivity("pixida")
	Activity.Finish
End Sub

Sub lista_Click
	StartActivity("listaousies")
	Activity.Finish
End Sub

Sub katigor_Click
	StartActivity("katigoriess")
	Activity.Finish
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
	Activity.Finish
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
	Activity.Finish
End Sub
Sub listabel_Click
	StartActivity("listaousies")
	Activity.Finish
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
	Activity.Finish
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
	Activity.Finish
End Sub
Sub ililabel_Click
	StartActivity("simanseis")
	Activity.Finish
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub
