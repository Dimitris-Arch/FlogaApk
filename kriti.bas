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
	
clv2.AddTextItem("1ος ΠΥΡΟΣΒΕΣΤΙΚΟΣ ΣΤΑΘΜΟΣ ΗΡΑΚΛΕΙΟΥ", "Τηλ: 2813-407000 ")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΜΟΙΡΩΝ", "Τηλ: 28920-41150")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΧΕΡΣΟΝΗΣΟΥ", "Τηλ: 28970-21111")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΠΥΡΓΟΥ ΜΟΝΟΦΑΣΙΟΥ", "Τηλ: 28930-23800")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΑΝΩ ΒΙΑΝΝΟΥ", "Τηλ: 28950-31226")
	clv2.AddTextItem("2ος ΠΥΡΟΣΒΕΣΤΙΚΟΣ ΣΤΑΘΜΟΣ Κ/Α ΗΡΑΚΛΕΙΟΥ", "Τηλ: 2810245590")
clv2.AddTextItem("3ος ΠΥΡΟΣΒΕΣΤΙΚΟΣ ΣΤΑΘΜΟΣ ΛΙΜΕΝΑ ΗΡΑΚΛΕΙΟΥ", "Τηλ: 2810-332710")
	clv2.AddTextItem("4ος ΠΥΡΟΣΒΕΣΤΙΚΟΣ ΣΤΑΘΜΟΣ ΗΡΑΚΛΕΙΟΥ ΒΙΠΕ", "Τηλ: 28103-81611")
	clv2.AddTextItem("1ος ΠΥΡΟΣΒΕΣΤΙΚΟΣ ΣΤΑΘΜΟΣ ΧΑΝΙΩΝ", "Τηλ: 28210-84110")
	clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΚΑΜΠΑΝΟΥ", "Τηλ: 28230-51027 ")
	clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΒΡΥΣΣΩΝ", "Τηλ: 28250-53010")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΛΑΚΚΩΝ ΧΑΝΙΩΝ", "Τηλ: 28210-97331")
clv2.AddTextItem("2ος ΠΥΡΟΣΒΕΣΤΙΚΟΣ ΣΤΑΘΜΟΣ Π/Α ΣΟΥΔΑΣ ΧΑΝΙΩΝ", "Τηλ: 28210-63288")
	clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΚΑΣΤΕΛΛΙΟΥ(ΚΙΣΣΑΜΟΥ)", "Τηλ: 28220-22199")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΚΑΝΔΑΝΟΥ", "Τηλ: 28230-22593")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΡΕΘΥΜΝΗΣ", "Τηλ: 28310-22222")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΣΠΗΛΙΟΥ", "Τηλ: 28320-22018 ")
	clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΠΕΡΑΜΑΤΟΣ ΡΕΘΥΜΝΟΥ", "Τηλ: 28340-20009")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΓΑΡΑΖΟΥ", "Τηλ: 28340-41019")
	clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΑΓΙΑΣ ΦΩΤΕΙΝΗΣ", "Τηλ: 28330-22506")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΕΠΙΣΚΟΠΗΣ", "Τηλ: 28310-61012")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΑΓΙΟΥ ΝΙΚΟΛΑΟΥ", "Τηλ: 28410-28733")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΤΖΕΡΜΙΑΔΟΥ (ΟΡΟΠΕΔΙΟΥ ΛΑΣΙΘΙΟΥ)", "Τηλ: 28440-22633")
	clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΙΕΡΑΠΕΤΡΑΣ", "Τηλ: 28420-20960")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΣΗΤΕΙΑΣ", "Τηλ: 28430-26311")
clv2.AddTextItem("3η ΕΜΑΚ", "Τηλ: 2810-381611-13 ")



 

 
 




 


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