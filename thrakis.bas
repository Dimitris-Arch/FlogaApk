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
	Dim pin1 As ImageView
	




	Dim Panel As Panel
	
	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("thraki.bal")
    
  pin1.Top = 0%y
	pin1.Left =33.3%x
	pin1.Width = 25%x
	pin1.Height = 20%y
	
	
	
	

	
	
	
	
  
  
clv2.Initialize(Me, "clv2")
		Panel2.AddView(clv2.AsView, 0, 0,100%x ,80%y )
	 Panel2.Top = 20%y
  Panel2.Left = 0%x
  Panel2.Width = 100%x
  Panel2.Height = 80%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΗ ΥΠΗΡΕΣΙΑ ΚΟΜΟΤΗΝΗΣ Μπακάλμπαση 4 ΚΟΜΟΤΗΝΗ Τηλ: 25310-22199", "")
clv2.AddTextItem("ΠΥΡΟΣΒΕΣΤΙΚΟ ΚΛΙΜΑΚΙΟ ΣΑΠΠΩΝ", "")
clv2.AddTextItem("Δημητρίου Σαγίρη 4 ", "")
clv2.AddTextItem("ΣΑΠΠΕΣ ", "")
clv2.AddTextItem("T.K.: 693 00 ", "")
clv2.AddTextItem("Τηλ: 25320-22304", "")

End Sub

Sub clv1_ItemClick (Index As Int, Value As Object)
	Activity.Title = Value
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
	lbl.Gravity = Bit.OR(Gravity.CENTER_VERTICAL, Gravity.LEFT)
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

End Sub


