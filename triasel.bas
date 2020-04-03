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
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	
	Dim mpros As Button
	Dim piso As Button
	Dim vardia As Label
	Dim dt As String
	Dim simera As Label
	DateTime.DateFormat = "dd-MM-yyyy"
	dt = DateTime.Date(DateTime.now)

	Private mdc As myDynamicCalendar
	Dim maxindex As Int = 0
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("epilogis")
	
	Dim dates() As String = Array As String("03-01-2018", "06-01-2018", "09-01-2018", "12-01-2018", "15-01-2018", "18-01-2018", "21-01-2018", "24-01-2018", "27-01-2018", "30-01-2018", "02-02-2018", "05-02-2018", "08-02-2018", "11-02-2018", "14-02-2018", "17-02-2018", "20-02-2018", "23-02-2018", "26-02-2018", "01-03-2018", "04-03-2018", "07-03-2018", "10-03-2018", "13-03-2018", "16-03-2018", "19-03-2018", "22-03-2018", "25-03-2018", "28-03-2018", "31-03-2018", "03-04-2018", "06-04-2018", "09-04-2018", "12-04-2018", "15-04-2018", "18-04-2018", "21-04-2018", "24-04-2018", "27-04-2018", "30-04-2018", "03-05-2018", "06-05-2018", "09-05-2018", "12-05-2018","15-05-2018", "18-05-2018", "21-05-2018", "24-05-2018", "27-05-2018", "30-05-2018", "02-06-2018", "05-06-2018", "08-06-2018", "11-06-2018", "14-06-2018", "17-06-2018", "20-06-2018", "23-06-2018", "26-06-2018", "29-06-2018", "02-07-2018", "05-07-2018", "08-07-2018", "11-07-2018", "14-07-2018", "17-07-2018", "20-07-2018", "23-07-2018", "26-07-2018", "29-07-2018", "01-08-2018", "04-08-2018", "07-08-2018", "10-08-2018", "13-08-2018", "16-08-2018", "19-08-2018", "22-08-2018", "25-08-2018", "28-08-2018", "31-08-2018", "03-09-2018", "06-09-2018", "09-09-2018", "12-09-2018", "15-09-2018", "18-09-2018", "21-09-2018", "24-09-2018", "27-09-2018", "30-09-2018", "03-10-2018", "06-10-2018", "09-10-2018", "12-10-2018", "15-10-2018", "18-10-2018", "21-10-2018", "24-10-2018", "27-10-2018", "30-10-2018", "02-11-2018", "05-11-2018", "08-11-2018", "11-11-2018", "14-11-2018", "17-11-2018", "20-11-2018", "23-11-2018", "26-11-2018", "29-11-2018", "02-12-2018", "05-12-2018", "08-12-2018", "11-12-2018", "14-12-2018", "17-12-2018", "20-12-2018", "23-12-2018", "26-12-2018", "29-12-2018","01-01-2019","04-01-2019", "07-01-2019", "10-01-2019", "13-01-2019", "16-01-2019", "19-01-2019", "22-01-2019", "25-01-2019", "28-01-2019", "31-01-2019", "03-02-2019", "06-02-2019", "09-02-2019", "12-02-2019", "15-02-2019", "18-02-2019", "21-02-2019", "24-02-2019", "27-02-2019", "02-03-2019", "05-03-2019", "08-03-2019", "11-03-2019", "14-03-2019", "17-03-2019", "20-03-2019", "23-03-2019", "26-03-2019", "29-03-2019", "01-04-2019", "04-04-2019", "07-04-2019", "10-04-2019", "13-04-2019", "16-04-2019", "19-04-2019", "22-04-2019", "25-04-2019", "28-04-2019", "01-05-2019", "04-05-2019", "07-05-2019", "10-05-2019","13-05-2019", "16-05-2019", "19-05-2019", "22-05-2019", "25-05-2019", "28-05-2019", "31-05-2019", "03-06-2019", "06-06-2019", "09-06-2019", "12-06-2019", "15-06-2019", "18-06-2019", "21-06-2019", "24-06-2019", "27-06-2019", "30-06-2019", "03-07-2019", "06-07-2019", "09-07-2019", "12-07-2019", "15-07-2019", "18-07-2019", "21-07-2019", "24-07-2019", "27-07-2019", "30-08-2019", "02-08-2019", "05-08-2019", "08-08-2019", "11-08-2019", "14-08-2019", "17-08-2019", "20-08-2019", "23-08-2019", "26-08-2019", "29-08-2019", "01-09-2019", "04-09-2019", "07-09-2019", "10-09-2019", "13-09-2019", "16-09-2019", "19-09-2019", "22-09-2019", "25-09-2019", "28-09-2019", "01-10-2019", "04-10-2019", "07-10-2019", "10-10-2019", "13-10-2019", "16-10-2019", "19-10-2019", "22-10-2019", "25-10-2019", "28-10-2019", "31-11-2019", "03-11-2019", "06-11-2019", "09-11-2019", "12-11-2019", "15-11-2019", "18-11-2019", "21-11-2019", "24-11-2019", "27-11-2019", "30-12-2019", "03-12-2019", "06-12-2019", "09-12-2019", "12-12-2019", "15-12-2019", "18-12-2019", "21-12-2019", "24-12-2019", "27-12-2019", "30-12-2019","02-01-2020", "05-01-2020", "08-01-2020", "11-01-2020", "14-01-2020", "17-01-2020", "20-01-2020", "23-01-2020", "26-01-2020", "29-01-2020", "01-02-2020", "04-02-2020", "07-02-2020", "10-02-2020", "13-02-2020", "16-02-2020", "19-02-2020", "22-02-2020", "25-02-2020", "28-02-2020", "02-03-2020","05-03-2020", "08-03-2020", "11-03-2020", "14-03-2020", "17-03-2020", "20-03-2020", "23-03-2020", "26-03-2020", "29-03-2020", "01-04-2020", "04-04-2020", "07-04-2020", "10-04-2020", "13-04-2020", "16-04-2020", "19-04-2020", "22-04-2020", "25-04-2020", "28-04-2020", "01-05-2020", "04-05-2020", "07-05-2020", "10-05-2020","13-05-2020", "16-05-2020", "19-05-2020", "22-05-2020", "25-05-2020", "28-05-2020", "31-05-2020", "03-06-2020", "06-06-2020", "09-06-2020", "12-06-2020", "15-06-2020", "18-06-2020", "21-06-2020", "24-06-2020", "27-06-2020", "30-06-2020", "03-07-2020", "06-07-2020", "09-07-2020", "12-07-2020", "15-07-2020", "18-07-2020", "21-07-2020", "24-07-2020", "27-07-2020", "30-08-2020", "02-08-2020", "05-08-2020", "08-08-2020", "11-08-2020", "14-08-2020", "17-08-2020", "20-08-2020", "23-08-2020", "26-08-2020", "29-08-2020", "01-09-2020", "04-09-2020", "07-09-2020", "10-09-2020", "13-09-2020", "16-09-2020", "19-09-2020", "22-09-2020", "25-09-2020", "28-09-2020", "01-10-2020", "04-10-2020", "07-10-2020", "10-10-2020", "13-10-2020", "16-10-2020", "19-10-2020", "22-10-2020", "25-10-2020", "28-10-2020", "31-11-2020", "03-11-2020", "06-11-2020", "09-11-2020", "12-11-2020", "15-11-2020", "18-11-2020", "21-11-2020", "24-11-2020", "27-11-2020", "30-12-2020", "03-12-2020", "06-12-2020", "09-12-2020", "12-12-2020", "15-12-2020", "18-12-2020", "21-12-2020", "24-12-2020", "27-12-2020", "30-12-2020","02-01-2021", "05-01-2021", "08-01-2021", "11-01-2021", "14-01-2021", "17-01-2021", "20-01-2021", "23-01-2021", "26-01-2021", "29-01-2021", "01-02-2021", "04-02-2021", "07-02-2021", "10-02-2021", "13-02-2021", "16-02-2021", "19-02-2021", "22-02-2021", "25-02-2021", "28-02-2021", "03-03-2021", "06-03-2021", "09-03-2021", "12-03-2021", "15-03-2021", "18-03-2021", "21-03-2021", "24-03-2021", "27-03-2021", "30-03-2021", "02-04-2021", "05-04-2021", "08-04-2021", "11-04-2021", "14-04-2021", "17-04-2021", "20-04-2021", "23-04-2021", "26-04-2021", "29-04-2021", "02-05-2021", "05-05-2021", "08-05-2021", "11-05-2021","14-05-2021", "17-05-2021", "20-05-2021", "23-05-2021", "26-05-2021", "29-05-2021", "01-06-2021", "04-06-2021", "07-06-2021", "10-06-2021", "13-06-2021", "16-06-2021", "19-06-2021", "22-06-2021", "25-06-2021", "28-06-2021", "01-07-2021", "04-07-2021", "07-07-2021", "10-07-2021", "13-07-2021", "16-07-2021", "19-07-2021", "22-07-2021", "25-07-2021", "28-07-2021", "31-07-2021", "03-08-2021", "06-08-2021", "09-08-2021", "12-08-2021", "15-08-2021", "18-08-2021", "21-08-2021", "24-08-2021", "27-08-2021", "30-08-2021", "02-09-2021", "05-09-2021", "08-09-2021", "11-09-2021", "14-09-2021", "17-09-2021", "20-09-2021", "23-09-2021", "26-09-2021", "29-09-2021", "02-10-2021", "05-10-2021", "08-10-2021", "11-10-2021", "14-10-2021", "17-10-2021", "20-10-2021", "23-10-2021", "26-10-2021", "29-10-2021", "01-11-2021", "04-11-2021", "07-11-2021", "10-11-2021", "13-11-2021", "16-11-2021", "19-11-2021", "22-11-2021", "25-11-2021", "28-11-2021", "01-12-2021", "04-12-2021", "07-12-2021", "10-12-2021", "13-12-2021", "16-12-2021", "19-12-2021", "22-12-2021", "25-12-2021", "28-12-2021", "31-12-2021")


	
	Dim starttime() As String = Array As String("07:30")
	Dim endtime() As String = Array As String("07:30")
	Dim events() As String = Array As String("Υπηρεσία")
	
	Dim weekdaynames() As String = Array As String("Δευ", "Τρι", "Τετ", "Πεμ", "Παρ", "Σαβ", "Κυρ")
	'Dim weekdaynames() As String = Array As String("星期一", "星期二", "星期四", "星期三", "星期五", "星期六", "星期日")

	
'	Dim holidays() As String = Array As String("14-07-2018", "15-07-2018", "16-07-2018", "17-07-2018", "18-07-2018")
	mdc.showMonthView
	For i = 0 To 486
		mdc.addEvent(dates(i), starttime(0), endtime(0), events(0))
	Next
	
	'For i = 0 To 4
'		mdc.addHolidays(holidays(i))
'	Next


	mdc.HolidayCellBackgroundColor = Colors.LightGray
	mdc.HolidayCellTextColor = Colors.Red
	mdc.CalendarBackgroundColor = Colors.White
	mdc.HeaderBackgroundColor = Colors.White
	mdc.HeaderTextColor = Colors.Magenta
	mdc.NextPreviousIndicatorColor = Colors.Blue
	mdc.WeekDayLayoutBackgroundColor = Colors.Blue
	mdc.WeekDayLayoutTextColor = Colors.White
	mdc.isSaturdayOff(True, Colors.LightGray, Colors.Red)
	mdc.isSundayOff(True, Colors.LightGray, Colors.Red)
	mdc.ExtraDatesOfMonthBackgroundColor = Colors.Black
	mdc.ExtraDatesOfMonthTextColor = Colors.White
	mdc.DatesOfMonthBackgroundColor = Colors.Cyan
	mdc.DatesOfMonthTextColor = Colors.ARGB(200, 255, 0, 100)
	
	mdc.WeekDayNames = weekdaynames
	
	mdc.CurrentDateBackgroundColor = Colors.Red
	mdc.CurrentDateTextColor = Colors.White
	
	mdc.EventCellBackgroundColor = Colors.Cyan
	mdc.EventCellTextColor = Colors.Blue
	mdc.BelowMonthEventTextColor = Colors.Black
	mdc.BelowMonthEventDividerColor = Colors.Red
	mdc.HolidayCellClickable = True
	
	mdc.ListOfEvents                 'see the event being raised - Sub mdc_get_events(eventname As String, eventstartdate As String, eventstrattime As String, eventendtime As String)
	simera.Text = dt
	'Msgbox(simera.text,"")
	If File.ReadString(File.DirInternal, "select.txt") = "exit" Then
		Activity.Finish
		
	End If

	vardia.Text = File.ReadString(File.DirInternal, "vardia.txt")
	If vardia.Text = "bardiaena" Then
		StartActivity(bardiaena)
		
	End If
	
	If vardia.Text = "vardiadyo" Then
		StartActivity(vardiadyo)
		
	End If
	
	If vardia.Text = "vardiatria" Then
		StartActivity(vardiatria)
		
	End If
	
End Sub

Sub Activity_Resume
	Log("resume" &  File.ReadString(File.DirInternal, "select.txt"))
	If File.ReadString(File.DirInternal, "vardia.txt") = "exit" Then
		Activity.Finish
		
	End If

	vardia.Text = File.ReadString(File.DirInternal, "vardia.txt")
	If vardia.Text = "bardiaena" Then
		StartActivity(bardiaena)
		
	End If
	
	If vardia.Text = "vardiadyo" Then
		StartActivity(vardiadyo)
		
	End If
	
	If vardia.Text = "vardiatria" Then
		StartActivity(vardiatria)
		
	End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub




Sub mdc_get_events(eventname As String, eventstartdate As String, eventstarttime As String, eventendtime As String, index As Int)
'	Log("eventname = " & eventname)
'	Log("eventstartdate = " & eventstartdate)
'	Log("eventstarttime = " & eventstarttime)
'	Log("eventendtime = " & eventendtime)
'	Log("index = " & index)
	maxindex = index
'	Log("maxindex = " & maxindex)
'	Log("***************************")
	
End Sub



Sub Button1_Click
	
'	mdc.deleteEvent(0)
'	mdc.showMonthViewWithBelowEvents
'	Log("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&")
'	mdc.ListOfEvents                 'see the event being raised - Sub mdc_get_events(eventname As String, eventstartdate As String, eventstrattime As String, eventendtime As String)
	
End Sub

Sub mdc_previous_selected()
	
	Log("arrow previous clicked")
	
End Sub

Sub mdc_next_selected()
	
	Log("arrow next clicked")
	
End Sub




Sub mpros_Click
	StartActivity(enasel)
	Activity.Finish
End Sub
Sub piso_Click
	StartActivity(dyosel)
	Activity.Finish
End Sub
Sub epilogi_Click
	vardia.Text = "vardiatria"
	File.WriteString(File.DirInternal, "vardia.txt", "vardiatria")
	
		
	Activity.Finish
	
	'StartActivity(vardia.Text)
	
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean 'return true if you want to consume the event
	Log("keypress" &  File.ReadString(File.DirInternal, "select.txt"))
	StartActivity(Main)
	Activity.Finish
End Sub
