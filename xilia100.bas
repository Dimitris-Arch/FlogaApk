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


 
	
	clv2.AddTextItem("1001	ΚΑΤΗΓΟΡΙΑ 2	Ακετυλένιο , διαλυμένο	" ,"")   
clv2.AddTextItem("1002	ΚΑΤΗΓΟΡΙΑ 2	Air , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1003	ΚΑΤΗΓΟΡΙΑ 2	Air, κατεψυγμένο,κρυογονικο υγρό χωρίς πίεση	" ,"")   
clv2.AddTextItem("1005	ΚΑΤΗΓΟΡΙΑ 2	Αμμωνία , άνυδρο	   " ,"")
clv2.AddTextItem("1006	ΚΑΤΗΓΟΡΙΑ 2	Αργόν , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1008	ΚΑΤΗΓΟΡΙΑ 2	Τριφθοριούχο βόριο , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1009	ΚΑΤΗΓΟΡΙΑ 2	Βρωμοτρίφθορομεθάνιο ή ψυκτικό αέριο, Ε 13B1	 " ,"") 
clv2.AddTextItem("1010	ΚΑΤΗΓΟΡΙΑ 2	Βουταδιένια , αναστέλλεται	   " ,"")
clv2.AddTextItem("1011	ΚΑΤΗΓΟΡΙΑ 2	Βουτάνιο Δείτε επίσης αέρια πετρελαίου, υγροποιημένα	" ,"")   
clv2.AddTextItem("1012	ΚΑΤΗΓΟΡΙΑ 2	Βουτυλένιο δείτε επίσης αέρια πετρελαίου, υγροποιημένα" ,"")	   
clv2.AddTextItem("1013	ΚΑΤΗΓΟΡΙΑ 2	Διοξείδιο  άνθρακα	   " ,"")
clv2.AddTextItem("1014	ΚΑΤΗΓΟΡΙΑ 2 Διοξείδιο  άνθρακα και οξυγόνο μείγματα, συμπιεσμένο" ,"")	   
clv2.AddTextItem("1015	ΚΑΤΗΓΟΡΙΑ 2	Διοξείδιο  άνθρακα και μίγματα υποξείδιο  αζώτου	   " ,"")
clv2.AddTextItem("1016	ΚΑΤΗΓΟΡΙΑ 2	Μονοξείδιο  άνθρακα , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1017	ΚΑΤΗΓΟΡΙΑ 2	Χλώριο	   " ,"")
clv2.AddTextItem("1018	ΚΑΤΗΓΟΡΙΑ 2	Χλωροδιφθορομεθάνιο ή ψυκτικό αέριο R 22	" ,"")   
clv2.AddTextItem("1020	ΚΑΤΗΓΟΡΙΑ 2	Χλωροπενταφθοροαιθανίου ή ψυκτικό αέριο R 115	   " ,"")
clv2.AddTextItem("1021	ΚΑΤΗΓΟΡΙΑ 2	χλωρο-τετραφθοροαιθάνιο ή το ψυκτικό αέριο R 124" ,"")	   
clv2.AddTextItem("1022	ΚΑΤΗΓΟΡΙΑ 2	Χλωροτριφθορομεθάνιο ή ψυκτικό αέριο R 13	" ,"")   
clv2.AddTextItem("1023	ΚΑΤΗΓΟΡΙΑ 2	Ατμός , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1026	ΚΑΤΗΓΟΡΙΑ 2	Κυανογόνο	   " ,"")
clv2.AddTextItem("1027	ΚΑΤΗΓΟΡΙΑ 2	Κυκλοπροπανιοκαρβοξυλικό	   " ,"")
clv2.AddTextItem("1028	ΚΑΤΗΓΟΡΙΑ 2	Διχλωροδιφθοριομεθάνιο ή ψυκτικό αέριο R 12	   " ,"")
clv2.AddTextItem("1029	ΚΑΤΗΓΟΡΙΑ 2	Διχλωροφθορομεθάνιο ή ψυκτικό αέριο R 21	" ,"")   
clv2.AddTextItem("1030	ΚΑΤΗΓΟΡΙΑ 2	Διφθοροαιθανίο ή ψυκτικό αέριο R 152a	   " ,"")
clv2.AddTextItem("1032	ΚΑΤΗΓΟΡΙΑ 2	Διμεθυλαμίνη , άνυδρο	   " ,"")
clv2.AddTextItem("1033	ΚΑΤΗΓΟΡΙΑ 2	Διμεθυλαιθήρας	   " ,"")
clv2.AddTextItem("1035	ΚΑΤΗΓΟΡΙΑ 2	Αιθάνιο	   " ,"")
clv2.AddTextItem("1036	ΚΑΤΗΓΟΡΙΑ 2	Αιθυλαμίνη	   " ,"")
clv2.AddTextItem("1037	ΚΑΤΗΓΟΡΙΑ 2	Αιθυλ χλωρίδιο	   " ,"")
clv2.AddTextItem("1038	ΚΑΤΗΓΟΡΙΑ 2	Αιθυλένιο , ψυγείο υγρού κρυογονική υγρό" ,"")	   
clv2.AddTextItem("1039	ΚΑΤΗΓΟΡΙΑ 2	Αιθυλομεθυλο αιθέρα	   " ,"")
clv2.AddTextItem("1040	ΚΑΤΗΓΟΡΙΑ 2	Οξείδιο  αιθυλενίου ή οξείδιο  αιθυλενίου με άζωτο 	   " ,"")
clv2.AddTextItem("1041	ΚΑΤΗΓΟΡΙΑ 2	Μίγματα οξειδίου  αιθυλενίου και διοξειδίου  άνθρακα " ,"")
clv2.AddTextItem("1043	ΚΑΤΗΓΟΡΙΑ 2	Λιπασμάτων λύση αμμωνιοποίηση με ελεύθερη αμμωνία	" ,"")
clv2.AddTextItem("1044	ΚΑΤΗΓΟΡΙΑ 2	Οι πυροσβεστήρες που περιέχουν συμπιεσμένα ή υγροποιημένα αέρια	   " ,"")
clv2.AddTextItem("1045	ΚΑΤΗΓΟΡΙΑ 2	Φθόριο , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1046	ΚΑΤΗΓΟΡΙΑ 2	Ήλιο , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1048	ΚΑΤΗΓΟΡΙΑ 2	Υδροβρώμιο , άνυδρο	   " ,"")
clv2.AddTextItem("1049	ΚΑΤΗΓΟΡΙΑ 2	Υδρογόνο, συμπιεσμένο	   " ,"")
clv2.AddTextItem("1050	ΚΑΤΗΓΟΡΙΑ 2	Υδροχλώριο , άνυδρο	   " ,"")
clv2.AddTextItem("1051	ΚΑΤΗΓΟΡΙΑ 6.1	Υδροκυάνιο , σταθεροποιημένο με λιγότερο από 3 τοις εκατό νερό	" ,"")   
clv2.AddTextItem("1052	ΚΑΤΗΓΟΡΙΑ 8	Υδροφθόριο , άνυδρο	   " ,"")
clv2.AddTextItem("1053	ΚΑΤΗΓΟΡΙΑ 2	Υδρόθειο	   " ,"")
clv2.AddTextItem("1055	ΚΑΤΗΓΟΡΙΑ 2	Ισοβουτυλένιο δείτε επίσης αέρια πετρελαίου, υγροποιημένα	   " ,"")
clv2.AddTextItem("1056	ΚΑΤΗΓΟΡΙΑ 2	Krypton , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1057	ΚΑΤΗΓΟΡΙΑ 2	Αναπτήρες ή τα ανταλλακτικά αναπτήρων τσιγάρων	" ,"")   
clv2.AddTextItem("1058	ΚΑΤΗΓΟΡΙΑ 2	Υγροποιημένα αέρια, μη εύφλεκτο	   " ,"")
clv2.AddTextItem("1060	ΚΑΤΗΓΟΡΙΑ 2	Μεθυλακετυλένιο και προπαδιένιο μίγματα, σταθεροποιημένα	   " ,"")
clv2.AddTextItem("1061	ΚΑΤΗΓΟΡΙΑ 2	Μεθυλαμίνη , άνυδρη	   " ,"")
clv2.AddTextItem("1062	ΚΑΤΗΓΟΡΙΑ 2	Το βρωμιούχο μεθύλιο	   " ,"")
clv2.AddTextItem("1063	ΚΑΤΗΓΟΡΙΑ 2	Χλωριούχο μεθύλιο , ή ψυκτικό αέριο R 40	   " ,"")
clv2.AddTextItem("1064	ΚΑΤΗΓΟΡΙΑ 2	Μεθυλ μερκαπτάνης	   " ,"")
clv2.AddTextItem("1065	ΚΑΤΗΓΟΡΙΑ 2	Νέον , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1066	ΚΑΤΗΓΟΡΙΑ 2	Άζωτο , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1067	ΚΑΤΗΓΟΡΙΑ 2	Τετροξείδιο	   " ,"")
clv2.AddTextItem("1069	ΚΑΤΗΓΟΡΙΑ 2	Νιτροζυλοχλωρίδιο χλωριούχο	   " ,"")
clv2.AddTextItem("1070	ΚΑΤΗΓΟΡΙΑ 2	Το πρωτοξείδιο  αζώτου	   " ,"")
clv2.AddTextItem("1071	ΚΑΤΗΓΟΡΙΑ 2	Πετρελαίου εσωτερικής καύσης , συμπιεσμένο" ,"")   
clv2.AddTextItem("1072	ΚΑΤΗΓΟΡΙΑ 2	Οξυγόνο , συμπιεσμένο	   " ,"")
clv2.AddTextItem("1073	ΚΑΤΗΓΟΡΙΑ 2	Οξυγόνου, κατεψυγμένου υγρού κρυογονική υγρό	   " ,"")
clv2.AddTextItem("1075	ΚΑΤΗΓΟΡΙΑ 2	Αέρια πετρελαίου, υγροποιημένο αέριο ή υγραέριο	   " ,"")
clv2.AddTextItem("1076	ΚΑΤΗΓΟΡΙΑ 2	Φωσγένιο	   " ,"")
clv2.AddTextItem("1077	ΚΑΤΗΓΟΡΙΑ 2	Προπυλενίου βλέπε επίσης αέρια πετρελαίου, υγροποιημένα	   " ,"")
clv2.AddTextItem("1078	ΚΑΤΗΓΟΡΙΑ 2	Ψυκτικού αέρια, ε.α.ο.	   " ,"")
clv2.AddTextItem("1079	ΚΑΤΗΓΟΡΙΑ 2	Διοξείδιο  θείου	   " ,"")
clv2.AddTextItem("1080	ΚΑΤΗΓΟΡΙΑ 2	Το εξαφθοριούχο θείο	" ,"")   
clv2.AddTextItem("1081	ΚΑΤΗΓΟΡΙΑ 2	Τετραφθοροαιθυλένιο , αναστέλλεται	 " ,"")  
clv2.AddTextItem("1082	ΚΑΤΗΓΟΡΙΑ 2	Trifluorochloroethylene , αναστέλλεται	   " ,"")
clv2.AddTextItem("1083	ΚΑΤΗΓΟΡΙΑ 2	Τριμεθυλαμίνη , άνυδρη	   " ,"")
clv2.AddTextItem("1085	ΚΑΤΗΓΟΡΙΑ 2	Βινυλοβρωμιδίου , αναστέλλεται	   " ,"")
clv2.AddTextItem("1086	ΚΑΤΗΓΟΡΙΑ 2	Χλωριούχο βινύλιο , αναστέλλεται ή βινυλίου χλωρίδιο   " ,"")
clv2.AddTextItem("1087	ΚΑΤΗΓΟΡΙΑ 2	Βινυλομεθυλαιθέρα , παρεμπόδισε	   " ,"")
clv2.AddTextItem("1088	ΚΑΤΗΓΟΡΙΑ 3	Ακετάλη	   " ,"")
clv2.AddTextItem("1089	ΚΑΤΗΓΟΡΙΑ 3	Η ακεταλδεΰδη	   " ,"")
clv2.AddTextItem("1090	ΚΑΤΗΓΟΡΙΑ 3	Ακετόνη	   " ,"")
clv2.AddTextItem("1091	ΚΑΤΗΓΟΡΙΑ 3	Έλαια ακετόνη	   " ,"")
clv2.AddTextItem("1092	ΚΑΤΗΓΟΡΙΑ 6.1	Ακρολείνη , αναστέλλεται	   " ,"")
clv2.AddTextItem("1093	ΚΑΤΗΓΟΡΙΑ 3	Ακρυλονιτρίλιο , αναστέλλεται	  " ,"")
clv2.AddTextItem("1098	ΚΑΤΗΓΟΡΙΑ 6.1	Αλλυλ αλκοόλη	   " ,"")
 clv2.AddTextItem("1100	ΚΑΤΗΓΟΡΙΑ 3	Αλλυλοχλωρίδιο	 " ,"")
	

	
	
	
	
  
  




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
