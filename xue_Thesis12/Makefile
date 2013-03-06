MAIN = Thesis
GLOBAL = Thesis

all:
	latex 	$(MAIN).tex
	latex 	$(MAIN).tex
	bibtex	$(MAIN)
	latex 	$(MAIN).tex
	dvips -t a4 $(MAIN).dvi -o
	ps2pdf $(MAIN).ps


fast:
	latex 	$(MAIN).tex
	dvips -t a4 $(MAIN).dvi -o


global:
	latex 	$(GLOBAL).tex -no-file-line-error
	latex 	$(GLOBAL).tex -no-file-line-error
	bibtex	$(GLOBAL)
	latex 	$(GLOBAL).tex -no-file-line-error
	dvips -t a4 $(GLOBAL).dvi -o



test:
	evince $(MAIN).pdf

testr:
	kghostview $(MAIN).ps

clean:
	rm -rf *~  *.aux *.log *.bak *.thm *.toc *.out *.idx *.bbl *.blg *.dvi *.ps
