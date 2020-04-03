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


Dim textpin1 As Label
Dim textpin2 As Label
Dim textpin3 As Label
Dim textpin4 As Label
Dim textpin5 As Label
Dim textpin6 As Label
Dim textpin7 As Label
Dim textpin8 As Label
Dim textpin9 As Label
Dim pin1 As ImageView
Dim pin2 As ImageView
Dim pin3 As ImageView
Dim pin4 As ImageView
Dim pin5 As ImageView
Dim pin6 As ImageView
Dim pin7 As ImageView
Dim pin8 As ImageView
Dim pin9 As ImageView

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


	
	
	



	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("karpa.bal")
     sc.initialize(1000dip)
 Activity.AddView(sc,3%x,33%y,94%x,57.5%y)

 sc.Panel.Width = 96%x
 sc.Panel.Height = 187%y

   Panel1.RemoveView
  sc.Panel.AddView( Panel1,0%x,-9%y,94%x,210%y)
	
	textpin1.textcolor = Colors.black
textpin2.textcolor = Colors.black
textpin3.textcolor = Colors.black
textpin4.textcolor = Colors.black
textpin5.textcolor = Colors.black
textpin6.textcolor = Colors.black
textpin7.textcolor = Colors.black
textpin8.textcolor = Colors.black
textpin9.textcolor = Colors.black
textpin1.Typeface = Typeface.DEFAULT_BOLD
textpin2.Typeface = Typeface.DEFAULT_BOLD
textpin3.Typeface = Typeface.DEFAULT_BOLD
textpin4.Typeface = Typeface.DEFAULT_BOLD
textpin5.Typeface = Typeface.DEFAULT_BOLD
textpin6.Typeface = Typeface.DEFAULT_BOLD
textpin7.Typeface = Typeface.DEFAULT_BOLD
textpin8.Typeface = Typeface.DEFAULT_BOLD
textpin9.Typeface = Typeface.DEFAULT_BOLD


	
	textpin1.TextSize = 12
textpin2.TextSize = 12
textpin3.TextSize = 12
	
textpin4.TextSize = 12
textpin5.TextSize = 12
	
textpin6.TextSize = 12
textpin7.TextSize = 12
	
textpin8.TextSize = 12 
textpin9.TextSize = 12
	

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
	textpin1.Width = 70%x
	textpin1.Height = 14%y
	
	
	ImageView1.Top = 26%y
	ImageView1.Left = 0%x
	ImageView1.Width = 100%x
	ImageView1.Height = 1%y
	

	
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
	textpin2.Width = 70%x
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
	textpin3.Width = 70%x
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
	textpin4.Width = 70%x
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
	textpin5.Width = 70%x
	textpin5.Height = 14%y
	
	
	
	
	
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
	textpin6.Width = 70%x
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
	textpin7.Width = 70%x
	textpin7.Height = 14%y
	
	
	pin8.Top = 150%y
	pin8.Left = 0%x
	pin8.Width = 20%x
	pin8.Height = 14%y
	ImageView8.Top = 166%y
	ImageView8.Left = 0%x
	ImageView8.Width = 100%x
	ImageView8.Height = 1%y

		
	textpin8.Top = 150%y
	textpin8.Left = 25%x
	textpin8.Width = 70%x
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
	textpin9.Width = 70%x
	textpin9.Height = 14%y
	
	
	
	
	
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
 simanseislabel.BringToFront
	 listabel.BringToFront
	 katigorlabel.BringToFront
	 ousialabel.BringToFront
	 ililabel.BringToFront
	

   
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
Activity.Finish
End Sub


Sub ili_Click
	StartActivity("camera")
End Sub
Sub ousia_Click
	StartActivity("gpssignal")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("thlefona")
End Sub

Sub katigor_Click
	StartActivity("pixida")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
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
	StartActivity("camera")
End Sub
Sub simansi_Click
	StartActivity("Main")
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub
