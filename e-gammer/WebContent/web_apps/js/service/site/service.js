angular.module("egammer").factory("serviceAPI",  serviceAPI);

	function serviceAPI() {

		var games = [{
				"id": 0,
				"titulo": "Need for Speed Rivals",
				"preco": "39,89",
				"capa": "/e-gammer/web_apps/images/site/capa/nfs-rivals-capa.jpg",
				"descricao": "A rivalidade entre policias e corredores apaga a linha que separa a experiência para um jogador da experiência multijogador. Entre sem dificuldades em um mundo onde seus amigos já disputam corridas e perseguições. Esqueça os modos de jogo isolados. Sem salas de espera. Você e seus amigos compartilham as corridas e as experiências."
			},
			{
				"id": 1,
				"titulo": "Mortal Kombat X",
				"preco": "129,89",
				"capa": "/e-gammer/web_apps/images/site/capa/mortal-kombat-x-capa.jpg",
				"descricao": "Mortal Kombat X é o próximo capítulo da esperada, lendária e aclamada franquia de jogos de luta da NetherRealm Studios, marcando a estreia da icônica série na nova geração. O jogo combina apresentação cinematográfica com jogabilidade inédita, oferecendo a mais brutal experiência de combate de todos os tempos, trazendo uma nova experiência completamente conectada que arremessa jogadores em uma competição online persistente, na qual toda luta conta na batalha global pela supremacia."
			},{
				"id": 2,
				"titulo": "Metal Gear Solid V",
				"preco": "159,92",
				"capa": "/e-gammer/web_apps/images/site/capa/metal-gear-solid-v-capa.jpg",
				"descricao": "A Konami Digital Entertainment continua a Experiência do Metal Gear Solid V com o capítulo mais recente, Metal Gear Solid V: The Phantom Pain. Dando início a uma nova era para a série com a tecnologia de ponta possibilitada pela Fox Engine, Metal Gear Solid V: The Phantom Pain oferecerá aos jogadores uma experiência de primeira qualidade com a liberdade tática de executar missões em um mundo aberto."
			},
			{
				"id": 3,
				"titulo": "Nascar '14",
				"preco": "149,89",
				"capa": "/e-gammer/web_apps/images/site/capa/nascar-14-capa.jpg",
				"descricao": "Chegou a sua hora de participar para valer da emoção a toda velocidade da série de corridas mais eletrizante do mundo no NASCAR '14. Assuma a direção como seu piloto favorito e vivencie toda a experiência da semana de corrida com os desafios do treino, da qualificação e do dia da corrida. Com suas personalidades preferidas e o replay ao vivo, o NASCAR '14 é a experiência autêntica da NASCAR para os fãs."
			}];
		
		return {
			getGamesPromocao: gamesPromo,
			getGameCurrent: current,
			recuperar: get,
			listar: list
		};
		
		function gamesPromo(){
			var promo = [games[0], games[1], games[3], games[2]];
			return promo;
		};
		
		function current(){
			return game;
		};
		
		function get(id) {
		  return games[id];
		}
		
		function list() {
		  return games;
		}
		
		

		
		//return 0;
	}