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
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	'Dim AdView1 As AdView

	
	Private mple As Label
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label
	Dim deiktess As ImageView
	Dim Label11 As Label
	Dim Label22 As Label
	Dim Label33 As Label
	Dim getImg As String
	Dim job3 As HttpJob
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("deikt")
		

 

	simanseislabel.Top = 3%y
	simanseislabel.left = 3.5%x
	simanseislabel.height = 28%y
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

	deiktess.Top = 33%y
	deiktess.Left = 3%x
	deiktess.height = 57.5%y
	deiktess.Width = 94%x
	Dim server As ServerSocket 'Add a reference to the network library
	server.Initialize(0, "")
	If server.GetMyIP = "127.0.0.1" Then  'this is the local host address
		Msgbox("Δεν υπαρχει σύνδεση στο διαδίκτυο","Online δεδομένα")
		Activity.Finish
	Else
		
		load
	End If



	


End Sub
Sub load
	job3.Initialize("Job3", Me)

	Label11.Text = DateTime.GetMonth(DateTime.now)
	Label22.Text = DateTime.GetDayOfMonth(DateTime.now)
	Label33.Text = DateTime.GetYear(DateTime.now)
  
	If Label11.Text = "1" Then
		Label11.Text = "01"
	End If
	If Label11.Text = "2" Then
		Label11.Text = "02"
	End If
	If Label11.Text = "3" Then
		Label11.Text = "03"
	End If
	If Label11.Text = "4" Then
		Label11.Text = "04"
	End If
	If Label11.Text = "5" Then
		Label11.Text = "05"
	End If
	If Label11.Text = "6" Then
		Label11.Text = "06"
	End If
	If Label11.Text = "7" Then
		Label11.Text = "07"
	End If
	If Label11.Text = "8" Then
		Label11.Text = "08"
	End If
	If Label11.Text = "9" Then
		Label11.Text = "09"
	End If

	If Label22.Text = "1" Then
		Label22.Text = "01"
	End If
	If Label22.Text = "2" Then
		Label22.Text = "02"
	End If
	If Label22.Text = "3" Then
		Label22.Text = "03"
	End If
	If Label22.Text = "4" Then
		Label22.Text = "04"
	End If
	If Label22.Text = "5" Then
		Label22.Text = "05"
	End If
	If Label22.Text = "6" Then
		Label22.Text = "06"
	End If
	If Label22.Text = "7" Then
		Label22.Text = "07"
	End If
	If Label22.Text = "8" Then
		Label22.Text = "08"
	End If
	If Label22.Text = "9" Then
		Label22.Text = "09"
	End If



	If Label33.Text = 2000 Then
		Label33.Text = "00"
	End If
	If Label33.Text = 2001 Then
		Label33.Text = "01"
	End If
	If Label33.Text = 2002 Then
		Label33.Text = "02"
	End If
	If Label33.Text = 2003 Then
		Label33.Text = "03"
	End If
	If Label33.Text = 2004 Then
		Label33.Text = "04"
	End If
	If Label33.Text = 2005 Then
		Label33.Text = "05"
	End If
	If Label33.Text = 2006 Then
		Label33.Text = "06"
	End If
	If Label33.Text = 2007 Then
		Label33.Text = "07"
	End If
	If Label33.Text = 2008 Then
		Label33.Text = "08"
	End If
	If Label33.Text = 2009 Then
		Label33.Text = "09"
	End If
	If Label33.Text = 2010 Then
		Label33.Text = "10"
	End If
	If Label33.Text = 2011 Then
		Label33.Text = "11"
	End If
	If Label33.Text = 2012 Then
		Label33.Text = "12"
	End If
	If Label33.Text = 2013 Then
		Label33.Text = "13"
	End If
	If Label33.Text = 2014 Then
		Label33.Text = "14"
	End If
	If Label33.Text = 2015 Then
		Label33.Text = "15"
	End If
	If Label33.Text = 2016 Then
		Label33.Text = "16"
	End If
	If Label33.Text = 2017 Then
		Label33.Text = "17"
	End If
	If Label33.Text = 2018 Then
		Label33.Text = "18"
	End If
	If Label33.Text = 2019 Then
		Label33.Text = "19"
	End If
	If Label33.Text = "2020" Then
		Label33.Text = "20"
	End If
	If Label33.Text = "2021" Then
		Label33.Text = "21"
	End If
	If Label33.Text = "2022" Then
		Label33.Text = "22"
	End If
	If Label33.Text = "2023" Then
		Label33.Text = "23"
	End If
	If Label33.Text = "2024" Then
		Label33.Text = "24"
	End If
	If Label33.Text = "2025" Then
		Label33.Text = "25"
	End If
	If Label33.Text = "2026" Then
		Label33.Text = "26"
	End If
	If Label33.Text = "2027" Then
		Label33.Text = "27"
	End If
	If Label33.Text = "2028" Then
		Label33.Text = "28"
	End If
	If Label33.Text = "2029" Then
		Label33.Text = "29"
	End If


	epomeno
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	Activity.Finish
End Sub
Sub JobDone (Job As HttpJob)
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		Select Job.JobName
			Case "Job3"

				deiktess.SetBackgroundImage(Job.GetBitmap)
		End Select
	Else
	
		ToastMessageShow("Δεν ήταν δυνατή η σύνδεση.Οι χάρτες αναρτώνται μετα την 13:00 περιπου", True)
	End If
	Job.Release
End Sub
Sub epomeno
	If Label11.Text = "01" Then
		deiktess.Bitmap = LoadBitmap(File.DirAssets, "no.jpg")
	End If
	If Label11.Text = "02" Then
		deiktess.Bitmap = LoadBitmap(File.DirAssets, "no.jpg")
	End If
	If Label11.Text = "03" Then
		deiktess.Bitmap = LoadBitmap(File.DirAssets, "no.jpg")
	End If
	If Label11.Text = "04" Then
		deiktess.Bitmap = LoadBitmap(File.DirAssets, "no.jpg")
	End If
	If Label11.Text = "05" Then
		deiktess.Bitmap = LoadBitmap(File.DirAssets, "no.jpg")
	End If
	If Label11.Text= "06" Then
		getImg  = "https://www.civilprotection.gr/sites/default/gscp_uploads/" & Label33.Text & Label11.Text & Label22.Text & ".jpg"
		job3.Download(getImg)
		Log(getImg)
	End If
	If Label11.Text= "07" Then
		getImg  = "https://www.civilprotection.gr/sites/default/gscp_uploads/" & Label33.Text & Label11.Text & Label22.Text & ".jpg"
		job3.Download("https://www.civilprotection.gr/sites/default/gscp_uploads/" & Label33.Text & Label11.Text & Label22.Text & ".jpg")
		Log(getImg)
	End If
	If Label11.Text= "08" Then
		getImg  = "https://www.civilprotection.gr/sites/default/gscp_uploads/" & Label33.Text & Label11.Text & Label22.Text & ".jpg"
		job3.Download("https://www.civilprotection.gr/sites/default/gscp_uploads/" & Label33.Text & Label11.Text & Label22.Text & ".jpg")
		Log(getImg)
	End If
	If Label11.Text= "09" Then
		getImg  = "https://www.civilprotection.gr/sites/default/gscp_uploads/" & Label33.Text & Label11.Text & Label22.Text & ".jpg"
		job3.Download("https://www.civilprotection.gr/sites/default/gscp_uploads/" & Label33.Text & Label11.Text & Label22.Text & ".jpg")
		Log(getImg)
	End If
	If Label11.Text= "10" Then
		getImg  = "https://www.civilprotection.gr/sites/default/gscp_uploads/" & Label33.Text & Label11.Text & Label22.Text & ".jpg"
		job3.Download("https://www.civilprotection.gr/sites/default/gscp_uploads/" & Label33.Text & Label11.Text & Label22.Text & ".jpg")
		Log(getImg)
	End If
	If Label11.Text = "11" Then
		deiktess.Bitmap = LoadBitmap(File.DirAssets, "no.jpg")
	End If
	If Label11.Text = "12" Then
		deiktess.Bitmap = LoadBitmap(File.DirAssets, "no.jpg")
	End If
	
End Sub




Sub simanseislabel_Click
	StartActivity("avrio")
End Sub
Sub listabel_Click
	StartActivity("firstaid")
End Sub
Sub katigorlabel_Click
	StartActivity("pixida")
End Sub
Sub ousialabel_Click
	StartActivity("gpssignal")
End Sub
Sub ililabel_Click
	Dim p As PhoneIntents
	StartActivity(p.OpenBrowser("https://www.facebook.com/groups/256720274824210/"))
	
End Sub
