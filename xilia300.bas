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

 
clv2.AddTextItem("1201	ΚΑΤΗΓΟΡΙΑ 4	Ζυμέλαια	" ,"")
clv2.AddTextItem("1202	ΚΑΤΗΓΟΡΙΑ 3	Το πετρέλαιο εσωτερικής καύσης ή ντίζελ ή πετρέλαιο θέρμανσης" ,"")
clv2.AddTextItem("1203	ΚΑΤΗΓΟΡΙΑ 3	Βενζίνη" ,"")
clv2.AddTextItem("1204	ΚΑΤΗΓΟΡΙΑ 3	Νιτρογλυκερίνη με όχι περισσότερες από 1 τοις εκατό νιτρογλυκερίνη" ,"")	   
clv2.AddTextItem("1206	ΚΑΤΗΓΟΡΙΑ 3	Επτάνια	   " ,"")
clv2.AddTextItem("1207	ΚΑΤΗΓΟΡΙΑ 3	Εξαλδεΰδη	   " ,"")
clv2.AddTextItem("1208	ΚΑΤΗΓΟΡΙΑ 3	Εξανίων	   " ,"")
clv2.AddTextItem("1212	ΚΑΤΗΓΟΡΙΑ 3	Ισοβουτανόλη ή ισοβουτυλικής αλκοόλης	   " ,"")
clv2.AddTextItem("1213	ΚΑΤΗΓΟΡΙΑ 3	Οξικό Ισοβουτυλ	   " ,"")
clv2.AddTextItem("1214	ΚΑΤΗΓΟΡΙΑ 3	Ισοβουτυλαμίνη	   " ,"")
clv2.AddTextItem("1216	ΚΑΤΗΓΟΡΙΑ 3	Isooctenes	   " ,"")
clv2.AddTextItem("1218	ΚΑΤΗΓΟΡΙΑ 3	Ισοπρένιο , αναστέλλεται	   " ,"")
clv2.AddTextItem("1219	ΚΑΤΗΓΟΡΙΑ 3	Ισοπροπανόλη ή ισοπροπυλική αλκοόλη	   " ,"")
clv2.AddTextItem("1220	ΚΑΤΗΓΟΡΙΑ 3	Οξικό ισοπροπυλεστέρα	   " ,"")
clv2.AddTextItem("1221	ΚΑΤΗΓΟΡΙΑ 3	Ισοπροπυλαμίνη	   " ,"")
clv2.AddTextItem("1222	ΚΑΤΗΓΟΡΙΑ 3	Νιτρικό Ισοπροπυλική	   " ,"")
clv2.AddTextItem("1223	ΚΑΤΗΓΟΡΙΑ 3	Πετρέλαιο	   " ,"")
clv2.AddTextItem("1224	ΚΑΤΗΓΟΡΙΑ 3	Κετόνες , υγρό, nos	   " ,"")
clv2.AddTextItem("1228	ΚΑΤΗΓΟΡΙΑ 3	Μερκαπτάνες 	   " ,"")
clv2.AddTextItem("1229	ΚΑΤΗΓΟΡΙΑ 3	Μεσιτυλοξείδιο	   " ,"")
clv2.AddTextItem("1230	ΚΑΤΗΓΟΡΙΑ 3	Μεθανόλη	   " ,"")
clv2.AddTextItem("1231	ΚΑΤΗΓΟΡΙΑ 3	Οξικός μεθυλεστέρας	   " ,"")
clv2.AddTextItem("1233	ΚΑΤΗΓΟΡΙΑ 3	Οξικό μεθυλαμυλο	   " ,"")
clv2.AddTextItem("1234	ΚΑΤΗΓΟΡΙΑ 3	Μεθυλάλη	   " ,"")
clv2.AddTextItem("1235	ΚΑΤΗΓΟΡΙΑ 3	Μεθυλαμίνη , υδατικό διάλυμα	   " ,"")
clv2.AddTextItem("1237	ΚΑΤΗΓΟΡΙΑ 3	Βουτυρικού μεθυλεστέρα	   " ,"")
clv2.AddTextItem("1238	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωρομυρμηκικό μεθυλεστέρα	   " ,"")
clv2.AddTextItem("1239	ΚΑΤΗΓΟΡΙΑ 6.1	Μεθυλ χλωρομεθυλαιθέρας	   " ,"")
clv2.AddTextItem("1242	ΚΑΤΗΓΟΡΙΑ 4	Μεθυλοδιχλωροσιλανίου	   " ,"")
clv2.AddTextItem("1243	ΚΑΤΗΓΟΡΙΑ 3	Μυρμηκικό μεθυλεστέρα	   " ,"")
clv2.AddTextItem("1244	ΚΑΤΗΓΟΡΙΑ 6.1	Μεθυλοϋδραζίνη	   " ,"")
clv2.AddTextItem("1245	ΚΑΤΗΓΟΡΙΑ 3	Μεθυλισοβουτυλοκετόνη	   " ,"")
clv2.AddTextItem("1246	ΚΑΤΗΓΟΡΙΑ 3	Μεθυλο ισοπροπενυλεστέρα κετόνη  " ,"")
clv2.AddTextItem("1247	ΚΑΤΗΓΟΡΙΑ 3	Μεθυλο μεθακρυλικό μονομερές" ,"")	   
clv2.AddTextItem("1248	ΚΑΤΗΓΟΡΙΑ 3	Προπιονικό μεθύλιο	   " ,"")
clv2.AddTextItem("1249	ΚΑΤΗΓΟΡΙΑ 3	Μεθυλ προπυλ κετόνη	" ,"")   
clv2.AddTextItem("1250	ΚΑΤΗΓΟΡΙΑ 3	Μεθυλοτριχλωροσιλάνιο	   " ,"")
clv2.AddTextItem("1251	ΚΑΤΗΓΟΡΙΑ 6.1	Μεθυλ βινυλ κετόνη , σταθεροποιημένα	   " ,"")
clv2.AddTextItem("1259	ΚΑΤΗΓΟΡΙΑ 6.1	Νικέλιο καρβονύλιο	   " ,"")
clv2.AddTextItem("1261	ΚΑΤΗΓΟΡΙΑ 3	Νιτρομεθάνιο	   " ,"")
clv2.AddTextItem("1262	ΚΑΤΗΓΟΡΙΑ 3	Οκτάνια	   " ,"")
clv2.AddTextItem("1263	ΚΑΤΗΓΟΡΙΑ 3	Λάκα, σμάλτο, λεκές,shellac,βερνίκι,λούστρο   " ,"")
clv2.AddTextItem("1264	ΚΑΤΗΓΟΡΙΑ 3	Παραλδεΰδη	   " ,"")
clv2.AddTextItem("1265	ΚΑΤΗΓΟΡΙΑ 3	Πεντάνια	   " ,"")
clv2.AddTextItem("1266	ΚΑΤΗΓΟΡΙΑ 3	Προϊόντα αρωματοποιίας με εύφλεκτα διαλυτικά	" ,"")   
clv2.AddTextItem("1267	ΚΑΤΗΓΟΡΙΑ 3	Πετρέλαιο αργού πετρελαίου	   " ,"")
clv2.AddTextItem("1268	ΚΑΤΗΓΟΡΙΑ 3	Αποστάγματα πετρελαίου,  ή προϊόντα πετρελαίου, 	   " ,"")
clv2.AddTextItem("1270	ΚΑΤΗΓΟΡΙΑ 3	Bενζίνη / ντίζελ / κηροζίνη / τολουολο κ.λπ.	" ,"")   
clv2.AddTextItem("1271	ΚΑΤΗΓΟΡΙΑ 3	Πρώην πνεύμα πετρελαίου	   " ,"")
clv2.AddTextItem("1272	ΚΑΤΗΓΟΡΙΑ 3	Το έλαιο πεύκου	   " ,"")
clv2.AddTextItem("1210	ΚΑΤΗΓΟΡΙΑ 3	Το μελάνι εκτύπωσης , εύφλεκτο	" ,"")   
clv2.AddTextItem("1274	ΚΑΤΗΓΟΡΙΑ 3	Προπανόλη ή προπυλική αλκοόλη, η κανονική	   " ,"")
clv2.AddTextItem("1275	ΚΑΤΗΓΟΡΙΑ 3	Προπιοναλδεΰδη	   " ,"")
clv2.AddTextItem("1276	ΚΑΤΗΓΟΡΙΑ 3	Oξικό η-Προπυλ	   " ,"")
clv2.AddTextItem("1277	ΚΑΤΗΓΟΡΙΑ 3	Προπυλαμίνη	   " ,"")
clv2.AddTextItem("1278	ΚΑΤΗΓΟΡΙΑ 3	Προπυλο χλωρίδιο	   " ,"")
clv2.AddTextItem("1279	ΚΑΤΗΓΟΡΙΑ 3	Διχλωροπροπάνιο	   " ,"")
clv2.AddTextItem("1280	ΚΑΤΗΓΟΡΙΑ 3	Οξείδιο προπυλενίου	" ,"") 
clv2.AddTextItem("1281	ΚΑΤΗΓΟΡΙΑ 3	Propyl φορμικά	   " ,"")
clv2.AddTextItem("1282	ΚΑΤΗΓΟΡΙΑ 3	Πυριδινο	   " ,"")
clv2.AddTextItem("1286	ΚΑΤΗΓΟΡΙΑ 3	Ρητινέλαια	   " ,"")
clv2.AddTextItem("1287	ΚΑΤΗΓΟΡΙΑ 3	Καουτσούκ λύση	   " ,"")
clv2.AddTextItem("1288	ΚΑΤΗΓΟΡΙΑ 3	Το πετρέλαιο σχιστολίθου	   " ,"")
clv2.AddTextItem("1289	ΚΑΤΗΓΟΡΙΑ 3	Μεθυλικό νάτριο λύσεις σε αλκοόλ	" ,"")   
clv2.AddTextItem("1292	ΚΑΤΗΓΟΡΙΑ 3	Πυριτικού τετρααιθυλεστέρος	   " ,"")
clv2.AddTextItem("1293	ΚΑΤΗΓΟΡΙΑ 3	Βάμματα , φαρμακευτικά	   " ,"")
clv2.AddTextItem("1294	ΚΑΤΗΓΟΡΙΑ 3	Τολουόλιο	   " ,"")
clv2.AddTextItem("1295	ΚΑΤΗΓΟΡΙΑ 4.3	Τριχλωροσιλανίου	   " ,"")
clv2.AddTextItem("1296	ΚΑΤΗΓΟΡΙΑ 3	Τριαιθυλαμίνη	   " ,"")
clv2.AddTextItem("1297	ΚΑΤΗΓΟΡΙΑ 3	Τριμεθυλαμίνη , υδατικά διαλύματα με όχι περισσότερο από 50 τοις εκατό κατά μάζα τριμεθυλαμίνης	" ,"")   
clv2.AddTextItem("1298	ΚΑΤΗΓΟΡΙΑ 3	Τριμεθυλχλωροσιλανίου	   " ,"")
clv2.AddTextItem("1299	ΚΑΤΗΓΟΡΙΑ 3	Νέφτι	   " ,"")
 clv2.AddTextItem("1300	ΚΑΤΗΓΟΡΙΑ 3	Τερεβιθίνη υποκατάστατο ή ορυκτό νέφτι Αυστραλία" ,"")	

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
