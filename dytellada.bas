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


	Dim Panel As Panel
	
	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("tadr.bal")
     
	
simansi.Top = 3%y
simansi.left = 3%x
simansi.height = 28%y
simansi.Width  = 45%x
simanseislabel.Top = 3%y
simanseislabel.left = 3.5%x
simanseislabel.height = 27.5%y
simanseislabel.Width  = 45%x

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


	
	
  
  
  	clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0.5%x, 0%y,93%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray
	
clv2.AddTextItem("1ος ΠΥΡΟΣΒΕΣΤΙΚΟΣ ΣΤΑΘΜΟΣ ΠΑΤΡΩΝ", "Τηλ: 2610-333211 ")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΧΑΛΑΝΔΡΙΤΣΑΣ", "Τηλ: 26940-22881")

clv2.AddTextItem("2ος ΠΥΡΟΣΒΕΣΤΙΚΟΣ ΣΤΑΘΜΟΣ ΛΙΜΕΝΑ ΠΑΤΡΩΝ", "Τηλ: 2610-331933")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΒΙ.ΠΕ. ΠΑΤΡΩΝ", "Τηλ: 2610-647191")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ Π/Α ΑΡΑΞΟΥ", "Τηλ: 26930-52022")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΑΙΓΙΟΥ", "Τηλ: 26910-22201")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΑΚΡΑΤΑΣ", "Τηλ: 26960-22653")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΚΑΛΑΒΡΥΤΩΝ", "Τηλ: 26920-29430")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΜΕΣΟΛΟΓΓΙΟΥ", "Τηλ: 26310-28787")

	clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΑΓΡΙΝΙΟΥ", "Τηλ: 26410-30060 ")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΘΕΡΜΟΥ", "Τηλ: 26440-24200")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΝΑΥΠΑΚΤΟΥ", "Τηλ: 26340-27618")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΑΜΦΙΛΟΧΙΑΣ", "Τηλ: 26420-22010")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΠΥΡΓΟΥ", "Τηλ: 26210-22199")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΑΡΧΑΙΑΣ ΟΛΥΜΠΙΑΣ", "Τηλ: 26240-29104")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΚΡΕΣΤΕΝΩΝ", "Τηλ: 26250-22910")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΑΜΑΛΙΑΔΑΣ", "Τηλ: 26220-28536 ")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΛΕΧΑΙΝΩΝ", "Τηλ: 26230-22177")

clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ Π/Α ΑΝΔΡΑΒΙΔΑΣ", "Τηλ: 26230-24009")

clv2.AddTextItem("6η ΕΜΑΚ", "Τηλ: 2613-615610 ")


 

 
 




 


End Sub

Sub clv2_ItemClick (Index As Int, Value As Object)
	Activity.Title = Value
	
Dim p As PhoneCalls




	
	
	Dim result As Int
result = Msgbox2(Value, "  ", "Κλήση", "", "Κλείσιμο",  LoadBitmap (File.DirAssets, "thl.png"))
If result = DialogResponse.Positive Then
	StartActivity(p.Call(Value))
	End If
End Sub

Sub CreateListItem(Text As String, Width As Int, Height As Int) As Panel
	Dim p As Panel
	p.Initialize("")
	p.Color = Colors.Black
	Dim b As Button
	b.Initialize("button") 'all buttons click events will be handled with Sub Button_Click
	Dim chk As CheckBox
	chk.Initialize("")
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Bit.Or(Gravity.CENTER_VERTICAL, Gravity.LEFT)
	lbl.Text = Text
	lbl.TextSize = 16
	lbl.TextColor = Colors.White
	b.Text = "Click"
	p.AddView(lbl, 5dip, 2dip, 150dip, Height - 4dip) 'view #0
	p.AddView(b, 155dip, 2dip, 110dip, Height - 4dip) 'view #1
	p.AddView(chk, 280dip, 2dip, 50dip, Height - 4dip) 'view #2
	Return p
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
Activity.Finish
End Sub

Sub ili_Click
	StartActivity("firstaid")
End Sub
Sub ousia_Click
	StartActivity("gpssignal")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("camera")
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
	StartActivity("camera")
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
Sub simansi_Click
	StartActivity("Main")
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub