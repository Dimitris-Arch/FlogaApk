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
	Activity.LoadLayout("adr.bal")
 
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


	
	

	
	
	
	
  
  
clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.Height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray

 
clv2.AddTextItem("3501	Κατηγορία 2.1	Χημική υπό πίεση, εύφλεκτα , μη προδιαγραφόμενα άλλως	   " ,"")
clv2.AddTextItem("3502	Κατηγορία 2.2	Χημικά υπό πίεση, τοξικά , δεν ορίζεται διαφορετικά	   " ,"")
clv2.AddTextItem("3503	Κατηγορία 2.2	Χημική υπό πίεση, διαβρωτικά , μη προδιαγραφόμενα άλλως	   " ,"")
clv2.AddTextItem("3504	Κατηγορία 2.1	Χημική υπό πίεση, εύφλεκτα, τοξικά, μη προδιαγραφόμενα άλλως	   " ,"")
clv2.AddTextItem("3505	Κατηγορία 2.1	Χημική υπό πίεση, εύφλεκτα, διαβρωτικά, μη προδιαγραφόμενα άλλως	   " ,"")
clv2.AddTextItem("3506	Κατηγορία 8	Ο υδράργυρος που περιέχεται σε βιομηχανικά είδη	   " ,"")
clv2.AddTextItem("3507	Κατηγορία 8	Εξαφθοριούχο ουράνιο,Ραδιενεργό   " ,"")
clv2.AddTextItem("3508	Κατηγορία 9	Πυκνωτής 	   " ,"")
clv2.AddTextItem("3509	Κατηγορία 9	Συσκευασία , απορρίπτονται, κενά, ακαθάριστα προτεινόμενη είσοδος	   " ,"")
clv2.AddTextItem("3510	Κατηγορία 2.1	Το απορροφημένο αέριο , εύφλεκτο, δεν ορίζεται διαφορετικά προτεινόμενη είσοδος	" ,"")   
clv2.AddTextItem("3511	Κατηγορία 2.2	Το απορροφημένο αέριο, δεν ορίζεται διαφορετικά προτεινόμενη είσοδος	   " ,"")
clv2.AddTextItem("3512	Κατηγορία 2.3	Το απορροφημένο αέριο, τοξικό, μη προδιαγραφόμενα άλλως	   " ,"")
clv2.AddTextItem("3513	Κατηγορία 2.2	Το απορροφημένο αέριο, οξειδωτικά , μη προδιαγραφόμενα άλλως	   " ,"")
clv2.AddTextItem("3514	Κατηγορία 2.3	Το απορροφημένο αέριο, τοξικά, εύφλεκτα, μη προδιαγραφόμενα άλλως	   " ,"")
clv2.AddTextItem("3515	Κατηγορία 2.3	Το απορροφημένο αέριο, τοξικά, εύφλεκτα, διαβρωτικά, μη προδιαγραφόμενα άλλως	   " ,"")
clv2.AddTextItem("3516	Κατηγορία 2.3	Το απορροφημένο αέριο, τοξικά, οξειδωτικά, μη προδιαγραφόμενα άλλως	   " ,"")
clv2.AddTextItem("3517	Κατηγορία 2.3	Το απορροφημένο αέριο, τοξικά, οξειδωτικά, διαβρωτικά, μη προδιαγραφόμενα άλλως	  " ,"") 
clv2.AddTextItem("3518	Κατηγορία 2.3	Το απορροφημένο αέριο, τοξικά, διαβρωτικά, μη προδιαγραφόμενα άλλως	" ,"")

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
