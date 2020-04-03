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

 
clv2.AddTextItem("2201	Κατηγορία 2	Το πρωτοξείδιο  αζώτου , κατεψυγμένου υγρού	     ", "")
clv2.AddTextItem("2202	Κατηγορία 2	Υδροσελήνιο , άνυδρο	     ", "")
clv2.AddTextItem("2203	Κατηγορία 2	Σιλάνιο , συμπιεσμένο	     ", "")
clv2.AddTextItem("2204	Κατηγορία 2	Καρβονυλοσουλφιδίου	     ", "")
clv2.AddTextItem("2205	Κατηγορία 6.1	Αδιπονιτριλίου	     ", "")
clv2.AddTextItem("2206	Κατηγορία 6.1	Ισοκυανικά , τοξικά, ε.α.ο. ή Ισοκυανικού λύσεις, τοξικά, ε.α.ο. σημείο ανάφλεξης πάνω από 61 ° C και σημείο βρασμού μικρότερο από 300 ° C	     ", "")
clv2.AddTextItem("2208	Κατηγορία 5.1	Υποχλωριώδες ασβέστιο μείγματα, ξηρό, με περισσότερο από  10 τοις εκατό αλλά όχι περισσότερο από 39 τοις εκατό διαθέσιμο χλώριο	     ", "")
clv2.AddTextItem("2209	Κατηγορία 8	Φορμαλδεΰδη , διαλύματα, με όχι λιγότερο από 25 τοις εκατό φορμαλδεΰδης	     ", "")
clv2.AddTextItem("2210	Κατηγορία 4.2	Maneb ή παρασκευάσματα Maneb με όχι λιγότερο από 60 τοις εκατό maneb	     ", "")
clv2.AddTextItem("2211	Κατηγορία 9	Πολυμερικά σφαιρίδια, επεκτάσιμα, που παράγουν εύφλεκτο ατμό	     ", "")
clv2.AddTextItem("2212	Κατηγορία 9	Μπλε αμιάντου ( κροκιδόλιθος ) ή καφέ αμίαντος ( αμοσίτης , mysorite )	     ", "")
clv2.AddTextItem("2213	Κατηγορία 4.1	Παραφορμαλδεϋδη	     ", "")
clv2.AddTextItem("2214	Κατηγορία 8	Φθαλικού ανυδρίτη με περισσότερα από 0,05 τοις εκατό μηλεϊνικού ανυδρίτη	     ", "")
clv2.AddTextItem("2215	Κατηγορία 8	Μηλεϊνικού ανυδρίτη	     ", "")
clv2.AddTextItem("2216	Κατηγορία 9	Ιχθυάλευρα , σταθεροποιημένα ή ψάρια θραύσματα, σταθεροποιημένο	     ", "")
clv2.AddTextItem("2217	Κατηγορία 4.2	Κέικ σπόρου με όχι περισσότερο από Κατηγορία 1,Κατηγορία 5 τοις εκατό  πετρελαίου και όχι περισσότερο από 11 τοις εκατό υγρασία	     ", "")
clv2.AddTextItem("2218	Κατηγορία 8	Ακρυλικό οξύ , αναστέλλεται	     ", "")
clv2.AddTextItem("2219	Κατηγορία 3	Αλλυλ γλυκιδυλαιθέρα	     ", "")
clv2.AddTextItem("2222	Κατηγορία 3	Ανισόλη	     ", "")
clv2.AddTextItem("2224	Κατηγορία 6.1	Βενζονιτρίλιο	     ", "")
clv2.AddTextItem("2225	Κατηγορία 8	Βενζολοσουλφονυλοχλωρίδιο	     ", "")
clv2.AddTextItem("2226	Κατηγορία 8	Βενζοτριχλωρίδιο	     ", "")
clv2.AddTextItem("2227	Κατηγορία 3	η-βουτυλο μεθακρυλικό     ", "")
clv2.AddTextItem("2232	Κατηγορία 6.1	Κατηγορία 2-Chloroethanal	     ", "")
clv2.AddTextItem("2233	Κατηγορία 6.1	Chloroanisidines	     ", "")
clv2.AddTextItem("2234	Κατηγορία 3	Chlorobenzotrifluorides	     ", "")
clv2.AddTextItem("2235	Κατηγορία 6.1	Χλωροβενζυλ χλωριούχα , υγρό	     ", "")
clv2.AddTextItem("2236	Κατηγορία 6.1	Κατηγορία 3-χλωρο-Κατηγορία 4-μεθυλφαινυλ ισοκυανικό	     ", "")
clv2.AddTextItem("2237	Κατηγορία 6.1	Chloronitroanilines	     ", "")
clv2.AddTextItem("2238	Κατηγορία 3	Chlorotoluenes	     ", "")
clv2.AddTextItem("2239	Κατηγορία 6.1	Chlorotoluidines , στερεά	     ", "")
clv2.AddTextItem("2240	Κατηγορία 8	Χρωμοθειϊκό οξύ	     ", "")
clv2.AddTextItem("2241	Κατηγορία 3	Κυκλοεπτανε	     ", "")
clv2.AddTextItem("2242	Κατηγορία 3	Κυκλοεπτένιο	     ", "")
clv2.AddTextItem("2243	Κατηγορία 3	Οξικό κυκλοεξύλιο	     ", "")  
clv2.AddTextItem("2244	Κατηγορία 3	Κυκλοπεντανόλη	     ", "")
clv2.AddTextItem("2245	Κατηγορία 3	Κυκλοπεντανόνη	     ", "")
clv2.AddTextItem("2246	Κατηγορία 3	Κυκλοπεντενε	     ", "")
clv2.AddTextItem("2247	Κατηγορία 3	κ-δεκανίου	     ", "")
clv2.AddTextItem("2248	Κατηγορία 8	Δι-κ-βουτυλαμίνη	     ", "")
clv2.AddTextItem("2249	Κατηγορία 6.1	Διχλωροδιμεθυλ αιθέρα , συμμετρική	     ", "")
clv2.AddTextItem("2250	Κατηγορία 6.1	Διχλωροφαινυλο ισοκυανικά	     ", "")
clv2.AddTextItem("2252	Κατηγορία 3	Κατηγορία 1,Κατηγορία 2-διμεθοξυαιθάνιο	  ", "")   
clv2.AddTextItem("2253	Κατηγορία 6.1	Ν, Ν-διμεθυλανιλίνη	     ", "")
clv2.AddTextItem("2256	Κατηγορία 3	Κυκλοεξένιο	     ", "")
clv2.AddTextItem("2257	Κατηγορία 4.3	Κάλιο	     ", "")
clv2.AddTextItem("2258	Κατηγορία 8	Κατηγορία 1,Κατηγορία 2-προπυλενοδιαμίνη	  ", "")  
clv2.AddTextItem("2259	Κατηγορία 8	Τριαιθυλενετετραμίνη	     ", "")
clv2.AddTextItem("2260	Κατηγορία 3	Τριπροπυλαμίνη	     ", "")
clv2.AddTextItem("2261	Κατηγορία 6.1	Ξυλενόλες	     ", "")
clv2.AddTextItem("2262	Κατηγορία 8	Διμεθυλοκαρβαμοϋλο χλωρίδιο	     ", "")
clv2.AddTextItem("2263	Κατηγορία 3	Dimethylcyclohexanes	     ", "")
clv2.AddTextItem("2264	Κατηγορία 8	Διμεθυλοκυκλοεξυλαμίνης	     ", "")
clv2.AddTextItem("2265	Κατηγορία 3	Ν, Ν-διμεθυλοφορμαμίδιο	     ", "")
clv2.AddTextItem("2266	Κατηγορία 3	Διμεθυλο-Ν-προπυλαμίνη	     ", "")
clv2.AddTextItem("2267	Κατηγορία 6.1	Διμεθυλο χλωριούχο θειοφωσφορυλ	     ", "")
clv2.AddTextItem("2269	Κατηγορία 8	Κατηγορία 3,3'-Iminodipropylamine	     ", "")
clv2.AddTextItem("2270	Κατηγορία 3	Αιθυλαμίνη , υδατικό διάλυμα με όχι λιγότερο από 50 τοις εκατό	  ", "")   
clv2.AddTextItem("2271	Κατηγορία 3	Αιθυλ αμυλ κετόνη	     ", "")
clv2.AddTextItem("2272	Κατηγορία 6.1	Ν-Αιθυλανιλίνη	     ", "")
clv2.AddTextItem("2273	Κατηγορία 6.1	Κατηγορία 2-αιθυλο-ανιλίνη	     ", "")
clv2.AddTextItem("2274	Κατηγορία 6.1	Ν-αιθυλ-Ν-βενζυλανιλίνη	     ", "")
clv2.AddTextItem("2275	Κατηγορία 3	Κατηγορία 2-αιθυλβουτανόλη	     ", "")
clv2.AddTextItem("2276	Κατηγορία 3	Κατηγορία 2-αιθυλεξυλαμίνη	     ", "")
clv2.AddTextItem("2277	Κατηγορία 3	Μεθακρυλικό αιθύλιο	     ", "")
clv2.AddTextItem("2278	Κατηγορία 3	κ-επτάνιο	     ", "")
clv2.AddTextItem("2279	Κατηγορία 6.1	Εξαχλωροβουταδιένιο	     ", "")
clv2.AddTextItem("2280	Κατηγορία 8	Εξαμεθυλενοδιαμίνη , στερεά	     ", "")
clv2.AddTextItem("2281	Κατηγορία 6.1	Διισοκυανικό εξαμεθυλένιο	     ", "")
clv2.AddTextItem("2282	Κατηγορία 3	Εξανόλες	     ", "")
clv2.AddTextItem("2283	Κατηγορία 3	Ισοβουτυλ μεθακρυλικό 	     ", "")
clv2.AddTextItem("2284	Κατηγορία 3	Ισοβουτυρονιτρίλιο	   AIsocyanatobenzotrifluorides	     ", "")
clv2.AddTextItem("2286	Κατηγορία 3	Pentamethylheptane	     ", "")
clv2.AddTextItem("2287	Κατηγορία 3	Isoheptenes	     ", "")
clv2.AddTextItem("2288	Κατηγορία 3	Isohexenes	     ", "")
clv2.AddTextItem("2289	Κατηγορία 8	Ισοφορονδιαμίνη	     ", "")
clv2.AddTextItem("2290	Κατηγορία 6.1	Διισοκυανική ισοφορόνη	     ", "")
clv2.AddTextItem("2291	Κατηγορία 6.1	Μόλυβδος ενώσεις, διαλυτές, ε.α.ο.	     ", "")
clv2.AddTextItem("2293	Κατηγορία 3	Κατηγορία 4-μεθοξυ-Κατηγορία 4-μεθυλπενταν-Κατηγορία 2-όνη  ", "")	   
clv2.AddTextItem("2294	Κατηγορία 6.1	Ν-μεθυλανιλίνη	     ", "")
clv2.AddTextItem("2296	Κατηγορία 3	Μεθυλκυκλοεξάνιο	     ", "")
clv2.AddTextItem("2297	Κατηγορία 3	Μεθυλοκυκλοεξανόνη	     ", "")
clv2.AddTextItem("2298	Κατηγορία 3	Μεθυλοκυκλοπεντανίου	     ", "")
clv2.AddTextItem("2299	Κατηγορία 6.1	Μεθυλ διχλωροξικό	   " ,"")
   clv2.AddTextItem("2300	Κατηγορία 6.1	Κατηγορία 2-μεθυλ-Κατηγορία 5-αιθυλοπυριδίνης" ,"")

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

