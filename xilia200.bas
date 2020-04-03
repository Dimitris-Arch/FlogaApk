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

 
clv2.AddTextItem("1104	ΚΑΤΗΓΟΡΙΑ 3	Οξικά Αμυλεστέρας	   " ,"")
clv2.AddTextItem("1105	ΚΑΤΗΓΟΡΙΑ 3	Πεντανόλες	   " ,"")
clv2.AddTextItem("1106	ΚΑΤΗΓΟΡΙΑ 3	Amylamines	   " ,"")
clv2.AddTextItem("1107	ΚΑΤΗΓΟΡΙΑ 3	Χλωριούχα Αμυλεστέρας	   " ,"")
clv2.AddTextItem("1108	ΚΑΤΗΓΟΡΙΑ 3	Πεντένιο n αμυλένιο	   " ,"")
clv2.AddTextItem("1109	ΚΑΤΗΓΟΡΙΑ 3	Φορμικά Αμυλεστέρας	   " ,"")
clv2.AddTextItem("1110	ΚΑΤΗΓΟΡΙΑ 3	η-αμυλο μεθυλοκετόνη	   " ,"")
clv2.AddTextItem("1111	ΚΑΤΗΓΟΡΙΑ 3	Μερκαπτάνες Αμυλεστέρας	   " ,"")
clv2.AddTextItem("1112	ΚΑΤΗΓΟΡΙΑ 3	Νιτρικό άλας	   " ,"")
clv2.AddTextItem("1113	ΚΑΤΗΓΟΡΙΑ 3	Νιτρώδη Αμυλεστέρας	   " ,"")
clv2.AddTextItem("1114	ΚΑΤΗΓΟΡΙΑ 3	Βενζόλιο	   " ,"")
clv2.AddTextItem("1120	ΚΑΤΗΓΟΡΙΑ 2	Βουτανόλες	   " ,"")
clv2.AddTextItem("1123	ΚΑΤΗΓΟΡΙΑ 3	Βουτύλιο οξικά	   " ,"")
clv2.AddTextItem("1125	ΚΑΤΗΓΟΡΙΑ 3	κ-βουτυλαμίνη	   " ,"")
clv2.AddTextItem("1126	ΚΑΤΗΓΟΡΙΑ 3	Βρωμοβουτάνιο	   " ,"")
clv2.AddTextItem("1127	ΚΑΤΗΓΟΡΙΑ 3	Chlorobutanes	   " ,"")
clv2.AddTextItem("1128	ΚΑΤΗΓΟΡΙΑ 3	η-Βουτυλο μυρμηκικό	   " ,"")
clv2.AddTextItem("1129	ΚΑΤΗΓΟΡΙΑ 3	Βουτυραλδεϋδη	   " ,"")
clv2.AddTextItem("1130	ΚΑΤΗΓΟΡΙΑ 3	Καμφορέλαιο	   " ,"")
clv2.AddTextItem("1131	ΚΑΤΗΓΟΡΙΑ 3	Διθειάνθρακα	   " ,"")
clv2.AddTextItem("1133	ΚΑΤΗΓΟΡΙΑ 3	Κόλλες , που περιέχει ένα εύφλεκτο υγρό	   " ,"")
clv2.AddTextItem("1134	ΚΑΤΗΓΟΡΙΑ 3	Χλωροβενζένιο	   " ,"")
clv2.AddTextItem("1135	ΚΑΤΗΓΟΡΙΑ 6.1	Αιθυλένιο χλωρυδρίνη	   " ,"")
clv2.AddTextItem("1136	ΚΑΤΗΓΟΡΙΑ 3	Η πίσσα από άνθρακα αποσταγμάτων, εύφλεκτο	   " ,"")
clv2.AddTextItem("1139	ΚΑΤΗΓΟΡΙΑ 3	Διάλυμα επίστρωσης " ,"")
clv2.AddTextItem("1143	ΚΑΤΗΓΟΡΙΑ 6.1	Κροτωναλδεΰδη , σταθεροποιημένο	   " ,"")
clv2.AddTextItem("1144	ΚΑΤΗΓΟΡΙΑ 3	Crotonylene	   " ,"")
clv2.AddTextItem("1145	ΚΑΤΗΓΟΡΙΑ 3	Κυκλοεξάνιο	   " ,"")
clv2.AddTextItem("1146	ΚΑΤΗΓΟΡΙΑ 3	Κυκλοπεντάνιο	   " ,"")
clv2.AddTextItem("1147	ΚΑΤΗΓΟΡΙΑ 3	Δεκαϋδροναφθαλένιο	   " ,"")
clv2.AddTextItem("1148	ΚΑΤΗΓΟΡΙΑ 3	Διακετονοαλκοόλη	   " ,"")
clv2.AddTextItem("1149	ΚΑΤΗΓΟΡΙΑ 3	Αιθέρες διβουτυλο	   " ,"")
clv2.AddTextItem("1150	ΚΑΤΗΓΟΡΙΑ 3	Διχλωροαιθυλένιο	   " ,"")
clv2.AddTextItem("1152	ΚΑΤΗΓΟΡΙΑ 3	Dichloropentanes	   " ,"")
clv2.AddTextItem("1153	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλενο γλυκολο διαιθυλο αιθέρα	" ,"")   
clv2.AddTextItem("1154	ΚΑΤΗΓΟΡΙΑ 3	Διαιθυλαμίνη	   " ,"")
clv2.AddTextItem("1155	ΚΑΤΗΓΟΡΙΑ 3	Διαιθυλ αιθέρας ή Αιθυλαιθέρας	" ,"")   
clv2.AddTextItem("1156	ΚΑΤΗΓΟΡΙΑ 3	Διαιθυλ κετόνη	   " ,"")
clv2.AddTextItem("1157	ΚΑΤΗΓΟΡΙΑ 3	Διισοβουτυλοκετόνη	   " ,"")
clv2.AddTextItem("1158	ΚΑΤΗΓΟΡΙΑ 3	Διισοπροπυλαμίνη	   " ,"")
clv2.AddTextItem("1159	ΚΑΤΗΓΟΡΙΑ 3	Διισοπροπυλαιθέρα	   " ,"")
clv2.AddTextItem("1160	ΚΑΤΗΓΟΡΙΑ 3	Διμεθυλαμίνης διάλυμα	   " ,"")
clv2.AddTextItem("1161	ΚΑΤΗΓΟΡΙΑ 3	Ανθρακικού διμεθυλίου	   " ,"")
clv2.AddTextItem("1162	ΚΑΤΗΓΟΡΙΑ 3	Διμεθυλοδιχλωροσιλάνιο	   " ,"")
clv2.AddTextItem("1163	ΚΑΤΗΓΟΡΙΑ 6.1	Διμεθυλοϋδραζίνη , ασύμμετρη	 " ,"")  
clv2.AddTextItem("1164	ΚΑΤΗΓΟΡΙΑ 3	Διμεθυλοσουλφίδιο	   " ,"")
clv2.AddTextItem("1165	ΚΑΤΗΓΟΡΙΑ 3	Διοξάνιο	   " ,"")
clv2.AddTextItem("1166	ΚΑΤΗΓΟΡΙΑ 3	Διοξολάνη	   " ,"")
clv2.AddTextItem("1167	ΚΑΤΗΓΟΡΙΑ 3	Διβινυλαιθέρα , παρεμπόδισε	   " ,"")
clv2.AddTextItem("1169	ΚΑΤΗΓΟΡΙΑ 3	Εκχυλίσματα, αρωματικό υγρό	   " ,"")
clv2.AddTextItem("1170	ΚΑΤΗΓΟΡΙΑ 3	Αιθανόλη αιθυλική αλκοόλη ή διάλυμα αιθανόλης αιθυλικής αλκοόλης	   " ,"")
clv2.AddTextItem("1171	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλενο γλυκόλης μονοαιθυλ αιθέρας	   " ,"")
clv2.AddTextItem("1172	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλενογλυκόλης οξικό μονοαιθυλ αιθέρας	   " ,"")
clv2.AddTextItem("1173	ΚΑΤΗΓΟΡΙΑ 3	Οξικό αιθυλεστέρα	   " ,"")
clv2.AddTextItem("1175	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλβενζένιο	   " ,"")
clv2.AddTextItem("1176	ΚΑΤΗΓΟΡΙΑ 3	Ethyl βορικό	   " ,"")
clv2.AddTextItem("1177	ΚΑΤΗΓΟΡΙΑ 3	Οξικό αιθυλβουτυλιο		" ,"")   
clv2.AddTextItem("1178	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλοβουτυραλδεϋδη	 " ,"")  
clv2.AddTextItem("1179	ΚΑΤΗΓΟΡΙΑ 3	Αιθύλιο βουτυλαιθέρα	" ,"")   
clv2.AddTextItem("1180	ΚΑΤΗΓΟΡΙΑ 3	Βουτυρικός αιθυλεστέρας	 " ,"")  
clv2.AddTextItem("1181	ΚΑΤΗΓΟΡΙΑ 6.1	Ethyl χλωροακετικό	   " ,"")
clv2.AddTextItem("1182	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροφορμικό αιθύλιο	   " ,"")
clv2.AddTextItem("1184	ΚΑΤΗΓΟΡΙΑ 3	Διχλωριούχο αιθυλένιο	   " ,"")
clv2.AddTextItem("1185	ΚΑΤΗΓΟΡΙΑ 6.1	Εθυλενιμίνη , αναστέλλεται	   " ,"")
clv2.AddTextItem("1188	ΚΑΤΗΓΟΡΙΑ 3	Μονομεθυλ αιθέρα αιθυλενογλυκόλης	   " ,"")
clv2.AddTextItem("1189	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλενογλυκόλη μονομεθυλ αιθέρας οξικής	" ,"")   
clv2.AddTextItem("1190	ΚΑΤΗΓΟΡΙΑ 3	Μυρμηκικός αιθυλεστέρας	   " ,"")
clv2.AddTextItem("1191	ΚΑΤΗΓΟΡΙΑ 3	Οκτυλική αλδεΰδες	   " ,"")
clv2.AddTextItem("1192	ΚΑΤΗΓΟΡΙΑ 3	Γαλακτικό αιθύλιο	   " ,"")
clv2.AddTextItem("1193	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλ μεθυλ κετόνη ή μεθυλ-αιθυλο-κετόνη" ,"")	   
clv2.AddTextItem("1194	ΚΑΤΗΓΟΡΙΑ 3	Ethyl νιτρικό λύσεις	   " ,"")
clv2.AddTextItem("1195	ΚΑΤΗΓΟΡΙΑ 3	Ethyl προπιονικό	   " ,"")
clv2.AddTextItem("1196	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλοτριχλωροσιλάνιο	   " ,"")
clv2.AddTextItem("1197	ΚΑΤΗΓΟΡΙΑ 3	Εκχυλίσματα, αρωματικά, υγρά	   " ,"")
clv2.AddTextItem("1198	ΚΑΤΗΓΟΡΙΑ 3	Φορμαλδεΰδη , διαλύματα, εύφλεκτο	   " ,"")
clv2.AddTextItem("1199	ΚΑΤΗΓΟΡΙΑ 6.1	Φουραλδευδες	 " ,"")

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

