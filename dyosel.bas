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
	

	Dim dates() As String = Array As String("01-01-2018", "04-01-2018", "07-01-2018", "10-01-2018", "13-01-2018", "16-01-2018", "19-01-2018", "22-01-2018", "25-01-2018", "28-01-2018", "31-01-2018", "03-02-2018", "06-02-2018", "09-02-2018", "12-02-2018", "15-02-2018", "18-02-2018", "21-02-2018", "24-02-2018", "27-02-2018", "02-03-2018", "05-03-2018", "08-03-2018", "11-03-2018", "14-03-2018", "17-03-2018", "20-03-2018", "23-03-2018", "26-03-2018", "29-03-2018", "01-04-2018", "04-04-2018", "07-04-2018", "10-04-2018", "13-04-2018", "16-04-2018", "19-04-2018", "22-04-2018", "25-04-2018", "28-04-2018", "01-05-2018", "04-05-2018", "07-05-2018", "10-05-2018","13-05-2018", "16-05-2018", "19-05-2018", "22-05-2018", "25-05-2018", "28-05-2018", "31-05-2018", "03-06-2018", "06-06-2018", "09-06-2018", "12-06-2018", "15-06-2018", "18-06-2018", "21-06-2018", "24-06-2018", "27-06-2018", "30-06-2018", "03-07-2018", "06-07-2018", "09-07-2018", "12-07-2018", "15-07-2018", "18-07-2018", "21-07-2018", "24-07-2018", "27-07-2018", "30-08-2018", "02-08-2018", "05-08-2018", "08-08-2018", "11-08-2018", "14-08-2018", "17-08-2018", "20-08-2018", "23-08-2018", "26-08-2018", "29-08-2018", "01-09-2018", "04-09-2018", "07-09-2018", "10-09-2018", "13-09-2018", "16-09-2018", "19-09-2018", "22-09-2018", "25-09-2018", "28-09-2018", "01-10-2018", "04-10-2018", "07-10-2018", "10-10-2018", "13-10-2018", "16-10-2018", "19-10-2018", "22-10-2018", "25-10-2018", "28-10-2018", "31-11-2018", "03-11-2018", "06-11-2018", "09-11-2018", "12-11-2018", "15-11-2018", "18-11-2018", "21-11-2018", "24-11-2018", "27-11-2018", "30-12-2018", "03-12-2018", "06-12-2018", "09-12-2018", "12-12-2018", "15-12-2018", "18-12-2018", "21-12-2018", "24-12-2018", "27-12-2018","30-12-2018","02-01-2019", "05-01-2019", "08-01-2019", "11-01-2019", "14-01-2019", "17-01-2019", "20-01-2019", "23-01-2019", "26-01-2019", "29-01-2019", "01-02-2019", "04-02-2019", "07-02-2019", "10-02-2019", "13-02-2019", "16-02-2019", "19-02-2019", "22-02-2019", "25-02-2019", "28-02-2019", "03-03-2019", "06-03-2019", "09-03-2019", "12-03-2019", "15-03-2019", "18-03-2019", "21-03-2019", "24-03-2019", "27-03-2019", "30-03-2019", "02-04-2019", "05-04-2019", "08-04-2019", "11-04-2019", "14-04-2019", "17-04-2019", "20-04-2019", "23-04-2019", "26-04-2019", "29-04-2019", "02-05-2019", "05-05-2019", "08-05-2019", "11-05-2019","14-05-2019", "17-05-2019", "20-05-2019", "23-05-2019", "26-05-2019", "29-05-2019", "01-06-2019", "40-06-2019", "07-06-2019", "10-06-2019", "13-06-2019", "16-06-2019", "19-06-2019", "22-06-2019", "25-06-2019", "28-06-2019", "01-07-2019", "04-07-2019", "07-07-2019", "10-07-2019", "13-07-2019", "16-07-2019", "19-07-2019", "22-07-2019", "25-07-2019", "28-07-2019", "31-07-2019", "03-08-2019", "06-08-2019", "09-08-2019", "12-08-2019", "15-08-2019", "18-08-2019", "21-08-2019", "24-08-2019", "27-08-2019", "30-08-2019", "02-09-2019", "05-09-2019", "08-09-2019", "11-09-2019", "14-09-2019", "17-09-2019", "20-09-2019", "23-09-2019", "26-09-2019", "29-09-2019", "02-10-2019", "05-10-2019", "08-10-2019", "11-10-2019", "14-10-2019", "17-10-2019", "20-10-2019", "23-10-2019", "26-10-2019", "29-10-2019", "01-11-2019", "04-11-2019", "07-11-2019", "10-11-2019", "13-11-2019", "16-11-2019", "19-11-2019", "22-11-2019", "25-11-2019", "28-11-2019", "01-12-2019", "04-12-2019", "07-12-2019", "10-12-2019", "13-12-2019", "16-12-2019", "19-12-2019", "22-12-2019", "25-12-2019", "28-12-2019","31-12-2019", "03-01-2020", "06-01-2020", "09-01-2020", "12-01-2020", "15-01-2020", "18-01-2020", "21-01-2020", "24-01-2020", "27-01-2020", "30-01-2020", "02-02-2020", "05-02-2020", "08-02-2020", "11-02-2020", "14-02-2020", "17-02-2020", "20-02-2020", "23-02-2020", "26-02-2020", "29-02-2020","03-03-2020", "06-03-2020", "09-03-2020", "12-03-2020", "15-03-2020", "18-03-2020", "21-03-2020", "24-03-2020", "27-03-2020", "30-03-2020", "02-04-2020", "05-04-2020", "08-04-2020", "11-04-2020", "14-04-2020", "17-04-2020", "20-04-2020", "23-04-2020", "26-04-2020", "29-04-2020", "02-05-2020", "05-05-2020", "08-05-2020", "11-05-2020","14-05-2020", "17-05-2020", "20-05-2020", "23-05-2020", "26-05-2020", "29-05-2020", "01-06-2020", "04-06-2020", "07-06-2020", "10-06-2020", "13-06-2020", "16-06-2020", "19-06-2020", "22-06-2020", "25-06-2020", "28-06-2020", "01-07-2020", "04-07-2020", "07-07-2020", "10-07-2020", "13-07-2020", "16-07-2020", "19-07-2020", "22-07-2020", "25-07-2020", "28-07-2020", "31-07-2020", "03-08-2020", "06-08-2020", "09-08-2020", "12-08-2020", "15-08-2020", "18-08-2020", "21-08-2020", "24-08-2020", "27-08-2020", "30-08-2020", "02-09-2020", "05-09-2020", "08-09-2020", "11-09-2020", "14-09-2020", "17-09-2020", "20-09-2020", "23-09-2020", "26-09-2020", "29-09-2020", "02-10-2020", "05-10-2020", "08-10-2020", "11-10-2020", "14-10-2020", "17-10-2020", "20-10-2020", "23-10-2020", "26-10-2020", "29-10-2020", "01-11-2020", "04-11-2020", "07-11-2020", "10-11-2020", "13-11-2020", "16-11-2020", "19-11-2020", "22-11-2020", "25-11-2020", "28-11-2020", "01-12-2020", "04-12-2020", "07-12-2020", "10-12-2020", "13-12-2020", "16-12-2020", "19-12-2020", "22-12-2020", "25-12-2020", "28-12-2020","31-12-2020", "03-01-2021", "06-01-2021", "09-01-2021", "12-01-2021", "15-01-2021", "18-01-2021", "21-01-2021", "24-01-2021", "27-01-2021", "30-01-2021", "02-02-2021", "05-02-2021", "08-02-2021", "11-02-2021", "14-02-2021", "17-02-2021", "20-02-2021", "23-02-2021", "26-02-2021", "29-02-2021", "04-03-2021", "07-03-2021", "10-03-2021", "13-03-2021", "16-03-2021", "19-03-2021", "22-03-2021", "25-03-2021", "28-03-2021", "31-03-2021", "03-04-2021", "06-04-2021", "09-04-2021", "12-04-2021", "15-04-2021", "18-04-2021", "21-04-2021", "24-04-2021", "27-04-2021", "30-04-2021", "03-05-2021", "06-05-2021", "09-05-2021", "12-05-2021","15-05-2021", "18-05-2021", "21-05-2021", "24-05-2021", "27-05-2021", "30-05-2021", "02-06-2021", "05-06-2021", "08-06-2021", "11-06-2021", "14-06-2021", "17-06-2021", "20-06-2021", "23-06-2021", "26-06-2021", "29-06-2021", "02-07-2021", "05-07-2021", "08-07-2021", "11-07-2021", "14-07-2021", "17-07-2021", "20-07-2021", "23-07-2021", "26-07-2021", "29-07-2021", "01-08-2021", "04-08-2021", "07-08-2021", "10-08-2021", "13-08-2021", "16-08-2021", "19-08-2021", "22-08-2021", "25-08-2021", "28-08-2021", "31-08-2021", "03-09-2021", "06-09-2021", "09-09-2021", "12-09-2021", "15-09-2021", "18-09-2021", "21-09-2021", "24-09-2021", "27-09-2021", "30-09-2021", "03-10-2021", "06-10-2021", "09-10-2021", "12-10-2021", "15-10-2021", "18-10-2021", "21-10-2021", "24-10-2021", "27-10-2021", "30-10-2021", "02-11-2021", "05-11-2021", "08-11-2021", "11-11-2021", "14-11-2021", "17-11-2021", "20-11-2021", "23-11-2021", "26-11-2021", "29-11-2021", "02-12-2021", "05-12-2021", "08-12-2021", "11-12-2021", "14-12-2021", "17-12-2021", "20-12-2021", "23-12-2021", "26-12-2021", "29-12-2021")


	
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
	vardia.Text = File.ReadString(File.DirInternal, "vardia.txt")
	If File.ReadString(File.DirInternal, "select.txt") = "exit" Then
		Activity.Finish
		
	End If

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

Sub Month_Click
	
	mdc.showMonthView
	
End Sub

Sub MonthWithEvents_Click
	
	mdc.showMonthViewWithBelowEvents
	
End Sub

Sub Week_Click
	
	mdc.showWeekView
	
End Sub

Sub Day_Click
	
	mdc.showDayView
	
End Sub

Sub Agenda_Click
	
	mdc.showAgendaView
	
End Sub

Sub Today_Click
	
	mdc.showToday
	
End Sub
Sub Neo_Click
	Dim dates() As String = Array As String(simera.text)
	Dim starttime() As String = Array As String("07:30")
	Dim endtime() As String = Array As String("07:30")
	Dim events() As String = Array As String("aaaaaaa")
	
	For i = 0 To 0
	
		mdc.addEvent(dates(i), starttime(i), endtime(i), events(i))
	Next
	mdc.showMonthViewWithBelowEvents
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
	
	
	
End Sub

Sub mdc_next_selected()
	
	
	
End Sub

Sub mdc_month_view_event_selected(eventlist As Object)
	
	Dim mylist As List  = eventlist
	For i = 0 To mylist.Size - 1
		Log("mdc_month_view_event_selected(" & i & ") = " & mylist.Get(i))
	Next
	
	
End Sub

Sub mdc_day_clicked(day As String, time As String)
	
	Log("DAY = " & day)
	Log("TIME = "& time)
	Log("*******************")
	
End Sub


Sub mpros_Click
	StartActivity(triasel)
	Activity.Finish
End Sub
Sub piso_Click
	StartActivity(enasel)
	Activity.Finish
End Sub
Sub epilogi_Click
	vardia.Text = "vardiadyo"
	File.WriteString(File.DirInternal, "vardia.txt", "vardiadyo")
	
	
		
	Activity.Finish
	
'	StartActivity(vardia.Text)
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean 'return true if you want to consume the event
	Log("keypress" &  File.ReadString(File.DirInternal, "select.txt"))
	StartActivity(Main)
	Activity.Finish
End Sub
