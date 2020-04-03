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
	Public rp As RuntimePermissions
End Sub

Sub Globals
	Dim sc As ScrollView


Dim Panel1 As Panel

Dim sc As ScrollView

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
Dim textpin10 As Label
Dim textpin11 As Label
Dim textpin12 As Label
Dim textpin13 As Label


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

'Dim adview1 As AdView
	
	
	

End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("thlefona.bal")
     sc.initialize(1000dip)
 Activity.AddView(sc,3%x,33%y,94%x,57.5%y)
 
 sc.Panel.Width = 94%x
 sc.Panel.height = 258%y

   Panel1.RemoveView
  sc.Panel.AddView( Panel1,0%x,-9%y,94%x,277%y)

  Dim height As Int
    
   
    height = 50dip
    

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
 

	
	
	ImageView0.Top = 9%y
	ImageView0.Left = 0%x
	ImageView0.Width = 100%x
	ImageView0.height = 1%y

	
	textpin1.Top = 10%y
	textpin1.Left = 5%x
	textpin1.Width = 90%x
	textpin1.height = 14%y
	
	
	ImageView1.Top = 26%y
	ImageView1.Left = 0%x
	ImageView1.Width = 100%x
	ImageView1.height = 1%y
	
	
	
	
	ImageView2.Top = 46%y
	ImageView2.Left = 0%x
	ImageView2.Width = 100%x
	ImageView2.height = 1%y
	
	textpin2.Top = 30%y
	textpin2.Left = 5%x
	textpin2.Width = 90%x
	textpin2.height = 14%y
	
	
	ImageView3.Top = 66%y
	ImageView3.Left = 0%x
	ImageView3.Width = 100%x
	ImageView3.height = 1%y
	
	textpin3.Top = 50%y
	textpin3.Left = 5%x
	textpin3.Width = 90%x
	textpin3.height = 14%y
	
	
	
	ImageView4.Top = 86%y
	ImageView4.Left = 0%x
	ImageView4.Width = 100%x
	ImageView4.height = 1%y
	
	textpin4.Top = 70%y
	textpin4.Left = 5%x
	textpin4.Width = 90%x
	textpin4.height = 14%y
	
	

	ImageView5.Top = 106%y
	ImageView5.Left = 0%x
	ImageView5.Width = 100%x
	ImageView5.height = 1%y
	
	textpin5.Top = 90%y
	textpin5.Left = 5%x
	textpin5.Width = 90%x
	textpin5.height = 14%y
	
	
	
	
		'back2.Top = 86%y
	'back2.Left = 0%x
	'back2.Width = 100%x
	'back2.Height = 100%y
	
	
	
	ImageView6.Top = 126%y
	ImageView6.Left = 0%x
	ImageView6.Width = 100%x
	ImageView6.height = 1%y
	
	textpin6.Top = 110%y
	textpin6.Left = 5%x
	textpin6.Width = 90%x
	textpin6.height = 14%y
	
	
	
	ImageView7.Top = 146%y
	ImageView7.Left = 0%x
	ImageView7.Width = 100%x
	ImageView7.height = 1%y
	
		
	textpin7.Top = 130%y
	textpin7.Left = 5%x
	textpin7.Width = 90%x
	textpin7.height = 14%y
	
	
	
	ImageView8.Top = 166%y
	ImageView8.Left = 0%x
	ImageView8.Width = 100%x
	ImageView8.height = 1%y
	'back3.Top = 187%y
	'back3.Left = 0%x
	'back3.Width = 100%x
	'back3.Height = 36%y
	
		
	textpin8.Top = 150%y
	textpin8.Left = 5%x
	textpin8.Width = 90%x
	textpin8.height = 14%y
	
	
	
	ImageView9.Top = 186%y
	ImageView9.Left = 0%x
	ImageView9.Width = 100%x
	ImageView9.height = 1%y
	
		
	textpin9.Top = 170%y
	textpin9.Left = 5%x
	textpin9.Width = 90%x
	textpin9.height = 14%y
	
	
	
	
	
	ImageView10.Top = 206%y
	ImageView10.Left = 0%x
	ImageView10.Width = 100%x
	ImageView10.height = 1%y
	
	textpin10.Top = 190%y
	textpin10.Left = 5%x
	textpin10.Width = 90%x
	textpin10.height = 14%y
	
	
	ImageView11.Top = 226%y
	ImageView11.Left = 0%x
	ImageView11.Width = 100%x
	ImageView11.height = 1%y
	
	textpin11.Top = 210%y
	textpin11.Left = 5%x
	textpin11.Width = 90%x
	textpin11.height = 14%y
	
	
	'back4.Top = 222%y
	'back4.Left = 0%x
	'back4.Width = 100%x
	'back4.Height = 80%y
	
	
	ImageView12.Top = 246%y
	ImageView12.Left = 0%x
	ImageView12.Width = 100%x
	ImageView12.height = 1%y
	
	textpin12.Top = 230%y
	textpin12.Left = 5%x
	textpin12.Width = 90%x
	textpin12.height = 14%y
	
	
	'back5.Top = 302%y
	'back5.Left = 0%x
	'back5.Width = 100%x
	'back5.Height = 60%y
	
	
	ImageView13.Top = 266%y
	ImageView13.Left = 0%x
	ImageView13.Width = 100%x
	ImageView13.height = 1%y
	
	textpin13.Top = 250%y
	textpin13.Left = 5%x
	textpin13.Width = 90%x
	textpin13.height = 14%y
	
	
	
	
	
	
	
	
	
		
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
	
	rp.CheckAndRequest(rp.PERMISSION_CALL_PHONE)
	Wait For Activity_PermissionResult (Permission As String, Result As Boolean)
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub ili_Click
	StartActivity("firstaid")
	Activity.Finish
End Sub
Sub ousia_Click
	StartActivity("gpssignal")
	Activity.Finish
End Sub
Sub pixi_Click
	StartActivity("pixida")
	Activity.Finish
End Sub

Sub lista_Click
	StartActivity("camera")
	Activity.Finish
End Sub

Sub katigor_Click
	StartActivity("pixida")
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
	StartActivity("camera")
	Activity.Finish
End Sub
Sub katigorlabel_Click
	StartActivity("pixida")
	Activity.Finish
End Sub
Sub ousialabel_Click
	StartActivity("gpssignal")
	Activity.Finish
End Sub
Sub ililabel_Click
	StartActivity("firstaid")
	Activity.Finish
End Sub
Sub simansi_Click
	StartActivity("Main")
	Activity.Finish
End Sub





Sub textpin9_Click
	StartActivity("attiki")
End Sub
Sub textpin8_Click
	StartActivity("notioaig")
End Sub
Sub textpin7_Click
	StartActivity("ioniopel")
End Sub
Sub textpin6_Click
	StartActivity("thessalia")
End Sub
Sub textpin5_Click
	StartActivity("voreioaig")
End Sub
Sub textpin4_Click
	StartActivity("hpeiros")
End Sub
Sub textpin3_Click
	StartActivity("dytmak")
End Sub
Sub textpin2_Click
	StartActivity("kentrikimak")
End Sub
Sub textpin13_Click
	StartActivity("kriti")
End Sub
Sub textpin12_Click
	StartActivity("pelloponiso")
End Sub
Sub textpin11_Click
	StartActivity("dytellada")
End Sub
Sub textpin10_Click
	StartActivity("sterea")
End Sub
Sub textpin1_Click
	StartActivity("anthraki")
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub