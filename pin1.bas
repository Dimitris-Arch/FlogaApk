Type=Activity
Version=3.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	Dim pin1 As ImageView
	Dim pin2 As ImageView
	Dim pin3 As ImageView
	Dim pin4 As ImageView
Dim sc As ScrollView
Dim Panel As Panel
Dim Panel1 As Panel
Dim textpin1 As Label
	Private ImageView1 As ImageView
	Private back1 As ImageView
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("pin1.bal")
     sc.initialize(1000dip)
 Activity.AddView(sc,0%x,0%y,100%x,100%y)
 
 sc.Panel.Width = 100%x
 sc.Panel.Height = 526.9%y

   Panel1.RemoveView
  sc.Panel.AddView( Panel1,0%x,0%y,100%x,526.9%y)
  
  
  pin1.Top = 10%y
	pin1.Left = 0%x
	pin1.Width = 25%x
	pin1.Height = 20%y
	
	pin2.Top = 10%y
	pin2.Left = 25%x
	pin2.Width = 25%x
	pin2.Height = 20%y
	
	pin3.Top = 10%y
	pin3.Left = 50%x
	pin3.Width = 25%x
	pin3.Height = 20%y
	
	pin4.Top = 10%y
	pin4.Left = 75%x
	pin4.Width = 25%x
	pin4.Height = 20%y
	
	
	textpin1.Top = 40%y
	textpin1.Left = 0%x
	textpin1.Width = 100%x
	textpin1.Height = 100%y
	
	
	ImageView1.Top = 26%y
	ImageView1.Left = 0%x
	ImageView1.Width = 100%x
	ImageView1.Height = 1%y
	
	back1.Top = 0%y
	back1.Left = 0%x
	back1.Width = 100%x
	back1.Height = 100%y
  
  
  

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


