B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim index As Object
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

	
	Dim sv As SearchView
	Dim Panel2 As Panel
	Private delete As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("adrSearch.bal")
	Panel2.Top = 33%y
	Panel2.Left = 3%x
	Panel2.Width = 94%x
	Panel2.Height = 57.5%y
	
	Panel2.Color= Colors.DarkGray
	Panel2.SendToBack

		
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


	delete.top = 33.5%y
	delete.left = 90%x
	delete.width = 5%x
	delete.height = 3%y

	sv.Initialize(Me, "sv")
	sv.AddToParent(Activity, 3%x, 33%y,94%x ,57.5%y)

	If FirstTime Then
		Dim cities As List
		cities = File.ReadList(File.DirAssets, "uns.txt")
		index = sv.SetItems(cities)
	Else
		sv.SetIndex(index)
	End If
	

End Sub



Sub sv_ItemClick(Value As String)
	ToastMessageShow(Value, True)
	
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	Activity.Finish
End Sub
Sub ili_Click
	StartActivity("ilika")
End Sub
Sub ousia_Click
	StartActivity("ousies")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("listaousies")
End Sub

Sub katigor_Click
	StartActivity("katigoriess")
End Sub
Sub gpss_Click
	
	StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
End Sub
Sub listabel_Click
	StartActivity("listaousies")
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
End Sub
Sub ililabel_Click
	StartActivity("ilika")
End Sub

Sub simansi_Click
	StartActivity("Main")
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
      
		Activity.Finish
	End If
End Sub


Sub delete_Click
	sv.ClearSearchBox
	StartActivity("searchUn")
	
End Sub